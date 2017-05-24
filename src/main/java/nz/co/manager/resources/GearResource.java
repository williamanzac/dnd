package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.Gear;
import nz.co.manager.core.GearService;

@Path("/admin/gear")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GearResource extends CRUDResource<Gear> {

	@Inject
	public GearResource(final GearService service) {
		super(service);
	}
}
