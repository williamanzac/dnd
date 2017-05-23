package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.HeightWeight;

@Service
public class HeightWeightDAO extends HibernateDAO<HeightWeight> {

	@Inject
	public HeightWeightDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
