package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.AbilityScore;
import nz.co.manager.jdbi.AbilityScoreDAO;

@Service
public class AbilityScoreService extends CRUDService<AbilityScore> {

	@Inject
	public AbilityScoreService(final AbilityScoreDAO dao) {
		super(dao);
	}
}
