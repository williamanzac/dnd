package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.WorldSize;

@Service
public class WorldSizeDAO extends HibernateDAO<WorldSize> {

	@Inject
	public WorldSizeDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
