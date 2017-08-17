package nz.co.manager.core;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.PlateResults;

@Service
public class TectonicPlateService {
	private static final int NUM_REGIONS_POLYHEDRAL = 20;

	private final DiceService diceService;

	@Inject
	public TectonicPlateService(final DiceService diceService) {
		this.diceService = diceService;
	}

	public List<PlateResults> generate(final int times) throws ServiceException {
		final List<PlateResults> results = new ArrayList<>();
		final List<Integer> rolls = diceService.roll("4d4", times);
		for (final int numPlates : rolls) {
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
}
