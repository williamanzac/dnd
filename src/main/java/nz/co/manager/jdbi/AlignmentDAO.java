package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.Alignment;

@Service
public class AlignmentDAO extends AbstractDAO<Alignment> {

	@Inject
	public AlignmentDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<Alignment> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public Alignment get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public Alignment persist(final Alignment entity) throws HibernateException {
		return super.persist(entity);
	}

	public void delete(final Alignment set) {
		currentSession().delete(set);
	}
}
