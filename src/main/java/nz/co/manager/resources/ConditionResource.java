package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.Condition;
import nz.co.manager.core.ConditionService;

@Path("/admin/conditions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ConditionResource extends CRUDResource<Condition> {

	@Inject
	public ConditionResource(final ConditionService service) {
		super(service);
	}
}
