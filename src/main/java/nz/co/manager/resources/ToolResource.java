package nz.co.manager.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import io.dropwizard.hibernate.UnitOfWork;
import nz.co.manager.api.HeightWeight;
import nz.co.manager.api.NameSet;
import nz.co.manager.core.DiceService;
import nz.co.manager.core.HeightWeightService;
import nz.co.manager.core.NameGenerator;
import nz.co.manager.core.ServiceException;

@Path("/tools")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ToolResource {

	private final NameGenerator nameGenerator;
	private final DiceService diceService;
	private final HeightWeightService heightWeightService;

	@Inject
	public ToolResource(final NameGenerator nameGenerator, final DiceService diceService,
			final HeightWeightService heightWeightService) {
		this.nameGenerator = nameGenerator;
		this.diceService = diceService;
		this.heightWeightService = heightWeightService;
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
}
