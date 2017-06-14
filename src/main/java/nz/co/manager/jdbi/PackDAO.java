package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Pack;

@Service
public class PackDAO extends HibernateDAO<Pack> {

	@Inject
	public PackDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
