package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Ability;

@Service
public class AbilityDAO extends HibernateDAO<Ability> {

	@Inject
	public AbilityDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
