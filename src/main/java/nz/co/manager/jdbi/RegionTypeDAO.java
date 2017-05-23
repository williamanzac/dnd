package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.RegionType;

@Service
public class RegionTypeDAO extends HibernateDAO<RegionType> {

	@Inject
	public RegionTypeDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
