package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;

@Service
@SuppressWarnings("unchecked")
public class GenericDAO extends AbstractDAO<Idable> {

	@Inject
	public GenericDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public <T extends Idable> List<T> list() throws HibernateException {
		return (List<T>) super.list(criteria());
	}

	public <T extends Idable> T read(final Serializable id) {
		return (T) super.get(id);
	}

	public <T extends Idable> T create(final T entity) throws HibernateException {
		return (T) super.persist(entity);
	}

	public <T extends Idable> T update(final T entity) throws HibernateException {
		return (T) super.persist(entity);
	}

	public <T extends Idable> void delete(final T set) {
		currentSession().delete(set);
	}
}
