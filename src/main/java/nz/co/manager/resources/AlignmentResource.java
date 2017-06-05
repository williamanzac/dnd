package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.Alignment;
import nz.co.manager.core.AlignmentService;

@Path("/admin/alignments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlignmentResource extends CRUDResource<Alignment> {

	@Inject
	public AlignmentResource(final AlignmentService service) {
		super(service);
	}
}
