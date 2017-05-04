package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.School;

public class SchoolDAO extends AbstractDAO<School> {

	public SchoolDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<School> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public School get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public School persist(final School entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final School set) {
		currentSession().delete(set);
	}
}
