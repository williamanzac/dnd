package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.School;
import nz.co.manager.core.SchoolService;

@Path("/admin/schools")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SchoolResource extends CRUDResource<School> {

	@Inject
	public SchoolResource(SchoolService service) {
		super(service);
	}
}
