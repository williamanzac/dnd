package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.SeasonalVariation;
import nz.co.manager.jdbi.SeasonalVariationDAO;

@Service
public class SeasonalVariationService extends CRUDService<SeasonalVariation> {

	@Inject
	public SeasonalVariationService(final SeasonalVariationDAO dao) {
		super(dao);
	}
}
