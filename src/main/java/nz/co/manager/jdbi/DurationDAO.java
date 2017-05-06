package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.Duration;

@Service
public class DurationDAO extends AbstractDAO<Duration> {

	@Inject
	public DurationDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<Duration> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public Duration get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public Duration persist(final Duration entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final Duration set) {
		currentSession().delete(set);
	}
}
