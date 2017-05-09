package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.WorldSize;

@Service
public class WorldSizeDAO extends AbstractDAO<WorldSize> {

	@Inject
	public WorldSizeDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<WorldSize> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public WorldSize get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public WorldSize persist(final WorldSize entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final WorldSize set) {
		currentSession().delete(set);
	}
}
