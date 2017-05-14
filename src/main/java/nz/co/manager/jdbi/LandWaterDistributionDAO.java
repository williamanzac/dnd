package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.LandWaterDistribution;

@Service
public class LandWaterDistributionDAO extends AbstractDAO<LandWaterDistribution> {

	@Inject
	public LandWaterDistributionDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<LandWaterDistribution> listAll() throws HibernateException {
		return super.list(criteria());
	}

	public List<LandWaterDistribution> getBy(final int hydrographyId, final int displayTypeId) {
		return list(criteria().add(Restrictions.and(Restrictions.eq("hydrography.id", hydrographyId),
				Restrictions.eq("displayType.id", displayTypeId))));
	}

	@Override
	public LandWaterDistribution get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public LandWaterDistribution persist(final LandWaterDistribution entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final LandWaterDistribution set) {
		currentSession().delete(set);
	}
}
