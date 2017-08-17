package nz.co.manager.core;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jvnet.hk2.annotations.Service;

import com.flowpowered.noise.NoiseQuality;
import com.flowpowered.noise.module.source.Perlin;

import nz.co.manager.api.DisplayType;
import nz.co.manager.api.LandWaterDistribution;
import nz.co.manager.api.LandWaterMassResults;
import nz.co.manager.api.RegionType;
import nz.co.manager.api.WorldHydrography;
import nz.co.manager.jdbi.LandWaterDistributionDAO;

@Service
public class WorldBuilderService {
	private static final Logger log = Logger.getLogger(WorldBuilderService.class);

	private final WorldHydrographyService worldHydrographyService;
	private final LandWaterMassService landWaterMassService;
	private final LandWaterDistributionDAO landWaterDistributionDAO;
	private final DisplayTypeService displayTypeService;
	private final DiceService diceService;
	private final RandomService randomService;

	public static class Center {
		public int index;

		public Point2D point; // location
		public boolean water; // lake or ocean
		public boolean ocean; // ocean
		public boolean coast; // land polygon touching an ocean
		public boolean border; // at the edge of the map
		public String biome; // biome type (see article)
		public double elevation; // 0.0-1.0
		public double moisture; // 0.0-1.0

		public List<Center> neighbors;
		public List<Edge> borders;
		public List<Corner> corners;
	}

	public static class Corner {
		public int index;

		public Point2D point; // location
		public boolean ocean; // ocean
		public boolean water; // lake or ocean
		public boolean coast; // touches ocean and land polygons
		public boolean border; // at the edge of the map
		public double elevation; // 0.0-1.0
		public double moisture; // 0.0-1.0

		public List<Center> touches;
		public List<Edge> protrudes;
		public List<Corner> adjacent;

		public int river; // 0 if no river, or volume of water in river
		public Corner downslope; // pointer to adjacent corner most downhill
		public Corner watershed; // pointer to coastal corner, or null
		public int watershed_size;
	}

	public static class Edge {
		public int index;
		public Center d0, d1; // Delaunay edge
		public Corner v0, v1; // Voronoi edge
		public Point2D midpoint; // halfway between v0,v1
		public int river; // volume of water, or 0
	}

	public class Mass {
		final List<MapRegion> regions = new ArrayList<>();

		public List<MapRegion> getRegions() {
			return regions;
		}

		public void addRegion(final MapRegion region) {
			regions.add(region);
		}
	}

	public class MapRegion {
		final Point2D center;
		final List<Point2D> corners;
		RegionType type;
		final Set<MapRegion> adjacentRegions = new HashSet<>();
		final List<Hex> hexes = new ArrayList<>();

		public MapRegion(final List<Point2D> corners) {
			this(corners, null);
		}

		public MapRegion(final List<Point2D> corners, final RegionType type) {
			this.corners = corners;
			double totalx = 0;
			double totaly = 0;
			for (final Point2D p : corners) {
				totalx += p.getX();
				totaly += p.getY();
			}
			final double centerx = totalx / corners.size();
			final double centery = totaly / corners.size();
			center = new Point2D.Double(centerx, centery);
			this.type = type;
		}

		public void addAdjacentRegion(final MapRegion region) {
			adjacentRegions.add(region);
			region.adjacentRegions.add(this); // do not use addAdjacentRegion, would cause infinite loop.
		}

		public void addHex(final Hex hex) {
			hexes.add(hex);
			hex.regions.add(this);
		}
	}

	public class Hex {
		final Point2D center;
		final List<Point2D> corners;
		final Set<Hex> adjacentHexes = new HashSet<>();
		final Set<MapRegion> regions = new HashSet<>();
		boolean water;

