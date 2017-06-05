package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.MountainPlacement;
import nz.co.manager.core.MountainPlacementService;

@Path("/tools/worldBuilder/planetology/mountainPlacements")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MountainPlacementResource extends CRUDResource<MountainPlacement> {

	@Inject
	public MountainPlacementResource(final MountainPlacementService service) {
		super(service);
	}
}
