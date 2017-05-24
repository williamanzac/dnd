package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.dropwizard.hibernate.UnitOfWork;
import nz.co.manager.api.HeightWeight;
import nz.co.manager.core.HeightWeightService;
import nz.co.manager.core.ServiceException;

@Path("/tools/heightWeights")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HeightWeightResource extends CRUDResource<HeightWeight> {

	@Inject
	public HeightWeightResource(final HeightWeightService service) {
		super(service);
	}

	@Path("/{id}/generate")
	@POST
	@UnitOfWork
	public Response generateHeightWeight(final @PathParam("id") int id, final @QueryParam("times") Integer numOf)
			throws ServiceException {
		return Response.ok(((HeightWeightService) service).generate(id, numOf)).build();
	}
}
