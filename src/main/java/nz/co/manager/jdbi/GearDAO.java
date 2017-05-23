package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Gear;

@Service
public class GearDAO extends HibernateDAO<Gear> {

	@Inject
	public GearDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
