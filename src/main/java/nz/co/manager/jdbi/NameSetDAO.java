package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.NameSet;

@Service
public class NameSetDAO extends AbstractDAO<NameSet> {

	@Inject
	public NameSetDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<NameSet> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public NameSet get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public NameSet persist(final NameSet entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final NameSet set) {
		currentSession().delete(set);
	}
}
