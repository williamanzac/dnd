package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.LandWaterMass;

@Service
public class LandWaterMassDAO extends AbstractDAO<LandWaterMass> {

	@Inject
	public LandWaterMassDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<LandWaterMass> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public LandWaterMass get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public LandWaterMass persist(final LandWaterMass entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final LandWaterMass set) {
		currentSession().delete(set);
	}

	public LandWaterMass getBy(final int numRegions) {
		return uniqueResult(criteria().add(Restrictions.eq("numRegions", numRegions)));
	}
}
