package nz.co.manager.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.dropwizard.hibernate.UnitOfWork;
import nz.co.manager.api.WorldSize;
import nz.co.manager.core.ServiceException;
import nz.co.manager.core.WorldSizeService;

@Path("/tools/worldBuilder/planetology/worldSizes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WorldSizeResource extends CRUDResource<WorldSize> {

	@Inject
	public WorldSizeResource(final WorldSizeService service) {
		super(service);
	}

	@Path("/generate")
	@POST
	@UnitOfWork
	public Response generate(final @QueryParam("times") Integer numOf) throws ServiceException {
		final List<WorldSize> hooks = ((WorldSizeService) service).generate(numOf);
		return Response.ok(hooks).build();
	}
}
