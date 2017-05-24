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
import nz.co.manager.api.WorldShape;
import nz.co.manager.core.ServiceException;
import nz.co.manager.core.WorldShapeService;

@Path("/tools/worldBuilder/planetology/worldShapes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WorldShapesResource extends CRUDResource<WorldShape> {

	@Inject
	public WorldShapesResource(WorldShapeService service) {
		super(service);
	}

	@Path("/generate")
	@POST
	@UnitOfWork
	public Response generate(final @QueryParam("times") Integer numOf) throws ServiceException {
		final List<WorldShape> hooks = ((WorldShapeService) service).generate(numOf);
		return Response.ok(hooks).build();
	}
}
