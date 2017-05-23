package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Alignment;

@Service
public class AlignmentDAO extends HibernateDAO<Alignment> {

	@Inject
	public AlignmentDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
