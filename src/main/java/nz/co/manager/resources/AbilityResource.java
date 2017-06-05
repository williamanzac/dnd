package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.Ability;
import nz.co.manager.core.AbilityService;

@Path("/admin/abilities")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AbilityResource extends CRUDResource<Ability> {

	@Inject
	public AbilityResource(final AbilityService service) {
		super(service);
	}
}
