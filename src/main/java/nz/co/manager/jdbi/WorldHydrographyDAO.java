package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.WorldHydrography;

@Service
public class WorldHydrographyDAO extends AbstractDAO<WorldHydrography> {

	@Inject
	public WorldHydrographyDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<WorldHydrography> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public WorldHydrography get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public WorldHydrography persist(final WorldHydrography entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final WorldHydrography set) {
		currentSession().delete(set);
	}
}
