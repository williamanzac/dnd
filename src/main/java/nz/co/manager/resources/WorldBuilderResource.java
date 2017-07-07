package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.dropwizard.hibernate.UnitOfWork;
import nz.co.manager.core.ServiceException;
import nz.co.manager.core.WorldBuilderService;

@Path("/tools/worldBuilder/bob")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_SVG_XML)
public class WorldBuilderResource {

	private final WorldBuilderService service;

	@Inject
	public WorldBuilderResource(final WorldBuilderService service) {
		this.service = service;
	}

	@POST
	@Path("/generate")
	@UnitOfWork
	public Response generateWorldMap() throws ServiceException {
		service.generate();
		return Response.ok().build();
	}
}
