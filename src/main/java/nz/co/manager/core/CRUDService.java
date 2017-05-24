package nz.co.manager.core;

import java.util.List;

import nz.co.manager.jdbi.HibernateDAO;
import nz.co.manager.jdbi.Idable;

public abstract class CRUDService<E extends Idable> {

	protected final HibernateDAO<E> dao;

	public CRUDService(final HibernateDAO<E> dao) {
		this.dao = dao;
	}

	public E create(final E entity) {
		dao.add(entity);
		return entity;
	}

	public E read(final int id) {
		return dao.find(id);
	}

	public E update(final E entity) {
		dao.update(entity);
		return entity;
	}

	public void delete(final E entity) {
		dao.remove(entity);
	}

	public void delete(final int id) {
		final E read = read(id);
		delete(read);
	}

	public List<E> list() {
		return dao.list();
	}
}
