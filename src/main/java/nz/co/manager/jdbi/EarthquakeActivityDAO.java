package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.EarthquakeActivity;

@Service
public class EarthquakeActivityDAO extends AbstractDAO<EarthquakeActivity> {

	@Inject
	public EarthquakeActivityDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<EarthquakeActivity> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public EarthquakeActivity get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public EarthquakeActivity persist(final EarthquakeActivity entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final EarthquakeActivity set) {
		currentSession().delete(set);
	}
}
