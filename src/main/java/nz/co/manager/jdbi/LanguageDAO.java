package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Language;

@Service
public class LanguageDAO extends HibernateDAO<Language> {

	@Inject
	public LanguageDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings({ "deprecation" })
	public Language findBy(final String name) {
		return (Language) currentSession().createCriteria(daoType).add(Restrictions.eq("name", name)).uniqueResult();
	}
}
