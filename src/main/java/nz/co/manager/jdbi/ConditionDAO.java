package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Condition;

@Service
public class ConditionDAO extends HibernateDAO<Condition> {

	@Inject
	public ConditionDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