		public Hex(final double x, final double y) {
			center = new Point2D.Double(x, y);
			corners = new ArrayList<>();
			final double d = DisplayTypeService.length / 8.;
			final double D = d * 2. / Math.sqrt(3.);
			final double angle = Math.toRadians(-90);
			final double R = D / 2.0;

			for (int i = 0; i < 6; i++) {
				final double x2 = x + R * Math.cos(angle + i * 2. * Math.PI / 6.);
				final double y2 = y + R * Math.sin(angle + i * 2. * Math.PI / 6.);
				corners.add(new Point2D.Double(x2, y2));
			}
		}

		public void addAdjacentHex(final Hex hex) {
			adjacentHexes.add(hex);
			hex.adjacentHexes.add(this);
		}
	}

	@Inject
	public WorldBuilderService(final WorldHydrographyService worldHydrographyService,
			final LandWaterMassService landWaterMassService, final LandWaterDistributionDAO landWaterDistributionDAO,
			final DisplayTypeService displayTypeService, final DiceService diceService,
			final RandomService randomService) {
		this.worldHydrographyService = worldHydrographyService;
		this.landWaterMassService = landWaterMassService;
		this.landWaterDistributionDAO = landWaterDistributionDAO;
		this.displayTypeService = displayTypeService;
		this.diceService = diceService;
		this.randomService = randomService;
	}

	/**
	 * Generate a world map
	 *
	 * @throws ServiceException
	 */
	public String generate(final Long seed, final int worldHydrographyId, final int displayTypeId)
			throws ServiceException {
		final WorldHydrography worldHydrography = worldHydrographyService.read(worldHydrographyId);
		final DisplayType displayType = displayTypeService.read(displayTypeId);
		if (seed != null) {
			randomService.setSeed(seed);
		}

		final Map<Integer, MapRegion> mapRegions = getMapRegions(displayType);

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
		// final Map<Integer, RegionType> regionMap = new HashMap<>();
		final List<Mass> masses = new ArrayList<>();
		if (landWaterMassResults != null) {
			// allocate masses first
			final List<Integer> massPositions = landWaterMassResults.getPositions();
			final List<Integer> sizes = landWaterMassResults.getSizes();
			for (int i = 0; i < massPositions.size(); i++) {
				final Mass mass = new Mass();
				// create a list of positions for this mass
				final List<Integer> positions = new ArrayList<>();
				// get the start position and mass size
				int position = massPositions.get(i);
				final int size = sizes.get(i);
				// choose a region type
				MapRegion mapRegion = mapRegions.get(position);
				mass.addRegion(mapRegion);
				mapRegion.type = getRegion(position, regionTypes, allRegionTypes);

				for (int j = 1; j < size; j++) {
					// get a list of adjacent positions
					final List<Integer> adjacent = getAdjacentPositions(displayType, positions, massPositions);
					// choose a position from the adjacent list
					position = getPosition(adjacent);
					if (position < 0) {
						continue;
					}
					// choose a region type
					mapRegion = mapRegions.get(position);
					mapRegion.type = getRegion(position, regionTypes, allRegionTypes);
				}

				masses.add(mass);
			}
		}

		// allocate remaining region types
		for (int i = 1; i <= displayType.getNumRegions(); i++) {
			final MapRegion mapRegion = mapRegions.get(i);
			if (mapRegion.type != null) {
				continue;
			}
			final RegionType regionType = getRegionType(allRegionTypes);
			mapRegion.type = regionType;
		}

		createMasses(mapRegions, seed);

		log.info(mapRegions);

		final StringBuilder builder = drawMap(displayType, mapRegions);
		return builder.toString();
	}

	private void createMasses(final Map<Integer, MapRegion> mapRegions, final long baseSeed) {
		final Perlin generator = new Perlin();
		generator.setOctaveCount(8);
		generator.setNoiseQuality(NoiseQuality.BEST);
		generator.setFrequency(64);
		mapRegions.values().forEach(region -> {
			final int seed = (int) baseSeed + region.hashCode();
			generator.setSeed(seed);
			region.hexes.forEach(h -> {
				final double value = generator.getValue(h.center.getX(), h.center.getY(), 0);
				// final double distanceSq = region.center.distanceSq(h.center) / DisplayTypeService.length;
				// double threshold = 0.3 + 0.3 * distanceSq;
				h.water = value < 0;
			});
		});
	}

