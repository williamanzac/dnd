package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.PlanetaryTemperature;

@Service
public class PlanetaryTemperatureDAO extends HibernateDAO<PlanetaryTemperature> {

	@Inject
	public PlanetaryTemperatureDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
