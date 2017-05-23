package nz.co.manager.jdbi;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.LandWaterDistribution;

@Service
public class LandWaterDistributionDAO extends HibernateDAO<LandWaterDistribution> {

	@Inject
	public LandWaterDistributionDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<LandWaterDistribution> getBy(final int hydrographyId, final int displayTypeId) {
		return currentSession().createCriteria(daoType)
				.add(Restrictions.and(Restrictions.eq("hydrography.id", hydrographyId),
						Restrictions.eq("displayType.id", displayTypeId)))
				.list();
	}
}
