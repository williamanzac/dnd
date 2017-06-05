package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.Duration;
import nz.co.manager.core.DurationService;

@Path("/admin/durations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DurationResource extends CRUDResource<Duration> {

	@Inject
	public DurationResource(final DurationService service) {
		super(service);
	}
}
