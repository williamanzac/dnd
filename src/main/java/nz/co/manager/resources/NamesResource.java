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
import nz.co.manager.api.NameSet;
import nz.co.manager.core.NameService;
import nz.co.manager.core.ServiceException;

@Path("/tools/names")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NamesResource extends CRUDResource<NameSet> {

	@Inject
	public NamesResource(final NameService service) {
		super(service);
	}

	@Path("/{id}/generate")
	@POST
	@UnitOfWork
	public Response generateName(final @PathParam("id") int id, final @QueryParam("numOf") Integer numOf)
			throws ServiceException {
		return Response.ok(((NameService) service).nameList(id, numOf)).build();
	}
}
