package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.MountainPlacement;

@Service
public class MountainPlacementDAO extends HibernateDAO<MountainPlacement> {

	@Inject
	public MountainPlacementDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
