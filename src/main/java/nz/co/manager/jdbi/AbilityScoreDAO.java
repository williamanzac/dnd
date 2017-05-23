package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.AbilityScore;

@Service
public class AbilityScoreDAO extends HibernateDAO<AbilityScore> {

	@Inject
	public AbilityScoreDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
