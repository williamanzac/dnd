package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.Language;

@Service
public class LanguageDAO extends AbstractDAO<Language> {

	@Inject
	public LanguageDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<Language> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public Language get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public Language persist(final Language entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final Language set) {
		currentSession().delete(set);
	}
}
