package nz.co.manager.core;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.*;
import nz.co.manager.jdbi.*;

@Service
public class PlanetologyService {

	private static final int NUM_REGIONS_POLYHEDRAL = 20;
	private final WorldShapeDAO worldShapeDAO;
	private final WorldSizeDAO worldSizeDAO;
	private final WorldHydrographyDAO worldHydrographyDAO;
	private final RegionTypeDAO regionTypeDAO;
	private final DisplayTypeDAO displayTypeDAO;
	private final LandWaterDistributionDAO landWaterDAO;
	private final LandWaterMassDAO landWaterMassDAO;
	private final DiceService diceService;
	private final PlateMovementDAO plateMovementDAO;
	private final VolcanicActivityDAO volcanicActivityDAO;
	private final EarthquakeActivityDAO earthquakeActivityDAO;
	private final MountainPlacementDAO mountainPlacementDAO;
	private final MountainPropertyDAO mountainPropertyDAO;

	@Inject
	public PlanetologyService(final WorldShapeDAO worldShapeDAO, final WorldSizeDAO worldSizeDAO,
			final WorldHydrographyDAO worldHydrographyDAO, final RegionTypeDAO regionTypeDAO,
			final DisplayTypeDAO displayTypeDAO, final LandWaterDistributionDAO landWaterDAO,
			final LandWaterMassDAO landWaterMassDAO, final DiceService diceService,
			final PlateMovementDAO plateMovementDAO, final VolcanicActivityDAO volcanicActivityDAO,
			final EarthquakeActivityDAO earthquakeActivityDAO, final MountainPlacementDAO mountainPlacementDAO,
			final MountainPropertyDAO mountainPropertyDAO) {
		this.worldShapeDAO = worldShapeDAO;
		this.worldSizeDAO = worldSizeDAO;
		this.worldHydrographyDAO = worldHydrographyDAO;
		this.regionTypeDAO = regionTypeDAO;
		this.displayTypeDAO = displayTypeDAO;
		this.landWaterDAO = landWaterDAO;
		this.landWaterMassDAO = landWaterMassDAO;
		this.diceService = diceService;
		this.plateMovementDAO = plateMovementDAO;
		this.volcanicActivityDAO = volcanicActivityDAO;
		this.earthquakeActivityDAO = earthquakeActivityDAO;
		this.mountainPlacementDAO = mountainPlacementDAO;
		this.mountainPropertyDAO = mountainPropertyDAO;
	}

	public WorldShape createWorldShape(final WorldShape entity) {
		worldShapeDAO.add(entity);
		return entity;
	}

	public WorldShape updateWorldShape(final WorldShape entity) {
		worldShapeDAO.update(entity);
		return entity;
	}

	public WorldShape readWorldShape(final int id) {
		return worldShapeDAO.find(id);
	}

	public List<WorldShape> listWorldShapes() {
		return worldShapeDAO.list();
	}

	public void deleteWorldShape(final WorldShape entity) {
		worldShapeDAO.remove(entity);
	}

	public void deleteWorldShape(final int id) {
		final WorldShape entity = readWorldShape(id);
		deleteWorldShape(entity);
	}

	public List<WorldShape> generateWorldShape(final int times) throws ServiceException {
		final List<WorldShape> values = new ArrayList<>();

		final List<WorldShape> shapes = listWorldShapes();
		final WorldShape lastShape = shapes.get(shapes.size() - 1);
		final int max = lastShape.getMax();

		final DiceService diceService = new DiceService();
		final List<Integer> randomShapes = diceService.roll(max, times);

		for (int i : randomShapes) {
			for (WorldShape shape : shapes) {
				if (shape.getMin() <= i && shape.getMax() >= i) {
					values.add(shape);
				}
			}
		}
		return values;
	}

	public WorldSize createWorldSize(final WorldSize entity) {
		worldSizeDAO.add(entity);
		return entity;
	}

	public WorldSize updateWorldSize(final WorldSize entity) {
		worldSizeDAO.update(entity);
		return entity;
	}

	public WorldSize readWorldSize(final int id) {
		return worldSizeDAO.find(id);
	}

	public List<WorldSize> listWorldSizes() {
		return worldSizeDAO.list();
	}

