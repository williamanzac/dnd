package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Language;

@Service
public class LanguageDAO extends HibernateDAO<Language> {

	@Inject
	public LanguageDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
