package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.PlateMovement;

@Service
public class PlateMovementDAO extends AbstractDAO<PlateMovement> {

	@Inject
	public PlateMovementDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<PlateMovement> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public PlateMovement get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public PlateMovement persist(final PlateMovement entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final PlateMovement set) {
		currentSession().delete(set);
	}
}
