package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.LandWaterMass;

@Service
public class LandWaterMassDAO extends HibernateDAO<LandWaterMass> {

	@Inject
	public LandWaterMassDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings("deprecation")
	public LandWaterMass getBy(final int numRegions) {
		return (LandWaterMass) currentSession().createCriteria(daoType).add(Restrictions.eq("numRegions", numRegions))
				.uniqueResult();
	}
}
