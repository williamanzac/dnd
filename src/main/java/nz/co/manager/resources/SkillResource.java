package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.Skill;
import nz.co.manager.core.SkillService;

@Path("/admin/skills")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SkillResource extends CRUDResource<Skill> {

	@Inject
	public SkillResource(final SkillService service) {
		super(service);
	}
}
