package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.AbilityScore;

public class AbilityScoreDAO extends AbstractDAO<AbilityScore> {

	public AbilityScoreDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<AbilityScore> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public AbilityScore get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public AbilityScore persist(final AbilityScore entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final AbilityScore set) {
		currentSession().delete(set);
	}
}
