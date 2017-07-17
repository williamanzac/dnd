package nz.co.manager.core;

import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.SVGUtils;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.DisplayType;
import nz.co.manager.api.LandWaterDistribution;
import nz.co.manager.api.LandWaterMassResults;
import nz.co.manager.api.RegionType;
import nz.co.manager.api.WorldHydrography;
import nz.co.manager.jdbi.DisplayTypeDAO;
import nz.co.manager.jdbi.LandWaterDistributionDAO;

@Service
public class WorldBuilderService {
	private static final Logger log = Logger.getLogger(WorldBuilderService.class);

	private final WorldHydrographyService worldHydrographyService;
	private final LandWaterMassService landWaterMassService;
	private final LandWaterDistributionDAO landWaterDistributionDAO;
	private final DisplayTypeDAO displayTypeDAO;
	private final DiceService diceService;

	@Inject
	public WorldBuilderService(final WorldHydrographyService worldHydrographyService,
			final LandWaterMassService landWaterMassService, final LandWaterDistributionDAO landWaterDistributionDAO,
			final DisplayTypeDAO displayTypeDAO, final DiceService diceService) {
		this.worldHydrographyService = worldHydrographyService;
		this.landWaterMassService = landWaterMassService;
		this.landWaterDistributionDAO = landWaterDistributionDAO;
		this.displayTypeDAO = displayTypeDAO;
		this.diceService = diceService;
	}

	/**
	 * Generate a world map
	 * 
	 * @throws ServiceException
	 */
	public void generate() throws ServiceException {
		// generate a random world hydrography
		final List<WorldHydrography> hydrographyList = worldHydrographyService.generate(1);
		final WorldHydrography worldHydrography = hydrographyList.get(0);
		// get the polyhedral display type
		final List<DisplayType> displayList = displayTypeDAO.getBy("Polyhedral");
		final DisplayType displayType = displayList.get(0);

		// get Land and Water distribution for the hydrography and display type
		final List<LandWaterDistribution> distributionList = landWaterDistributionDAO.getBy(worldHydrography.getId(),
				displayType.getId());
		// build a list of selectable regions
		final List<RegionType> regionTypes = new ArrayList<>();
		final List<RegionType> allRegionTypes = new ArrayList<>();
		distributionList.forEach(lwd -> {
			for (int count = 0; count < lwd.getNumRegions(); count++) {
				allRegionTypes.add(lwd.getRegionType());
				if (worldHydrography.getPercent() > 50) {
					if (lwd.getRegionType().getName().contains("Land")) {
						regionTypes.add(lwd.getRegionType());
					}
				} else {
					if (lwd.getRegionType().getName().contains("Water")) {
						regionTypes.add(lwd.getRegionType());
					}
				}
			}
		});
		// get the land and water mass for the hydrography and display type
		final LandWaterMassResults landWaterMassResults = landWaterMassService.generate(worldHydrography.getId(),
				displayType.getId());

		// build a position to region type map
		final Map<Integer, RegionType> regionMap = new HashMap<>();
		if (landWaterMassResults != null) {
			// allocate masses first
			final List<Integer> massPositions = landWaterMassResults.getPositions();
			final List<Integer> sizes = landWaterMassResults.getSizes();
			for (int i = 0; i < massPositions.size(); i++) {
				// create a list of positions for this mass
				final List<Integer> positions = new ArrayList<>();
				// get the start position and mass size
				int position = massPositions.get(i);
				final int size = sizes.get(i);
				// choose a region type
				RegionType regionType = getRegionType(regionTypes);
				regionMap.put(position, regionType);
				positions.add(position);
				allRegionTypes.remove(regionType);

				for (int j = 1; j < size; j++) {
					// get a list of adjacent positions
					final List<Integer> adjacent = getAdjacentPositions(displayType, positions, massPositions);
					// choose a position from the adjacent list
					position = getPosition(adjacent);
					// choose a region type
					regionType = getRegionType(regionTypes);
					regionMap.put(position, regionType);
					positions.add(position);
					allRegionTypes.remove(regionType);
				}
			}
		}

		// allocate remaining region types
		for (int i = 1; i <= displayType.getNumRegions(); i++) {
			if (regionMap.containsKey(i)) {
				continue;
			}
			final RegionType regionType = getRegionType(allRegionTypes);
			regionMap.put(i, regionType);
		}

		log.info(regionMap);

		// final SVGGraphics2D g2 = new SVGGraphics2D(600, 500);

		// drawTriangle(g2, 0, 0, 100);
	}

	private int getPosition(final List<Integer> adjacent) throws ServiceException {
		int position;
		final List<Integer> adjacentRegions = diceService.roll(adjacent.size(), 1);
		final int index = adjacentRegions.get(0) - 1;
		position = adjacent.get(index);
		return position;
	}

	private RegionType getRegionType(final List<RegionType> regionTypes) throws ServiceException {
		final List<Integer> regions = diceService.roll(regionTypes.size(), 1);
		final int index = regions.get(0) - 1;
		final RegionType regionType = regionTypes.remove(index);
		return regionType;
	}

	private List<Integer> getAdjacentPositions(final DisplayType displayType, final List<Integer> positions,
			final List<Integer> massPositions) {
		final Set<Integer> adjacent = new HashSet<>();
		displayType.getRegions().stream().filter(r -> positions.contains(r.getNumber())).forEach(r -> {
			r.getAdjacentRegions().stream().filter(a -> !positions.contains(a) && !massPositions.contains(a))
					.forEach(a -> {
						adjacent.add(a);
					});
		});
		return new ArrayList<>(adjacent);
	}

	private static void drawTriangle(final SVGGraphics2D g2, final double x, final double y, final int length) {
		final GeneralPath path = new GeneralPath();
		final double angle = Math.toRadians(-90);
		final double r = length / 2.0 / Math.sin(Math.PI * 60. / 180.);
		final double[] tX = new double[3];
		final double[] tY = new double[3];

		for (int i = 0; i < 3; i++) {
			tX[i] = x + r * Math.cos(angle + i * 2. * Math.PI / 3.);
			tY[i] = y + r * Math.sin(angle + i * 2. * Math.PI / 3.);
		}

		path.moveTo(tX[0], tY[0]);
		path.lineTo(tX[1], tY[1]);
		path.lineTo(tX[2], tY[2]);
		path.closePath();

		g2.draw(path);
	}

	public static void main(final String[] args) throws IOException {
		final SVGGraphics2D g2 = new SVGGraphics2D(600, 300);
		drawTriangle(g2, 0, 0, 100);
		final File f = new File("triangle.svg");
		SVGUtils.writeToSVG(f, g2.getSVGElement());
	}
}
