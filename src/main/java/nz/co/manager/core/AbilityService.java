package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Ability;
import nz.co.manager.jdbi.AbilityDAO;

@Service
public class AbilityService extends CRUDService<Ability> {

	@Inject
	public AbilityService(AbilityDAO dao) {
		super(dao);
	}
}
