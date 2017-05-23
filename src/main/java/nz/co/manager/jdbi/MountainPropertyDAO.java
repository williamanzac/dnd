package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.MountainProperty;

@Service
public class MountainPropertyDAO extends HibernateDAO<MountainProperty> {

	@Inject
	public MountainPropertyDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
