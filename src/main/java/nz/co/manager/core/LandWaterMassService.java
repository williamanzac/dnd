package nz.co.manager.core;

import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.DisplayType;
import nz.co.manager.api.LandWaterDistribution;
import nz.co.manager.api.LandWaterMass;
import nz.co.manager.api.LandWaterMassResults;
import nz.co.manager.api.WorldHydrography;
import nz.co.manager.jdbi.DisplayTypeDAO;
import nz.co.manager.jdbi.LandWaterDistributionDAO;
import nz.co.manager.jdbi.LandWaterMassDAO;
import nz.co.manager.jdbi.WorldHydrographyDAO;

@Service
public class LandWaterMassService extends CRUDService<LandWaterMass> {

	private final DiceService diceService;
	private final LandWaterDistributionDAO landWaterDistributionDAO;
	private final WorldHydrographyDAO worldHydrographyDAO;
	private final DisplayTypeDAO displayTypeDAO;

	@Inject
	public LandWaterMassService(final LandWaterMassDAO dao, final DiceService diceService,
			final LandWaterDistributionDAO landWaterDistributionDAO, final WorldHydrographyDAO worldHydrographyDAO,
			final DisplayTypeDAO displayTypeDAO) {
		super(dao);
		this.diceService = diceService;
		this.landWaterDistributionDAO = landWaterDistributionDAO;
		this.worldHydrographyDAO = worldHydrographyDAO;
		this.displayTypeDAO = displayTypeDAO;
	}

	public LandWaterMassResults generate(final int hydrographyId, final int displayTypeId) throws ServiceException {
		final LandWaterMassResults results = new LandWaterMassResults();
		final int numRegions = getNumRegions(hydrographyId, displayTypeId);
		if (numRegions == 0) {
			return results;
		}
		final LandWaterMass mass = ((LandWaterMassDAO) dao).getBy(numRegions);
		results.setMass(mass);
		final String numMassesData = results.getMass().getNumMasses();
		List<Integer> rolls;
		try {
			rolls = diceService.roll(numMassesData, 1);
		} catch (final ServiceException e) {
			rolls = diceService.roll(results.getMass().getMaxSize(), 1);
		}
		final int numMasses = rolls.get(0);
		final DisplayType displayType = displayTypeDAO.find(displayTypeId);
		final List<Integer> positions = diceService.roll(displayType.getNumRegions(), numMasses);
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
		final List<LandWaterDistribution> distributions = landWaterDistributionDAO.getBy(hydrographyId, displayTypeId);
		final WorldHydrography hydrography = worldHydrographyDAO.find(hydrographyId);
		int numRegions = 0;
		for (final LandWaterDistribution d : distributions) {
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
