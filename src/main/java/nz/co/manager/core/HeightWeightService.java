package nz.co.manager.core;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.HeightWeight;
import nz.co.manager.jdbi.HeightWeightDAO;

@Service
public class HeightWeightService {

	private final HeightWeightDAO heightWeightDAO;

	@Inject
	public HeightWeightService(final HeightWeightDAO heightWeightDAO) {
		this.heightWeightDAO = heightWeightDAO;
	}

	public List<Integer> generate(final int id, final int times) throws ServiceException {
		final HeightWeight heightWeight = readHeightWeight(id);
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

	public HeightWeight createHeightWeight(final HeightWeight entity) {
		heightWeightDAO.add(entity);
		return entity;
	}

	public HeightWeight updateHeightWeight(final HeightWeight entity) {
		heightWeightDAO.update(entity);
		return entity;
	}

	public HeightWeight readHeightWeight(final int id) {
		return heightWeightDAO.find(id);
	}

	public List<HeightWeight> listHeightWeights() {
		return heightWeightDAO.list();
	}

	public void deleteHeightWeight(final HeightWeight entity) {
		heightWeightDAO.remove(entity);
	}

	public void deleteHeightWeight(final int id) {
		final HeightWeight entity = readHeightWeight(id);
		deleteHeightWeight(entity);
	}
}
