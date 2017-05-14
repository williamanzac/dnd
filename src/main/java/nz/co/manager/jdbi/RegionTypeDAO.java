package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.RegionType;

@Service
public class RegionTypeDAO extends AbstractDAO<RegionType> {

	@Inject
	public RegionTypeDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<RegionType> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public RegionType get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public RegionType persist(final RegionType entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final RegionType set) {
		currentSession().delete(set);
	}
}
