package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.RegionalHydrography;

@Service
public class RegionalHydrographyDAO extends HibernateDAO<RegionalHydrography> {

	@Inject
	public RegionalHydrographyDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
