package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.HeightWeight;

@Service
public class HeightWeightDAO extends AbstractDAO<HeightWeight> {

	@Inject
	public HeightWeightDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<HeightWeight> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public HeightWeight get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public HeightWeight persist(final HeightWeight entity) throws HibernateException {
		return super.persist(entity);
	}

	public HeightWeight getByType(final String type) {
		return uniqueResult(criteria().add(Restrictions.eq("type", type)));
	}

	public void delete(final HeightWeight set) {
		currentSession().delete(set);
	}
}
