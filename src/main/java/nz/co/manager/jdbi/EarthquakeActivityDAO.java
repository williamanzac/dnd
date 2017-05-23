package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.EarthquakeActivity;

@Service
public class EarthquakeActivityDAO extends HibernateDAO<EarthquakeActivity> {

	@Inject
	public EarthquakeActivityDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