	public void deleteWorldSize(final WorldSize entity) {
		worldSizeDAO.remove(entity);
	}

	public void deleteWorldSize(final int id) {
		final WorldSize entity = readWorldSize(id);
		deleteWorldSize(entity);
	}

	public List<WorldSize> generateWorldSize(final int times) throws ServiceException {
		final List<WorldSize> values = new ArrayList<>();

		final List<WorldSize> sizes = listWorldSizes();
		final WorldSize lastSize = sizes.get(sizes.size() - 1);
		final int max = lastSize.getMax();

		final DiceService diceService = new DiceService();
		final List<Integer> randomSizes = diceService.roll(max, times);

		for (int i : randomSizes) {
			for (WorldSize size : sizes) {
				if (size.getMin() <= i && size.getMax() >= i) {
					values.add(size);
				}
			}
		}
		return values;
	}

	public WorldHydrography createWorldHydrography(final WorldHydrography entity) {
		worldHydrographyDAO.add(entity);
		return entity;
	}

	public WorldHydrography updateWorldHydrography(final WorldHydrography entity) {
		worldHydrographyDAO.update(entity);
		return entity;
	}

	public WorldHydrography readWorldHydrography(final int id) {
		return worldHydrographyDAO.find(id);
	}

	public List<WorldHydrography> listWorldHydrographies() {
		return worldHydrographyDAO.list();
	}

	public void deleteWorldHydrography(final WorldHydrography entity) {
		worldHydrographyDAO.remove(entity);
	}

	public void deleteWorldHydrography(final int id) {
		final WorldHydrography entity = readWorldHydrography(id);
		deleteWorldHydrography(entity);
	}

	public List<WorldHydrography> generateWorldHydrography(final int times) throws ServiceException {
		final List<WorldHydrography> values = new ArrayList<>();

		final List<WorldHydrography> hydrographies = listWorldHydrographies();
		final WorldHydrography lastHydrography = hydrographies.get(hydrographies.size() - 1);
		final int max = lastHydrography.getMax();

		final DiceService diceService = new DiceService();
		final List<Integer> randomHydrographies = diceService.roll(max, times);

		for (int i : randomHydrographies) {
			for (WorldHydrography hydrography : hydrographies) {
				if (hydrography.getMin() <= i && hydrography.getMax() >= i) {
					values.add(hydrography);
				}
			}
		}
		return values;
	}

	public RegionType createRegionType(final RegionType entity) {
		regionTypeDAO.add(entity);
		return entity;
	}

	public RegionType updateRegionType(final RegionType entity) {
		regionTypeDAO.update(entity);
		return entity;
	}

	public RegionType readRegionType(final int id) {
		return regionTypeDAO.find(id);
	}

	public List<RegionType> listRegionTypes() {
		return regionTypeDAO.list();
	}

	public void deleteRegionType(final RegionType entity) {
		regionTypeDAO.remove(entity);
	}

	public void deleteRegionType(final int id) {
		final RegionType entity = readRegionType(id);
		deleteRegionType(entity);
	}

	public DisplayType createDisplayType(final DisplayType entity) {
		displayTypeDAO.add(entity);
		return entity;
	}

	public DisplayType updateDisplayType(final DisplayType entity) {
		displayTypeDAO.update(entity);
		return entity;
	}

	public DisplayType readDisplayType(final int id) {
		return displayTypeDAO.find(id);
	}

	public List<DisplayType> listDisplayTypes() {
		return displayTypeDAO.list();
	}

	public void deleteDisplayType(final DisplayType entity) {
		displayTypeDAO.remove(entity);
	}

	public void deleteDisplayType(final int id) {
		final DisplayType entity = readDisplayType(id);
		deleteDisplayType(entity);
	}

	public LandWaterDistribution createLandWaterDistribution(final LandWaterDistribution entity) {
		landWaterDAO.add(entity);
		return entity;
	}

	public LandWaterDistribution updateLandWaterDistribution(final LandWaterDistribution entity) {
		landWaterDAO.update(entity);
		return entity;
	}

	public LandWaterDistribution readLandWaterDistribution(final int id) {
		return landWaterDAO.find(id);
	}

	public List<LandWaterDistribution> listLandWaterDistributions() {
		return landWaterDAO.list();
	}

