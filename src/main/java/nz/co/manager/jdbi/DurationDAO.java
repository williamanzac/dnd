package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Duration;

@Service
public class DurationDAO extends HibernateDAO<Duration> {

	@Inject
	public DurationDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
