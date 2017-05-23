package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.DisplayType;

@Service
public class DisplayTypeDAO extends HibernateDAO<DisplayType> {

	@Inject
	public DisplayTypeDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
