package nz.co.manager.core;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.WorldHydrography;
import nz.co.manager.api.WorldShape;
import nz.co.manager.api.WorldSize;
import nz.co.manager.jdbi.WorldHydrographyDAO;
import nz.co.manager.jdbi.WorldShapeDAO;
import nz.co.manager.jdbi.WorldSizeDAO;

@Service
public class PlanetologyService {

	private final WorldShapeDAO worldShapeDAO;
	private final WorldSizeDAO worldSizeDAO;
	private final WorldHydrographyDAO worldHydrographyDAO;

	@Inject
	public PlanetologyService(final WorldShapeDAO worldShapeDAO, final WorldSizeDAO worldSizeDAO,
			final WorldHydrographyDAO worldHydrographyDAO) {
		this.worldShapeDAO = worldShapeDAO;
		this.worldSizeDAO = worldSizeDAO;
		this.worldHydrographyDAO = worldHydrographyDAO;
	}

	public WorldShape createWorldShape(final WorldShape hook) {
		return worldShapeDAO.persist(hook);
	}

	public WorldShape updateWorldShape(final WorldShape hook) {
		return worldShapeDAO.persist(hook);
	}

	public WorldShape readWorldShape(final int id) {
		return worldShapeDAO.get(id);
	}

	public List<WorldShape> listWorldShapes() {
		return worldShapeDAO.listAll();
	}

	public void deleteWorldShape(final WorldShape hook) {
		worldShapeDAO.delete(hook);
	}

	public void deleteWorldShape(final int id) {
		final WorldShape hook = worldShapeDAO.get(id);
		worldShapeDAO.delete(hook);
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

	public WorldSize createWorldSize(final WorldSize hook) {
		return worldSizeDAO.persist(hook);
	}

	public WorldSize updateWorldSize(final WorldSize hook) {
		return worldSizeDAO.persist(hook);
	}

	public WorldSize readWorldSize(final int id) {
		return worldSizeDAO.get(id);
	}

	public List<WorldSize> listWorldSizes() {
		return worldSizeDAO.listAll();
	}

	public void deleteWorldSize(final WorldSize hook) {
		worldSizeDAO.delete(hook);
	}

	public void deleteWorldSize(final int id) {
		final WorldSize hook = worldSizeDAO.get(id);
		worldSizeDAO.delete(hook);
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

	public WorldHydrography updateWorldHydrography(final WorldHydrography hook) {
		return worldHydrographyDAO.persist(hook);
	}

	public WorldHydrography readWorldHydrography(final int id) {
		return worldHydrographyDAO.get(id);
	}

	public List<WorldHydrography> listWorldHydrographies() {
		return worldHydrographyDAO.listAll();
	}

	public void deleteWorldHydrography(final WorldHydrography hook) {
		worldHydrographyDAO.delete(hook);
	}

	public void deleteWorldHydrography(final int id) {
		final WorldHydrography hook = worldHydrographyDAO.get(id);
		worldHydrographyDAO.delete(hook);
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
}
