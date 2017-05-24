package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.DisplayType;
import nz.co.manager.core.DisplayTypeService;

@Path("/tools/worldBuilder/planetology/displayTypes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DisplayTypeResource extends CRUDResource<DisplayType> {

	@Inject
	public DisplayTypeResource(DisplayTypeService service) {
		super(service);
	}
}
