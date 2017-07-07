package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Region;

@Service
public class RegionDAO extends HibernateDAO<Region> {

	@Inject
	public RegionDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
