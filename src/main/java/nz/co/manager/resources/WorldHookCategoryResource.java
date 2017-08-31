package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.WorldHookCategory;
import nz.co.manager.core.WorldHookCategoryService;

@Path("/tools/worldHookCategories")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WorldHookCategoryResource extends CRUDResource<WorldHookCategory> {

	@Inject
	public WorldHookCategoryResource(final WorldHookCategoryService service) {
		super(service);
	}

	// private WorldHookCategoryService getService() {
	// return (WorldHookCategoryService) service;
	// }
	//
	// @Override
	// @GET
	// @UnitOfWork
	// public Response list() {
	// final List<WorldHookCategory> hooks = getService().list();
	// // final List<CategoryView> list = new ArrayList<>();
	// // hooks.forEach(h -> {
	// // list.add(new CategoryView(h));
	// // });
	// // return Response.ok(list).build();
	// return Response.ok(hooks).build();
	// }
	//
	// @Override
	// @POST
	// @UnitOfWork
	// public Response create(final WorldHookCategory hook) {
	// final WorldHookCategory worldHook = getService().create(hook);
	// // return Response.ok(new CategoryView(worldHook)).build();
	// return Response.ok(worldHook).build();
	// }
	//
	// @Override
	// @PUT
	// @UnitOfWork
	// public Response update(final WorldHookCategory hook) {
	// final WorldHookCategory worldHook = getService().update(hook);
	// // return Response.ok(new CategoryView(worldHook)).build();
	// return Response.ok(worldHook).build();
	// }
	//
	// @Override
	// @Path("/{id}")
	// @GET
	// @UnitOfWork
	// public Response read(final @PathParam("id") int id) {
	// final WorldHookCategory hook = getService().read(id);
	// //return Response.ok(new CategoryView(hook)).build();
	// return Response.ok(hook).build();
	// }
}
