package nz.co.manager.core;

import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.SVGUtils;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.DisplayType;
import nz.co.manager.api.LandWaterDistribution;
import nz.co.manager.api.LandWaterMassResults;
import nz.co.manager.api.Region;
import nz.co.manager.api.RegionType;
import nz.co.manager.api.WorldHydrography;
import nz.co.manager.jdbi.DisplayTypeDAO;
import nz.co.manager.jdbi.LandWaterDistributionDAO;

@Service
public class WorldBuilderService {
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

	public void generate() throws ServiceException {
		final List<WorldHydrography> hydrographyList = worldHydrographyService.generate(1);
		final List<DisplayType> displayList = displayTypeDAO.getBy("Polyhedral");
		final WorldHydrography worldHydrography = hydrographyList.get(0);
		final DisplayType displayType = displayList.get(0);
		final List<LandWaterDistribution> distributionList = landWaterDistributionDAO.getBy(worldHydrography.getId(),
				displayType.getId());
		final List<RegionType> regionTypes = new ArrayList<>();
		distributionList.forEach(lwd -> {
			for (int count = 0; count < lwd.getNumRegions(); count++) {
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
		final LandWaterMassResults landWaterMassResults = landWaterMassService.generate(worldHydrography.getId(),
				displayType.getId());

		final Map<Integer, RegionType> regionMap = new HashMap<>();

		final int numPositions = landWaterMassResults.getPositions().size();
		for (int i = 0; i < numPositions; i++) {
			final List<Integer> positions = new ArrayList<>();
			int position = landWaterMassResults.getPositions().get(i);
			final int size = landWaterMassResults.getSizes().get(i);
			List<Integer> regions = diceService.roll(regionTypes.size(), 1);
			regionMap.put(position, regionTypes.remove(regions.get(0) - 1));
			positions.add(position);
			if (size > 1) {
				for (int j = 1; j < size; j++) {
					final List<Integer> adjacent = getAdjacentPositions(displayType, positions);
					position = adjacent.get(diceService.roll(adjacent.size(), 1).get(0) - 1);
					regions = diceService.roll(regionTypes.size(), 1);
					regionMap.put(position, regionTypes.remove(regions.get(0) - 1));
					positions.add(position);
				}
			}
		}

		// final SVGGraphics2D g2 = new SVGGraphics2D(600, 500);

		// drawTriangle(g2, 0, 0, 100);
	}

	private List<Integer> getAdjacentPositions(final DisplayType displayType, final List<Integer> positions) {
		final List<Integer> adjacent = new ArrayList<>();
		for (Integer p : positions) {
			for (Region r : displayType.getRegions()) {
				if (r.getNumber() == p) {
					for (Integer a : r.getAdjacentRegions()) {
						if (!adjacent.contains(a) && !positions.contains(a)) {
							adjacent.add(a);
						}
					}
				}
			}
		}
		return adjacent;
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
