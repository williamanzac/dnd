package nz.co.manager.core;

import java.util.ArrayList;
import java.util.List;

import nz.co.manager.api.HeightWeight;
import nz.co.manager.jdbi.HeightWeightDAO;

public class HeightWeightService {

	private final HeightWeightDAO heightWeightDAO;

	public HeightWeightService(final HeightWeightDAO heightWeightDAO) {
		this.heightWeightDAO = heightWeightDAO;
	}

	public List<Integer> generate(final String type, final int times) throws ServiceException {
		final HeightWeight heightWeight = heightWeightDAO.getByType(type);
		final int baseHeight = heightWeight.getBaseHeightInch();
		final int baseWeight = heightWeight.getBaseWeightLB();
		final DiceService diceService = new DiceService();
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

	public HeightWeight createHeightWeight(final HeightWeight score) {
		return heightWeightDAO.persist(score);
	}

	public HeightWeight updateHeightWeight(final HeightWeight score) {
		return heightWeightDAO.persist(score);
	}

	public HeightWeight readHeightWeight(final String type) {
		return heightWeightDAO.get(type);
	}

	public List<HeightWeight> listHeightWeights() {
		return heightWeightDAO.listAll();
	}

	public void deleteHeightWeight(final HeightWeight score) {
		heightWeightDAO.delete(score);
	}

	public void deleteHeightWeight(final String type) {
		final HeightWeight score = heightWeightDAO.getByType(type);
		heightWeightDAO.delete(score);
	}
}
