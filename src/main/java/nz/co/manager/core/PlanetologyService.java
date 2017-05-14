package nz.co.manager.core;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.DisplayType;
import nz.co.manager.api.LandWaterDistribution;
import nz.co.manager.api.LandWaterMass;
import nz.co.manager.api.LandWaterMassResults;
import nz.co.manager.api.RegionType;
import nz.co.manager.api.WorldHydrography;
import nz.co.manager.api.WorldShape;
import nz.co.manager.api.WorldSize;
import nz.co.manager.jdbi.DisplayTypeDAO;
import nz.co.manager.jdbi.LandWaterDistributionDAO;
import nz.co.manager.jdbi.LandWaterMassDAO;
import nz.co.manager.jdbi.RegionTypeDAO;
import nz.co.manager.jdbi.WorldHydrographyDAO;
import nz.co.manager.jdbi.WorldShapeDAO;
import nz.co.manager.jdbi.WorldSizeDAO;

@Service
public class PlanetologyService {

	private final WorldShapeDAO worldShapeDAO;
	private final WorldSizeDAO worldSizeDAO;
	private final WorldHydrographyDAO worldHydrographyDAO;
	private final RegionTypeDAO regionTypeDAO;
	private final DisplayTypeDAO displayTypeDAO;
	private final LandWaterDistributionDAO landWaterDAO;
	private final LandWaterMassDAO landWaterMassDAO;
	private final DiceService diceService;

	@Inject
	public PlanetologyService(final WorldShapeDAO worldShapeDAO, final WorldSizeDAO worldSizeDAO,
			final WorldHydrographyDAO worldHydrographyDAO, final RegionTypeDAO regionTypeDAO,
			final DisplayTypeDAO displayTypeDAO, final LandWaterDistributionDAO landWaterDAO,
			final LandWaterMassDAO landWaterMassDAO, final DiceService diceService) {
		this.worldShapeDAO = worldShapeDAO;
		this.worldSizeDAO = worldSizeDAO;
		this.worldHydrographyDAO = worldHydrographyDAO;
		this.regionTypeDAO = regionTypeDAO;
		this.displayTypeDAO = displayTypeDAO;
		this.landWaterDAO = landWaterDAO;
		this.landWaterMassDAO = landWaterMassDAO;
		this.diceService = diceService;
	}

	public WorldShape createWorldShape(final WorldShape shape) {
		return worldShapeDAO.persist(shape);
	}

	public WorldShape updateWorldShape(final WorldShape shape) {
		return worldShapeDAO.persist(shape);
	}

	public WorldShape readWorldShape(final int id) {
		return worldShapeDAO.get(id);
	}

	public List<WorldShape> listWorldShapes() {
		return worldShapeDAO.listAll();
	}

	public void deleteWorldShape(final WorldShape shape) {
		worldShapeDAO.delete(shape);
	}

	public void deleteWorldShape(final int id) {
		final WorldShape shape = worldShapeDAO.get(id);
		worldShapeDAO.delete(shape);
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

	public WorldSize createWorldSize(final WorldSize size) {
		return worldSizeDAO.persist(size);
	}

	public WorldSize updateWorldSize(final WorldSize size) {
		return worldSizeDAO.persist(size);
	}

	public WorldSize readWorldSize(final int id) {
		return worldSizeDAO.get(id);
	}

	public List<WorldSize> listWorldSizes() {
		return worldSizeDAO.listAll();
	}

	public void deleteWorldSize(final WorldSize size) {
		worldSizeDAO.delete(size);
	}

	public void deleteWorldSize(final int id) {
		final WorldSize size = worldSizeDAO.get(id);
		worldSizeDAO.delete(size);
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

	public WorldHydrography createWorldHydrography(final WorldHydrography hook) {
		return worldHydrographyDAO.persist(hook);
	}

	public WorldHydrography updateWorldHydrography(final WorldHydrography hydro) {
		return worldHydrographyDAO.persist(hydro);
	}

	public WorldHydrography readWorldHydrography(final int id) {
		return worldHydrographyDAO.get(id);
	}

	public List<WorldHydrography> listWorldHydrographies() {
		return worldHydrographyDAO.listAll();
	}

	public void deleteWorldHydrography(final WorldHydrography hydro) {
		worldHydrographyDAO.delete(hydro);
	}

	public void deleteWorldHydrography(final int id) {
		final WorldHydrography hydro = worldHydrographyDAO.get(id);
		worldHydrographyDAO.delete(hydro);
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

	public RegionType createRegionType(final RegionType type) {
		return regionTypeDAO.persist(type);
	}

	public RegionType updateRegionType(final RegionType type) {
		return regionTypeDAO.persist(type);
	}

	public RegionType readRegionType(final int id) {
		return regionTypeDAO.get(id);
	}

	public List<RegionType> listRegionTypes() {
		return regionTypeDAO.listAll();
	}

	public void deleteRegionType(final RegionType type) {
		regionTypeDAO.delete(type);
	}

	public void deleteRegionType(final int id) {
		final RegionType type = regionTypeDAO.get(id);
		regionTypeDAO.delete(type);
	}

	public DisplayType createDisplayType(final DisplayType type) {
		return displayTypeDAO.persist(type);
	}

	public DisplayType updateDisplayType(final DisplayType type) {
		return displayTypeDAO.persist(type);
	}

	public DisplayType readDisplayType(final int id) {
		return displayTypeDAO.get(id);
	}

	public List<DisplayType> listDisplayTypes() {
		return displayTypeDAO.listAll();
	}

	public void deleteDisplayType(final DisplayType type) {
		displayTypeDAO.delete(type);
	}

	public void deleteDisplayType(final int id) {
		final DisplayType type = displayTypeDAO.get(id);
		displayTypeDAO.delete(type);
	}

	public LandWaterDistribution createLandWaterDistribution(final LandWaterDistribution dist) {
		return landWaterDAO.persist(dist);
	}

	public LandWaterDistribution updateLandWaterDistribution(final LandWaterDistribution dist) {
		return landWaterDAO.persist(dist);
	}

	public LandWaterDistribution readLandWaterDistribution(final int id) {
		return landWaterDAO.get(id);
	}

	public List<LandWaterDistribution> listLandWaterDistributions() {
		return landWaterDAO.listAll();
	}

	public void deleteLandWaterDistribution(final LandWaterDistribution dist) {
		landWaterDAO.delete(dist);
	}

	public void deleteLandWaterDistribution(final int id) {
		final LandWaterDistribution dist = landWaterDAO.get(id);
		landWaterDAO.delete(dist);
	}

	public LandWaterMass createLandWaterMass(final LandWaterMass dist) {
		return landWaterMassDAO.persist(dist);
	}

	public LandWaterMass updateLandWaterMass(final LandWaterMass dist) {
		return landWaterMassDAO.persist(dist);
	}

	public LandWaterMass readLandWaterMass(final int id) {
		return landWaterMassDAO.get(id);
	}

	public List<LandWaterMass> listLandWaterMasses() {
		return landWaterMassDAO.listAll();
	}

	public void deleteLandWaterMass(final LandWaterMass dist) {
		landWaterMassDAO.delete(dist);
	}

	public void deleteLandWaterMass(final int id) {
		final LandWaterMass dist = landWaterMassDAO.get(id);
		landWaterMassDAO.delete(dist);
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
		final List<Integer> positions = diceService.roll(20, numMasses);
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
}
