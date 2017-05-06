package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.Gear;

@Service
public class GearDAO extends AbstractDAO<Gear> {

	@Inject
	public GearDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<Gear> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public Gear get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public Gear persist(final Gear entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final Gear set) {
		currentSession().delete(set);
	}
}
