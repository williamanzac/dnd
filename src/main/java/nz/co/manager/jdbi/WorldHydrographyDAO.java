package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.WorldHydrography;

@Service
public class WorldHydrographyDAO extends HibernateDAO<WorldHydrography> {

	@Inject
	public WorldHydrographyDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
