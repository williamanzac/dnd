package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.WorldHook;

@Service
public class WorldHookDAO extends AbstractDAO<WorldHook> {

	@Inject
	public WorldHookDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<WorldHook> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public WorldHook get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public WorldHook persist(final WorldHook entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final WorldHook set) {
		currentSession().delete(set);
	}
}