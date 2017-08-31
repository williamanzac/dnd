package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Skill;

@Service
public class SkillDAO extends HibernateDAO<Skill> {

	@Inject
	public SkillDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
