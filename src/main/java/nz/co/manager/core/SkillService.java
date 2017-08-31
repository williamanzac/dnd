package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Skill;
import nz.co.manager.jdbi.SkillDAO;

@Service
public class SkillService extends CRUDService<Skill> {

	@Inject
	public SkillService(final SkillDAO dao) {
		super(dao);
	}
}
