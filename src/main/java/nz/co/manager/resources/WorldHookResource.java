package nz.co.manager.resources;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.dropwizard.hibernate.UnitOfWork;
import nz.co.manager.api.WorldHook;
import nz.co.manager.core.ServiceException;
import nz.co.manager.core.WorldHookService;
import nz.co.manager.views.WorldHookView;

@Path("/tools/worldHooks")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WorldHookResource extends CRUDResource<WorldHook> {

	@Inject
	public WorldHookResource(final WorldHookService service) {
		super(service);
	}

	private WorldHookService getService() {
		return (WorldHookService) service;
	}

	@GET
	@UnitOfWork
	@Override
	public Response list() {
		final List<WorldHook> hooks = getService().list();
		final List<WorldHookView> list = new ArrayList<>();
		hooks.forEach(h -> {
			list.add(new WorldHookView(h));
		});
		return Response.ok(list).build();
	}

	@POST
	@UnitOfWork
	@Override
	public Response create(final WorldHook hook) {
		final WorldHook worldHook = getService().create(hook);
		return Response.ok(new WorldHookView(worldHook)).build();
	}

	@PUT
	@UnitOfWork
	@Override
	public Response update(final WorldHook hook) {
		final WorldHook worldHook = getService().update(hook);
		return Response.ok(new WorldHookView(worldHook)).build();
	}

	@Path("/{id}")
	@GET
	@UnitOfWork
	@Override
	public Response read(final @PathParam("id") int id) {
		final WorldHook hook = getService().read(id);
		return Response.ok(new WorldHookView(hook)).build();
	}

	@Path("/generate")
	@POST
	@UnitOfWork
	public Response generate(final @QueryParam("times") Integer numOf) throws ServiceException {
		final List<WorldHook> list = getService().generate(numOf);
		final List<WorldHookView> hooks = new ArrayList<>();
		list.forEach(h -> {
			hooks.add(new WorldHookView(h));
		});
		return Response.ok(hooks).build();
	}
}
