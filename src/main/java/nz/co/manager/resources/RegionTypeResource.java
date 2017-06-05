package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.RegionType;
import nz.co.manager.core.RegionTypeService;

@Path("/tools/worldBuilder/planetology/regionTypes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegionTypeResource extends CRUDResource<RegionType> {

	@Inject
	public RegionTypeResource(final RegionTypeService service) {
		super(service);
	}
}
