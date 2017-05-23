package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.VolcanicActivity;

@Service
public class VolcanicActivityDAO extends HibernateDAO<VolcanicActivity> {

	@Inject
	public VolcanicActivityDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
