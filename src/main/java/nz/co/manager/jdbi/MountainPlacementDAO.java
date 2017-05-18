package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.MountainPlacement;

@Service
public class MountainPlacementDAO extends AbstractDAO<MountainPlacement> {

	@Inject
	public MountainPlacementDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<MountainPlacement> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public MountainPlacement get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public MountainPlacement persist(final MountainPlacement entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final MountainPlacement set) {
		currentSession().delete(set);
	}
}
