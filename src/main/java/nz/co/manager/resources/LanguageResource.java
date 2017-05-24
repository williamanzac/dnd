package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.Language;
import nz.co.manager.core.LanguageService;

@Path("/admin/languages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LanguageResource extends CRUDResource<Language> {

	@Inject
	public LanguageResource(LanguageService service) {
		super(service);
	}
}
