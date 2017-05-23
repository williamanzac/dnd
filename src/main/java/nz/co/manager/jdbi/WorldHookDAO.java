package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.WorldHook;

@Service
public class WorldHookDAO extends HibernateDAO<WorldHook> {

	@Inject
	public WorldHookDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
