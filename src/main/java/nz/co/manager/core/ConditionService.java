package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Condition;
import nz.co.manager.jdbi.ConditionDAO;

@Service
public class ConditionService extends CRUDService<Condition> {

	@Inject
	public ConditionService(final ConditionDAO dao) {
		super(dao);
	}
}
