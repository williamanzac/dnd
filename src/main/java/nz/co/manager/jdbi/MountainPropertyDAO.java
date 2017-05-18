package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.MountainProperty;

@Service
public class MountainPropertyDAO extends AbstractDAO<MountainProperty> {

	@Inject
	public MountainPropertyDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<MountainProperty> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public MountainProperty get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public MountainProperty persist(final MountainProperty entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final MountainProperty set) {
		currentSession().delete(set);
	}
}
