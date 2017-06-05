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
import nz.co.manager.api.RegionalHydrography;
import nz.co.manager.core.RegionalHydrographyService;
import nz.co.manager.core.ServiceException;

@Path("/tools/worldBuilder/continentsgeography/hydrographies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegionalHydrographyResource extends CRUDResource<RegionalHydrography> {

	@Inject
	public RegionalHydrographyResource(final RegionalHydrographyService service) {
		super(service);
	}

	@Path("/generate")
	@POST
	@UnitOfWork
	public Response generate(final @QueryParam("times") Integer numOf) throws ServiceException {
		final List<RegionalHydrography> hooks = ((RegionalHydrographyService) service).generate(numOf);
		return Response.ok(hooks).build();
	}
}