	public void deleteLandWaterDistribution(final LandWaterDistribution entity) {
		landWaterDAO.remove(entity);
	}

	public void deleteLandWaterDistribution(final int id) {
		final LandWaterDistribution entity = readLandWaterDistribution(id);
		deleteLandWaterDistribution(entity);
	}

	public LandWaterMass createLandWaterMass(final LandWaterMass entity) {
		landWaterMassDAO.add(entity);
		return entity;
	}

	public LandWaterMass updateLandWaterMass(final LandWaterMass entity) {
		landWaterMassDAO.update(entity);
		return entity;
	}

	public LandWaterMass readLandWaterMass(final int id) {
		return landWaterMassDAO.find(id);
	}

	public List<LandWaterMass> listLandWaterMasses() {
		return landWaterMassDAO.list();
	}

	public void deleteLandWaterMass(final LandWaterMass entity) {
		landWaterMassDAO.remove(entity);
	}

	public void deleteLandWaterMass(final int id) {
		final LandWaterMass entity = readLandWaterMass(id);
		deleteLandWaterMass(entity);
	}

	public LandWaterMassResults generateLandWaterMasses(final int hydrographyId, final int displayTypeId)
			throws ServiceException {
		final LandWaterMassResults results = new LandWaterMassResults();
		final int numRegions = getNumRegions(hydrographyId, displayTypeId);
		if (numRegions == 0) {
			return results;
		}
		final LandWaterMass mass = landWaterMassDAO.getBy(numRegions);
		results.setMass(mass);
		final String numMassesData = results.getMass().getNumMasses();
		List<Integer> rolls;
		try {
			rolls = diceService.roll(numMassesData, 1);
		} catch (ServiceException e) {
			rolls = diceService.roll(results.getMass().getMaxSize(), 1);
		}
		final int numMasses = rolls.get(0);
		final List<Integer> positions = diceService.roll(NUM_REGIONS_POLYHEDRAL, numMasses);
		results.setPositions(positions);
		final List<Integer> sizes = diceService.roll(results.getMass().getMaxSize(), numMasses);
		results.setSizes(sizes);
		int totalSize = 0;
		for (int i = 0; i < sizes.size(); i++) {
			if (totalSize + sizes.get(i) > numRegions) {
				sizes.set(i, 1);
			}
			totalSize += sizes.get(i);
		}
		if (totalSize < numRegions) {
			sizes.set(numMasses - 1, sizes.get(numMasses - 1) + numRegions - totalSize);
		}
		return results;
	}

	private int getNumRegions(final int hydrographyId, final int displayTypeId) {
		List<LandWaterDistribution> distributions = landWaterDAO.getBy(hydrographyId, displayTypeId);
		WorldHydrography hydrography = readWorldHydrography(hydrographyId);
		int numRegions = 0;
		for (LandWaterDistribution d : distributions) {
			if (hydrography.getPercent() > 50) {
				if (d.getRegionType().getName().contains("Land")) {
					numRegions += d.getNumRegions();
				}
			} else {
				if (d.getRegionType().getName().contains("Water")) {
					numRegions += d.getNumRegions();
				}
			}
		}
		return numRegions;
	}

	public List<PlateResults> generatePlates(final int times) throws ServiceException {
		final List<PlateResults> results = new ArrayList<>();
		final List<Integer> rolls = new DiceService().roll("4d4", times);
		for (int numPlates : rolls) {
			final PlateResults result = new PlateResults();
			final List<Integer> positions = diceService.roll(NUM_REGIONS_POLYHEDRAL, numPlates);
			result.setPositions(positions);
			final List<Integer> sizes = diceService.roll("1d6", numPlates);
			result.setSizes(sizes);
			int totalSize = 0;
			for (int i = 0; i < sizes.size(); i++) {
				if (totalSize + sizes.get(i) > NUM_REGIONS_POLYHEDRAL) {
					sizes.set(i, 1);
				}
				totalSize += sizes.get(i);
			}
			if (totalSize < NUM_REGIONS_POLYHEDRAL) {
				sizes.set(numPlates - 1, sizes.get(numPlates - 1) + NUM_REGIONS_POLYHEDRAL - totalSize);
			}
			results.add(result);
		}
		return results;
	}

