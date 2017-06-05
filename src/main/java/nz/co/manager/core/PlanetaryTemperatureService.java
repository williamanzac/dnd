package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.PlanetaryTemperature;
import nz.co.manager.jdbi.PlanetaryTemperatureDAO;

@Service
public class PlanetaryTemperatureService extends CRUDService<PlanetaryTemperature> {

	@Inject
	public PlanetaryTemperatureService(final PlanetaryTemperatureDAO dao) {
		super(dao);
	}
}
