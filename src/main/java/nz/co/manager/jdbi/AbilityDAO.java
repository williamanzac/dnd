package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.Ability;

@Service
public class AbilityDAO extends AbstractDAO<Ability> {

	@Inject
	public AbilityDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<Ability> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public Ability get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public Ability persist(final Ability entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final Ability set) {
		currentSession().delete(set);
	}
}
