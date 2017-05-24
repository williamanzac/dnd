package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.VolcanicActivity;
import nz.co.manager.core.VolcanicActivityService;

@Path("/tools/worldBuilder/planetology/volcanicActivities")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VolcanicActivityResource extends CRUDResource<VolcanicActivity> {

	@Inject
	public VolcanicActivityResource(VolcanicActivityService service) {
		super(service);
	}
}
