package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.WorldShape;

@Service
public class WorldShapeDAO extends HibernateDAO<WorldShape> {

	@Inject
	public WorldShapeDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
