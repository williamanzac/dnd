package nz.co.manager.resources;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.dropwizard.hibernate.UnitOfWork;
import nz.co.manager.api.Language;
import nz.co.manager.api.Race;
import nz.co.manager.core.RaceService;

@Path("/admin/races")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RaceResource extends CRUDResource<Race> {

	@Inject
	public RaceResource(final RaceService service) {
		super(service);
	}

	private RaceService getService() {
		return (RaceService) service;
	}

	@GET
	@Path("/{id}/subRaces")
	@UnitOfWork
	public Response listSubRaces(final @PathParam("id") int id) {
		final List<Race> races = getService().listSubRaces(id);
		return Response.ok(races).build();
	}

	@POST
	@Path("/{id}/subRaces")
	@UnitOfWork
	public Response create(final @PathParam("id") int id, final Race entity) {
		final Race created = getService().addSubRace(id, entity);
		return Response.ok(created).build();
	}

	@GET
	@Path("/{id}/languages")
	@UnitOfWork
	public Response listLanguages(final @PathParam("id") int id) {
		final Set<Language> languages = getService().read(id).getLanguages();
		return Response.ok(languages).build();
	}
}
