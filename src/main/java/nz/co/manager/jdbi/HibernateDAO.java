package nz.co.manager.jdbi;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class HibernateDAO<E extends Idable> implements GenericDAO<E, Integer> {

	private final SessionFactory sessionFactory;
	protected final Class<? extends E> daoType;

	@SuppressWarnings("unchecked")
	@Inject
	public HibernateDAO(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(E entity) {
		currentSession().save(entity);
	}

	@Override
	public void update(E entity) {
		currentSession().saveOrUpdate(entity);
	}

	@Override
	public void remove(E entity) {
		currentSession().delete(entity);
	}

	@Override
	public E find(Integer key) {
		return currentSession().get(daoType, key);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<E> list() {
		return currentSession().createCriteria(daoType).list();
	}
}
