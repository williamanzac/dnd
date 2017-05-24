package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.LandWaterDistribution;
import nz.co.manager.jdbi.LandWaterDistributionDAO;

@Service
public class LandWaterDistributionService extends CRUDService<LandWaterDistribution> {

	@Inject
	public LandWaterDistributionService(LandWaterDistributionDAO dao) {
		super(dao);
	}
}
