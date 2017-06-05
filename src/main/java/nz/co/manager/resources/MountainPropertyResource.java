package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.MountainProperty;
import nz.co.manager.core.MountainPropertyService;

@Path("/tools/worldBuilder/planetology/mountainProperties")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MountainPropertyResource extends CRUDResource<MountainProperty> {

	@Inject
	public MountainPropertyResource(final MountainPropertyService service) {
		super(service);
	}
}
