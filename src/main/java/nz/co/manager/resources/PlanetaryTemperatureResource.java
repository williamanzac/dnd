package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.PlanetaryTemperature;
import nz.co.manager.core.PlanetaryTemperatureService;

@Path("/tools/worldBuilder/planetology/planetaryTemperatures")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlanetaryTemperatureResource extends CRUDResource<PlanetaryTemperature> {

	@Inject
	public PlanetaryTemperatureResource(PlanetaryTemperatureService service) {
		super(service);
	}
}