	private Map<Integer, MapRegion> getMapRegions(final DisplayType displayType) {
		final Map<Integer, MapRegion> mapRegions = new HashMap<>();
		displayType.getRegions().forEach(region -> {
			final Integer number = region.getNumber();
			final List<Point2D> regionPoints = displayTypeService.getRegionPoints(displayType, number);
			final MapRegion mapRegion = new MapRegion(regionPoints);
			mapRegions.put(number, mapRegion);

			final double d = DisplayTypeService.length / 8.;
			final double hexHeight = Math.sqrt(Math.pow(d, 2) - Math.pow(d / 2, 2));
			final Map<Integer, Hex> hexMap = new HashMap<>();
			int hexNum = 0;
			switch (number) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 8:
			case 10:
			case 12:
			case 14:
				for (int row = 0; row < 9; row++) {
					for (int i = 0; i < 9 - row; i++) {
						hexNum++;
						final Hex hex = new Hex(
								regionPoints.get(0).getX() - DisplayTypeService.length / 2 + d / 2 * row + d * i,
								regionPoints.get(0).getY() + DisplayTypeService.rowheight - hexHeight * row);
						mapRegion.addHex(hex);
						hexMap.put(hexNum, hex);
					}
				}
				break;
			case 7:
			case 9:
			case 11:
			case 13:
			case 15:
			case 16:
			case 17:
			case 18:
			case 19:
			case 20:
				for (int row = 0; row < 9; row++) {
					for (int i = 0; i < 9 - row; i++) {
						hexNum++;
						final Hex hex = new Hex(
								regionPoints.get(0).getX() - DisplayTypeService.length / 2 + d / 2 * row + d * i,
								regionPoints.get(0).getY() - DisplayTypeService.rowheight + hexHeight * row);
						mapRegion.addHex(hex);
						hexMap.put(hexNum, hex);
					}
				}
				break;
			}
			hexNum = 0;
			for (int row = 0; row < 9; row++) {
				final int rowLength = 9 - row;
				for (int i = 0; i < rowLength; i++) {
					hexNum++;
					final Hex hex = hexMap.get(hexNum);
					if (i > 0) {
						final Hex adjacentHex = hexMap.get(hexNum - 1);
						if (adjacentHex == null) {
							log.debug("adjacent hex null");
						}
						hex.addAdjacentHex(adjacentHex);
					}
					if (i < rowLength - 1) {
						final Hex adjacentHex = hexMap.get(hexNum + 1);
						if (adjacentHex == null) {
							log.debug("adjacent hex null");
						}
						hex.addAdjacentHex(adjacentHex);
					}
					if (row > 0) {
						Hex adjacentHex = hexMap.get(hexNum - rowLength);
						if (adjacentHex == null) {
							log.debug("adjacent hex null");
						}
						hex.addAdjacentHex(adjacentHex);
						adjacentHex = hexMap.get(hexNum - (rowLength + 1));
						if (adjacentHex == null) {
							log.debug("adjacent hex null");
						}
						hex.addAdjacentHex(adjacentHex);
					}
				}
			}
		});
		displayType.getRegions().forEach(region -> {
			final MapRegion mapRegion = mapRegions.get(region.getNumber());
			region.getAdjacentRegions().forEach(a -> {
				final MapRegion adjacentRegion = mapRegions.get(a);
				mapRegion.addAdjacentRegion(adjacentRegion);
			});
		});
		return mapRegions;
	}

	private StringBuilder drawMap(final DisplayType displayType, final Map<Integer, MapRegion> mapRegions) {
		final SVGGraphics2D g2 = new SVGGraphics2D(600, 300);

		g2.setBackground(Color.GRAY);
		g2.clearRect(0, 0, 600, 300);

		for (final Entry<Integer, MapRegion> entry : mapRegions.entrySet()) {
			drawRegion(g2, displayType, entry.getValue(), entry.getKey());
		}

		final StringBuilder builder = new StringBuilder(
				"<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n");
		builder.append(g2.getSVGElement());
		return builder;
	}

	private RegionType getRegion(final int position, final List<RegionType> regionTypes,
			final List<RegionType> allRegionTypes) throws ServiceException {
		final RegionType regionType = getRegionType(regionTypes);
		if (regionType != null) {
			allRegionTypes.remove(regionType);
		}

		return regionType;
	}

	private int getPosition(final List<Integer> adjacent) throws ServiceException {
		if (adjacent.isEmpty()) {
			return -1;
		}
		final List<Integer> adjacentRegions = diceService.roll(adjacent.size(), 1);
		final int index = adjacentRegions.get(0) - 1;
		return adjacent.get(index);
	}

	private RegionType getRegionType(final List<RegionType> regionTypes) throws ServiceException {
		if (regionTypes.isEmpty()) {
			return null;
		}
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

	public void drawRegion(final Graphics2D g2, final DisplayType displayType, final MapRegion region,
			final int number) {
		final List<Point2D> regionPoints = region.corners;
		final GeneralPath path = new GeneralPath();
		path.moveTo(regionPoints.get(0).getX(), regionPoints.get(0).getY());
		for (int i = 1; i < regionPoints.size(); i++) {
			path.lineTo(regionPoints.get(i).getX(), regionPoints.get(i).getY());
		}
		path.closePath();

		g2.setClip(null);
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(0.3f));
		drawPath(g2, regionPoints);

		g2.setStroke(new BasicStroke(0.1f));
		g2.setClip(path);
		region.hexes.forEach(h -> {
			// g2.setColor(Color.BLACK);
			// h.adjacentHexes.forEach(a -> {
			// final Line2D.Double line = new Line2D.Double(h.center, a.center);
			// g2.draw(line);
			// });
			drawHex(g2, h);
		});

		// g2.setColor(Color.RED);
		// final Shape s = new Ellipse2D.Double(region.center.getX() - 1.5, region.center.getY() - 1.5, 3, 3);
		// g2.fill(s);
	}

	private void drawPath(final Graphics2D g2, final List<Point2D> list) {
		final GeneralPath path = new GeneralPath();

		path.moveTo(list.get(0).getX(), list.get(0).getY());
		for (int i = 1; i < list.size(); i++) {
			path.lineTo(list.get(i).getX(), list.get(i).getY());
		}
		path.closePath();

		g2.draw(path);
	}

	private void fillPath(final Graphics2D g2, final List<Point2D> list, final Color fillColor) {
		final GeneralPath path = new GeneralPath();

		path.moveTo(list.get(0).getX(), list.get(0).getY());
		for (int i = 1; i < list.size(); i++) {
			path.lineTo(list.get(i).getX(), list.get(i).getY());
		}
		path.closePath();

		g2.setColor(fillColor);
		g2.fill(path);
	}

	private void drawHex(final Graphics2D g2, final Hex hex) {
		final List<Point2D> list = hex.corners;

		fillPath(g2, list, hex.water ? Color.CYAN : Color.GREEN.darker().darker());

		// g2.setColor(Color.WHITE);
		// drawPath(g2, list);
		// for (final Point2D p : list) {
		// g2.setColor(Color.BLUE);
		// final Shape s = new Ellipse2D.Double(p.getX() - 1, p.getY() - 1, 2, 2);
		// g2.fill(s);
		// }

		// g2.setColor(Color.RED);
		// final Shape s = new Ellipse2D.Double(hex.center.getX() - 1, hex.center.getY() - 1, 2, 2);
		// g2.fill(s);
	}
}
