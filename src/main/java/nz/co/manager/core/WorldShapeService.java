package nz.co.manager.core;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.WorldShape;
import nz.co.manager.jdbi.WorldShapeDAO;

@Service
public class WorldShapeService extends CRUDService<WorldShape> {

	@Inject
	public WorldShapeService(final WorldShapeDAO dao) {
		super(dao);
	}

	public List<WorldShape> generate(final int times) throws ServiceException {
		final List<WorldShape> values = new ArrayList<>();

		final List<WorldShape> shapes = list();
		final WorldShape lastShape = shapes.get(shapes.size() - 1);
		final int max = lastShape.getMax();

		final DiceService diceService = new DiceService();
		final List<Integer> randomShapes = diceService.roll(max, times);

		for (final int i : randomShapes) {
			for (final WorldShape shape : shapes) {
				if (shape.getMin() <= i && shape.getMax() >= i) {
					values.add(shape);
				}
			}
		}
		return values;
	}
}
