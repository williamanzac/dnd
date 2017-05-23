package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.PlateMovement;

@Service
public class PlateMovementDAO extends HibernateDAO<PlateMovement> {

	@Inject
	public PlateMovementDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
