package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.PlateMovement;
import nz.co.manager.core.PlateMovementService;

@Path("/tools/worldBuilder/planetology/plateMovements")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlateMovementResource extends CRUDResource<PlateMovement> {

	@Inject
	public PlateMovementResource(PlateMovementService service) {
		super(service);
	}
}
