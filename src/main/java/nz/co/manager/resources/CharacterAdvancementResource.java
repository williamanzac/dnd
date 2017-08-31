package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.CharacterAdvancement;
import nz.co.manager.core.CharacterAdvancementService;

@Path("/admin/characterAdvancements")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CharacterAdvancementResource extends CRUDResource<CharacterAdvancement> {

	@Inject
	public CharacterAdvancementResource(final CharacterAdvancementService service) {
		super(service);
	}
}
