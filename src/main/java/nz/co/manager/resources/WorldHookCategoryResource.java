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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.dropwizard.hibernate.UnitOfWork;
import nz.co.manager.api.WorldHookCategory;
import nz.co.manager.core.WorldHookCategoryService;
import nz.co.manager.views.CategoryView;

@Path("/tools/worldHookCategories")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WorldHookCategoryResource extends CRUDResource<WorldHookCategory> {

	@Inject
	public WorldHookCategoryResource(final WorldHookCategoryService service) {
		super(service);
	}

	private WorldHookCategoryService getService() {
		return (WorldHookCategoryService) service;
	}

	@Override
	@GET
	@UnitOfWork
	public Response list() {
		final List<WorldHookCategory> hooks = getService().list();
		final List<CategoryView> list = new ArrayList<>();
		hooks.forEach(h -> {
			list.add(new CategoryView(h));
		});
		return Response.ok(list).build();
	}

	@Override
	@POST
	@UnitOfWork
	public Response create(final WorldHookCategory hook) {
		final WorldHookCategory worldHook = getService().create(hook);
		return Response.ok(new CategoryView(worldHook)).build();
	}

	@Override
	@PUT
	@UnitOfWork
	public Response update(final WorldHookCategory hook) {
		final WorldHookCategory worldHook = getService().update(hook);
		return Response.ok(new CategoryView(worldHook)).build();
	}

	@Override
	@Path("/{id}")
	@GET
	@UnitOfWork
	public Response read(final @PathParam("id") int id) {
		final WorldHookCategory hook = getService().read(id);
		return Response.ok(new CategoryView(hook)).build();
	}
}
