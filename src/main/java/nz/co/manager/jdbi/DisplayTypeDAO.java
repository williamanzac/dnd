package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.DisplayType;

@Service
public class DisplayTypeDAO extends AbstractDAO<DisplayType> {

	@Inject
	public DisplayTypeDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<DisplayType> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public DisplayType get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public DisplayType persist(final DisplayType entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final DisplayType set) {
		currentSession().delete(set);
	}
}
