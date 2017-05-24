package nz.co.manager.core;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.WorldSize;
import nz.co.manager.jdbi.WorldSizeDAO;

@Service
public class WorldSizeService extends CRUDService<WorldSize> {

	@Inject
	public WorldSizeService(WorldSizeDAO dao) {
		super(dao);
	}

	public List<WorldSize> generate(final int times) throws ServiceException {
		final List<WorldSize> values = new ArrayList<>();

		final List<WorldSize> sizes = list();
		final WorldSize lastSize = sizes.get(sizes.size() - 1);
		final int max = lastSize.getMax();

		final DiceService diceService = new DiceService();
		final List<Integer> randomSizes = diceService.roll(max, times);

		for (final int i : randomSizes) {
			for (final WorldSize size : sizes) {
				if (size.getMin() <= i && size.getMax() >= i) {
					values.add(size);
				}
			}
		}
		return values;
	}
}
