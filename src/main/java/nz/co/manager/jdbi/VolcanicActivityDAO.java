package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.VolcanicActivity;

@Service
public class VolcanicActivityDAO extends AbstractDAO<VolcanicActivity> {

	@Inject
	public VolcanicActivityDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<VolcanicActivity> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public VolcanicActivity get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public VolcanicActivity persist(final VolcanicActivity entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final VolcanicActivity set) {
		currentSession().delete(set);
	}
}
