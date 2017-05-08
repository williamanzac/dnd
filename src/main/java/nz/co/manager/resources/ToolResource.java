package nz.co.manager.resources;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import io.dropwizard.hibernate.UnitOfWork;
import nz.co.manager.api.HeightWeight;
import nz.co.manager.api.NameSet;
import nz.co.manager.api.WorldHook;
import nz.co.manager.api.WorldHookCategory;
import nz.co.manager.core.DiceService;
import nz.co.manager.core.HeightWeightService;
import nz.co.manager.core.NameGenerator;
import nz.co.manager.core.ServiceException;
import nz.co.manager.core.WorldHookService;

@Path("/tools")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ToolResource {

	class CategoryView {
		private int id;
		private String name;
		private List<WorldHookView> worldHooks = new ArrayList<>();

		public CategoryView(WorldHookCategory category) {
			this.id = category.getId();
			this.name = category.getName();
			if (category.getWorldHooks() != null) {
				category.getWorldHooks().forEach(h -> {
					this.worldHooks.add(new WorldHookView(h));
				});
			}
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<WorldHookView> getWorldHooks() {
			return worldHooks;
		}

		public void setWorldHooks(List<WorldHookView> worldHooks) {
			this.worldHooks = worldHooks;
		}
	}

	class WorldHookView {
		private int id;
		private String name;

		public WorldHookView(WorldHook hook) {
			this.id = hook.getId();
			this.name = hook.getName();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	private final NameGenerator nameGenerator;
	private final DiceService diceService;
	private final HeightWeightService heightWeightService;
	private final WorldHookService worldHookService;

	@Inject
	public ToolResource(final NameGenerator nameGenerator, final DiceService diceService,
			final HeightWeightService heightWeightService, final WorldHookService worldHookService) {
		this.nameGenerator = nameGenerator;
		this.diceService = diceService;
		this.heightWeightService = heightWeightService;
		this.worldHookService = worldHookService;
	}

	@Path("/names")
	@GET
	@UnitOfWork
	public Response readNameSets() {
		final List<NameSet> sets = nameGenerator.listNameSets();
		return Response.ok(sets).build();
	}

	@Path("/names/{type}/generate")
	@POST
	@UnitOfWork
	public Response generateName(final @PathParam("type") String type, final @QueryParam("numOf") Integer numOf) {
		return Response.ok(nameGenerator.nameList(type, numOf)).build();
	}

	@Path("/names/{type}")
	@POST
	@UnitOfWork
	public Response createNameSet(final @PathParam("type") String type, final List<String> names) {
		nameGenerator.createNameSet(type, names);
		return Response.created(UriBuilder.fromMethod(getClass(), "readNameSet").build(type)).build();
	}

	@Path("/names/{type}")
	@PUT
	@UnitOfWork
	public Response updateNameSet(final @PathParam("type") String type, final List<String> names) {
		nameGenerator.updateNameSet(type, names);
		return Response.ok(names).build();
	}

	@Path("/names/{type}")
	@DELETE
	@UnitOfWork
	public Response deleteNameSet(final @PathParam("type") String type) {
		nameGenerator.deleteNameSet(type);
		return Response.ok().build();
	}

	@Path("/names/{type}")
	@GET
	@UnitOfWork
	public Response readNameSet(final @PathParam("type") String type) {
		final NameSet set = nameGenerator.readNameSet(type);
		return Response.ok(set).build();
	}

	@Path("/dice/roll/{data:(\\d+)+d(\\d+)+[\\+-](\\d+)+}")
	@POST
	public Response rollDice(final @PathParam("data") String data,
			final @QueryParam("times") @DefaultValue("1") int times) throws ServiceException {
		final List<Integer> roll = diceService.roll(data, times);
		return Response.ok(roll).build();
	}

	@Path("/heightWeights")
	@GET
	@UnitOfWork
	public Response readHeightWeights() {
		final List<HeightWeight> sets = heightWeightService.listHeightWeights();
		return Response.ok(sets).build();
	}

	@Path("/heightWeights/{type}/generate")
	@POST
	@UnitOfWork
	public Response generateHeightWeight(final @PathParam("type") String type, final @QueryParam("times") Integer numOf)
			throws ServiceException {
		return Response.ok(heightWeightService.generate(type, numOf)).build();
	}

	@Path("/heightWeights")
	@POST
	@UnitOfWork
	public Response createHeightWeight(final HeightWeight names) {
		heightWeightService.createHeightWeight(names);
		return Response.ok(names).build();
	}

	@Path("/heightWeights")
	@PUT
	@UnitOfWork
	public Response updateHeightWeight(final HeightWeight names) {
		heightWeightService.updateHeightWeight(names);
		return Response.ok(names).build();
	}

	@Path("/heightWeights/{type}")
	@DELETE
	@UnitOfWork
	public Response deleteHeightWeight(final @PathParam("type") String type) {
		heightWeightService.deleteHeightWeight(type);
		return Response.ok().build();
	}

	@Path("/heightWeights/{type}")
	@GET
	@UnitOfWork
	public Response readHeightWeight(final @PathParam("type") String type) {
		final HeightWeight set = heightWeightService.readHeightWeight(type);
		return Response.ok(set).build();
	}

	@Path("/worldHooks")
	@GET
	@UnitOfWork
	public Response listWorldHooks() {
		final List<WorldHook> hooks = worldHookService.listWorldHooks();
		final List<WorldHookView> list = new ArrayList<>();
		hooks.forEach(h -> {
			list.add(new WorldHookView(h));
		});
		return Response.ok(hooks).build();
	}

	@Path("/worldHooks")
	@POST
	@UnitOfWork
	public Response createWorldHook(final WorldHook hook) {
		WorldHook worldHook = worldHookService.createWorldHook(hook);
		return Response.ok(new WorldHookView(worldHook)).build();
	}

	@Path("/worldHooks")
	@PUT
	@UnitOfWork
	public Response updateWorldHook(final WorldHook hook) {
		WorldHook worldHook = worldHookService.updateWorldHook(hook);
		return Response.ok(new WorldHookView(worldHook)).build();
	}

	@Path("/worldHooks/{id}")
	@DELETE
	@UnitOfWork
	public Response deleteWorldHook(final @PathParam("id") int id) {
		worldHookService.deleteWorldHook(id);
		return Response.ok().build();
	}

	@Path("/worldHooks/{id}")
	@GET
	@UnitOfWork
	public Response readWorldHook(final @PathParam("id") int id) {
		final WorldHook hook = worldHookService.readWorldHook(id);
		return Response.ok(new WorldHookView(hook)).build();
	}

	@Path("/worldHooks/generate")
	@POST
	@UnitOfWork
	public Response generateWorldHook(final @QueryParam("times") Integer numOf) throws ServiceException {
		final List<WorldHook> list = worldHookService.generate(numOf);
		final List<WorldHookView> hooks = new ArrayList<>();
		list.forEach(h -> {
			hooks.add(new WorldHookView(h));
		});
		return Response.ok(hooks).build();
	}

	@Path("/worldHookCategories")
	@GET
	@UnitOfWork
	public Response listWorldHookCategories() {
		final List<WorldHookCategory> hooks = worldHookService.listWorldHookCategories();
		final List<CategoryView> list = new ArrayList<>();
		hooks.forEach(h -> {
			list.add(new CategoryView(h));
		});
		return Response.ok(list).build();
	}

	@Path("/worldHookCategories")
	@POST
	@UnitOfWork
	public Response createWorldHookCategory(final WorldHookCategory hook) {
		WorldHookCategory worldHook = worldHookService.createWorldHookCategory(hook);
		return Response.ok(new CategoryView(worldHook)).build();
	}

	@Path("/worldHookCategories")
	@PUT
	@UnitOfWork
	public Response updateWorldHookCategory(final WorldHookCategory hook) {
		WorldHookCategory worldHook = worldHookService.updateWorldHookCategory(hook);
		return Response.ok(new CategoryView(worldHook)).build();
	}

	@Path("/worldHookCategories/{id}")
	@DELETE
	@UnitOfWork
	public Response deleteWorldHookCategory(final @PathParam("id") int id) {
		worldHookService.deleteWorldHookCategory(id);
		return Response.ok().build();
	}

	@Path("/worldHookCategories/{id}")
	@GET
	@UnitOfWork
	public Response readWorldHookCategory(final @PathParam("id") int id) {
		final WorldHookCategory hook = worldHookService.readWorldHookCategory(id);
		return Response.ok(new CategoryView(hook)).build();
	}
}
