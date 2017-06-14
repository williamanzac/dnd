package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.Pack;
import nz.co.manager.core.PackService;

@Path("/admin/packs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PackResource extends CRUDResource<Pack> {

	@Inject
	public PackResource(final PackService service) {
		super(service);
	}
}
