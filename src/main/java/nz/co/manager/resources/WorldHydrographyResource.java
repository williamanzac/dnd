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
import nz.co.manager.api.WorldHydrography;
import nz.co.manager.core.ServiceException;
import nz.co.manager.core.WorldHydrographyService;

@Path("/tools/worldBuilder/planetology/hydrographies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WorldHydrographyResource extends CRUDResource<WorldHydrography> {

	@Inject
	public WorldHydrographyResource(final WorldHydrographyService service) {
		super(service);
	}

	@Path("/generate")
	@POST
	@UnitOfWork
	public Response generate(final @QueryParam("times") Integer numOf) throws ServiceException {
		final List<WorldHydrography> hooks = ((WorldHydrographyService) service).generate(numOf);
		return Response.ok(hooks).build();
	}
}
