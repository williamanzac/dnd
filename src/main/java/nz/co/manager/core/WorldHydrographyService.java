package nz.co.manager.core;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.WorldHydrography;
import nz.co.manager.jdbi.WorldHydrographyDAO;

@Service
public class WorldHydrographyService extends CRUDService<WorldHydrography> {

	@Inject
	public WorldHydrographyService(WorldHydrographyDAO dao) {
		super(dao);
	}

	public List<WorldHydrography> generate(final int times) throws ServiceException {
		final List<WorldHydrography> values = new ArrayList<>();

		final List<WorldHydrography> hydrographies = list();
		final WorldHydrography lastHydrography = hydrographies.get(hydrographies.size() - 1);
		final int max = lastHydrography.getMax();

		final DiceService diceService = new DiceService();
		final List<Integer> randomHydrographies = diceService.roll(max, times);

		for (final int i : randomHydrographies) {
			for (final WorldHydrography hydrography : hydrographies) {
				if (hydrography.getMin() <= i && hydrography.getMax() >= i) {
					values.add(hydrography);
				}
			}
		}
		return values;
	}
}
