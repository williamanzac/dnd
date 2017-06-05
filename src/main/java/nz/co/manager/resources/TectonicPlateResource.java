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
import nz.co.manager.api.PlateResults;
import nz.co.manager.core.ServiceException;
import nz.co.manager.core.TectonicPlateService;

@Path("/tools/worldBuilder/planetology/tectonicPlates")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TectonicPlateResource {
	private final TectonicPlateService service;

	@Inject
	public TectonicPlateResource(final TectonicPlateService service) {
		this.service = service;
	}

	@Path("/generate")
	@POST
	@UnitOfWork
	public Response generateTechtonicPlates(final @QueryParam("times") Integer times) throws ServiceException {
		final List<PlateResults> results = service.generate(times);
		return Response.ok(results).build();
	}

}
