package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.Condition;

public class ConditionDAO extends AbstractDAO<Condition> {

	public ConditionDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<Condition> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public Condition get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public Condition persist(final Condition entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final Condition set) {
		currentSession().delete(set);
	}
}
