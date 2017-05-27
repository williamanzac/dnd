package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.SeasonalVariation;

@Service
public class SeasonalVariationDAO extends HibernateDAO<SeasonalVariation> {

	@Inject
	public SeasonalVariationDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
