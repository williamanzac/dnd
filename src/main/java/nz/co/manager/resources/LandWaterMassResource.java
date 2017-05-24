package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.dropwizard.hibernate.UnitOfWork;
import nz.co.manager.api.LandWaterMass;
import nz.co.manager.api.LandWaterMassResults;
import nz.co.manager.core.LandWaterMassService;
import nz.co.manager.core.ServiceException;

@Path("/tools/worldBuilder/planetology/landWaterMasses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LandWaterMassResource extends CRUDResource<LandWaterMass> {

	@Inject
	public LandWaterMassResource(LandWaterMassService service) {
		super(service);
	}

	@Path("/generate")
	@POST
	@UnitOfWork
	public Response generate(final @QueryParam("hId") int hId, final @QueryParam("dId") int dId)
			throws ServiceException {
		final LandWaterMassResults results = ((LandWaterMassService) service).generate(hId, dId);
		return Response.ok(results).build();
	}
}
