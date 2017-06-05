package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.AbilityScore;
import nz.co.manager.core.AbilityScoreService;

@Path("/admin/abilityScores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AbilityScoreResource extends CRUDResource<AbilityScore> {

	@Inject
	public AbilityScoreResource(final AbilityScoreService service) {
		super(service);
	}
}
