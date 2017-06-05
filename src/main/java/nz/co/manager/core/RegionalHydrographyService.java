package nz.co.manager.core;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.RegionalHydrography;
import nz.co.manager.jdbi.RegionalHydrographyDAO;

@Service
public class RegionalHydrographyService extends CRUDService<RegionalHydrography> {

	@Inject
	public RegionalHydrographyService(final RegionalHydrographyDAO dao) {
		super(dao);
	}

	public List<RegionalHydrography> generate(final int times) throws ServiceException {
		final List<RegionalHydrography> values = new ArrayList<>();

		final List<RegionalHydrography> hydrographies = list();
		final RegionalHydrography lastHydrography = hydrographies.get(hydrographies.size() - 1);
		final int max = lastHydrography.getMax();

		final DiceService diceService = new DiceService();
		final List<Integer> randomHydrographies = diceService.roll(max, times);

		for (final int i : randomHydrographies) {
			for (final RegionalHydrography hydrography : hydrographies) {
				if (hydrography.getMin() <= i && hydrography.getMax() >= i) {
					values.add(hydrography);
				}
			}
		}
		return values;
	}
}