	public PlateMovement createPlateMovement(final PlateMovement entity) {
		plateMovementDAO.add(entity);
		return entity;
	}

	public PlateMovement updatePlateMovement(final PlateMovement entity) {
		plateMovementDAO.update(entity);
		return entity;
	}

	public PlateMovement readPlateMovement(final int id) {
		return plateMovementDAO.find(id);
	}

	public List<PlateMovement> listPlateMovements() {
		return plateMovementDAO.list();
	}

	public void deletePlateMovement(final PlateMovement entity) {
		plateMovementDAO.remove(entity);
	}

	public void deletePlateMovement(final int id) {
		final PlateMovement entity = readPlateMovement(id);
		deletePlateMovement(entity);
	}

	public VolcanicActivity createVolcanicActivity(final VolcanicActivity entity) {
		volcanicActivityDAO.add(entity);
		return entity;
	}

	public VolcanicActivity updateVolcanicActivity(final VolcanicActivity entity) {
		volcanicActivityDAO.update(entity);
		return entity;
	}

	public VolcanicActivity readVolcanicActivity(final int id) {
		return volcanicActivityDAO.find(id);
	}

	public List<VolcanicActivity> listVolcanicActivities() {
		return volcanicActivityDAO.list();
	}

	public void deleteVolcanicActivity(final VolcanicActivity entity) {
		volcanicActivityDAO.remove(entity);
	}

	public void deleteVolcanicActivity(final int id) {
		final VolcanicActivity entity = readVolcanicActivity(id);
		deleteVolcanicActivity(entity);
	}

	public EarthquakeActivity createEarthquakeActivity(final EarthquakeActivity entity) {
		earthquakeActivityDAO.add(entity);
		return entity;
	}

	public EarthquakeActivity updateEarthquakeActivity(final EarthquakeActivity entity) {
		earthquakeActivityDAO.update(entity);
		return entity;
	}

	public EarthquakeActivity readEarthquakeActivity(final int id) {
		return earthquakeActivityDAO.find(id);
	}

	public List<EarthquakeActivity> listEarthquakeActivities() {
		return earthquakeActivityDAO.list();
	}

	public void deleteEarthquakeActivity(final EarthquakeActivity entity) {
		earthquakeActivityDAO.remove(entity);
	}

	public void deleteEarthquakeActivity(final int id) {
		final EarthquakeActivity entity = readEarthquakeActivity(id);
		deleteEarthquakeActivity(entity);
	}

	public Set<EarthquakeStrength> listEarthquakeStrengths() {
		return EnumSet.allOf(EarthquakeStrength.class);
	}

	public Set<EarthquakeFrequency> listEarthquakeFrequencies() {
		return EnumSet.allOf(EarthquakeFrequency.class);
	}

	public MountainPlacement createMountainPlacement(final MountainPlacement entity) {
		mountainPlacementDAO.add(entity);
		return entity;
	}

	public MountainPlacement updateMountainPlacement(final MountainPlacement entity) {
		mountainPlacementDAO.update(entity);
		return entity;
	}

	public MountainPlacement readMountainPlacement(final int id) {
		return mountainPlacementDAO.find(id);
	}

	public List<MountainPlacement> listMountainPlacements() {
		return mountainPlacementDAO.list();
	}

	public void deleteMountainPlacement(final MountainPlacement entity) {
		mountainPlacementDAO.remove(entity);
	}

	public void deleteMountainPlacement(final int id) {
		final MountainPlacement entity = readMountainPlacement(id);
		deleteMountainPlacement(entity);
	}

	public MountainProperty createMountainProperty(final MountainProperty entity) {
		mountainPropertyDAO.add(entity);
		return entity;
	}

	public MountainProperty updateMountainProperty(final MountainProperty entity) {
		mountainPropertyDAO.update(entity);
		return entity;
	}

	public MountainProperty readMountainProperty(final int id) {
		return mountainPropertyDAO.find(id);
	}

	public List<MountainProperty> listMountainProperties() {
		return mountainPropertyDAO.list();
	}

	public void deleteMountainProperty(final MountainProperty entity) {
		mountainPropertyDAO.remove(entity);
	}

	public void deleteMountainProperty(final int id) {
		final MountainProperty entity = readMountainProperty(id);
		deleteMountainProperty(entity);
	}
}
