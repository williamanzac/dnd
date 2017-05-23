package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.School;

@Service
public class SchoolDAO extends HibernateDAO<School> {

	@Inject
	public SchoolDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
