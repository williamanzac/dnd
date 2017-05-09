package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.WorldShape;

@Service
public class WorldShapeDAO extends AbstractDAO<WorldShape> {

	@Inject
	public WorldShapeDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<WorldShape> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public WorldShape get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public WorldShape persist(final WorldShape entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final WorldShape set) {
		currentSession().delete(set);
	}
}
