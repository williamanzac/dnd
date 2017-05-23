package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.NameSet;

@Service
public class NameSetDAO extends HibernateDAO<NameSet> {

	@Inject
	public NameSetDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
