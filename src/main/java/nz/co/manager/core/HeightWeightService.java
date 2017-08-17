package nz.co.manager.core;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.HeightWeight;
import nz.co.manager.jdbi.HeightWeightDAO;

@Service
public class HeightWeightService extends CRUDService<HeightWeight> {
	private final DiceService diceService;

	@Inject
	public HeightWeightService(final HeightWeightDAO heightWeightDAO, final DiceService diceService) {
		super(heightWeightDAO);
		this.diceService = diceService;
	}

	public List<Integer> generate(final int id, final int times) throws ServiceException {
		final HeightWeight heightWeight = read(id);
		final int baseHeight = heightWeight.getBaseHeightInch();
		final int baseWeight = heightWeight.getBaseWeightLB();
		final List<Integer> heights = diceService.roll(heightWeight.getHeightModifier(), times);
		final List<Integer> weights = new ArrayList<>();
		try {
			weights.addAll(diceService.roll(heightWeight.getWeightModifier(), times));
		} catch (final ServiceException e) {
			for (int i = 0; i < times; i++) {
				weights.add(1);
			}
		}
		final List<Integer> values = new ArrayList<>();
		for (int i = 0; i < times; i++) {
			values.add(baseHeight + heights.get(i));
			values.add(baseWeight + heights.get(i) * weights.get(i));
		}
		return values;
	}
}
