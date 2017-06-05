package nz.co.manager.resources;

import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.dropwizard.hibernate.UnitOfWork;
import nz.co.manager.api.EarthquakeActivity;
import nz.co.manager.api.EarthquakeFrequency;
import nz.co.manager.api.EarthquakeStrength;
import nz.co.manager.core.EarthquakeActivityService;

@Path("/tools/worldBuilder/planetology/earthquakeActivities")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EarthquakeActivityResource extends CRUDResource<EarthquakeActivity> {

	@Inject
	public EarthquakeActivityResource(final EarthquakeActivityService service) {
		super(service);
	}

	@Path("/earthquakeStrengths")
	@GET
	@UnitOfWork
	public Response listEarthquakeStrengths() {
		final Set<EarthquakeStrength> hooks = ((EarthquakeActivityService) service).listEarthquakeStrengths();
		return Response.ok(hooks).build();
	}

	@Path("/earthquakeFrequencies")
	@GET
	@UnitOfWork
	public Response listEarthquakeFrequencies() {
		final Set<EarthquakeFrequency> hooks = ((EarthquakeActivityService) service).listEarthquakeFrequencies();
		return Response.ok(hooks).build();
	}
}
