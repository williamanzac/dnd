package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.WorldHookCategory;

@Service
public class WorldHookCategoryDAO extends HibernateDAO<WorldHookCategory> {

	@Inject
	public WorldHookCategoryDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
