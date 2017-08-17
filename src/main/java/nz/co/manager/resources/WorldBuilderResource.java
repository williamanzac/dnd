package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;

import io.dropwizard.hibernate.UnitOfWork;
import nz.co.manager.core.ServiceException;
import nz.co.manager.core.WorldBuilderService;

@Path("/tools/worldBuilder")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_SVG_XML)
public class WorldBuilderResource {

	private final WorldBuilderService service;

	@Inject
	public WorldBuilderResource(final WorldBuilderService service) {
		this.service = service;
	}

	@POST
	@Path("/generate/{seed}/{displayId}/{hydrographyId}")
	@UnitOfWork
	public Response generateWorldMap(final @PathParam("seed") String seedStr,
			final @PathParam("displayId") int displayId, final @PathParam("hydrographyId") int hydrographyId)
			throws ServiceException {
		Long seed;
		try {
			seed = Long.parseLong(seedStr);
		} catch (NumberFormatException e) {
			if (StringUtils.isBlank(seedStr)) {
				seed = null;
			} else {
				seed = (long) seedStr.hashCode();
			}
		}
		final String map = service.generate(seed, hydrographyId, displayId);
		return Response.ok(map).build();
	}
}
