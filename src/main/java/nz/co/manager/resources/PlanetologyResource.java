package nz.co.manager.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import nz.co.manager.api.DisplayType;
import nz.co.manager.api.LandWaterDistribution;
import nz.co.manager.api.LandWaterMass;
import nz.co.manager.api.LandWaterMassResults;
import nz.co.manager.api.RegionType;
import nz.co.manager.api.WorldHydrography;
import nz.co.manager.api.WorldShape;
import nz.co.manager.api.WorldSize;
import nz.co.manager.core.PlanetologyService;
import nz.co.manager.core.ServiceException;

@Path("/tools/worldBuilder/planetology")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlanetologyResource {

	private final PlanetologyService planetologyService;

	@Inject
	public PlanetologyResource(PlanetologyService planetologyService) {
		this.planetologyService = planetologyService;
	}

	@Path("/worldShapes")
	@GET
	@UnitOfWork
	public Response listWorldShapes() {
		final List<WorldShape> hooks = planetologyService.listWorldShapes();
		return Response.ok(hooks).build();
	}

	@Path("/worldShapes")
	@POST
	@UnitOfWork
	public Response createWorldShape(final WorldShape hook) {
		WorldShape worldShape = planetologyService.createWorldShape(hook);
		return Response.ok(worldShape).build();
	}

	@Path("/worldShapes")
	@PUT
	@UnitOfWork
	public Response updateWorldShape(final WorldShape hook) {
		WorldShape worldShape = planetologyService.updateWorldShape(hook);
		return Response.ok(worldShape).build();
	}

	@Path("/worldShapes/{id}")
	@DELETE
	@UnitOfWork
	public Response deleteWorldShape(final @PathParam("id") int id) {
		planetologyService.deleteWorldShape(id);
		return Response.ok().build();
	}

	@Path("/worldShapes/{id}")
	@GET
	@UnitOfWork
	public Response readWorldShape(final @PathParam("id") int id) {
		final WorldShape hook = planetologyService.readWorldShape(id);
		return Response.ok(hook).build();
	}

	@Path("/worldShapes/generate")
	@POST
	@UnitOfWork
	public Response generateWorldShape(final @QueryParam("times") Integer numOf) throws ServiceException {
		final List<WorldShape> hooks = planetologyService.generateWorldShape(numOf);
		return Response.ok(hooks).build();
	}

	@Path("/worldSizes")
	@GET
	@UnitOfWork
	public Response listWorldSizes() {
		final List<WorldSize> hooks = planetologyService.listWorldSizes();
		return Response.ok(hooks).build();
	}

	@Path("/worldSizes")
	@POST
	@UnitOfWork
	public Response createWorldSize(final WorldSize hook) {
		WorldSize worldSize = planetologyService.createWorldSize(hook);
		return Response.ok(worldSize).build();
	}

	@Path("/worldSizes")
	@PUT
	@UnitOfWork
	public Response updateWorldSize(final WorldSize hook) {
		WorldSize worldSize = planetologyService.updateWorldSize(hook);
		return Response.ok(worldSize).build();
	}

	@Path("/worldSizes/{id}")
	@DELETE
	@UnitOfWork
	public Response deleteWorldSize(final @PathParam("id") int id) {
		planetologyService.deleteWorldSize(id);
		return Response.ok().build();
	}

	@Path("/worldSizes/{id}")
	@GET
	@UnitOfWork
	public Response readWorldSize(final @PathParam("id") int id) {
		final WorldSize hook = planetologyService.readWorldSize(id);
		return Response.ok(hook).build();
	}

	@Path("/worldSizes/generate")
	@POST
	@UnitOfWork
	public Response generateWorldSize(final @QueryParam("times") Integer numOf) throws ServiceException {
		final List<WorldSize> hooks = planetologyService.generateWorldSize(numOf);
		return Response.ok(hooks).build();
	}

	@Path("/hydrographies")
	@GET
	@UnitOfWork
	public Response listWorldHydrographies() {
		final List<WorldHydrography> hooks = planetologyService.listWorldHydrographies();
		return Response.ok(hooks).build();
	}

	@Path("/hydrographies")
	@POST
	@UnitOfWork
	public Response createWorldHydrography(final WorldHydrography hook) {
		WorldHydrography worldHydrography = planetologyService.createWorldHydrography(hook);
		return Response.ok(worldHydrography).build();
	}

	@Path("/hydrographies")
	@PUT
	@UnitOfWork
	public Response updateWorldHydrography(final WorldHydrography hook) {
		WorldHydrography worldHydrography = planetologyService.updateWorldHydrography(hook);
		return Response.ok(worldHydrography).build();
	}

	@Path("/hydrographies/{id}")
	@DELETE
	@UnitOfWork
	public Response deleteWorldHydrography(final @PathParam("id") int id) {
		planetologyService.deleteWorldHydrography(id);
		return Response.ok().build();
	}

	@Path("/hydrographies/{id}")
	@GET
	@UnitOfWork
	public Response readWorldHydrography(final @PathParam("id") int id) {
		final WorldHydrography hook = planetologyService.readWorldHydrography(id);
		return Response.ok(hook).build();
	}

	@Path("/hydrographies/generate")
	@POST
	@UnitOfWork
	public Response generateWorldHydrography(final @QueryParam("times") Integer numOf) throws ServiceException {
		final List<WorldHydrography> hooks = planetologyService.generateWorldHydrography(numOf);
		return Response.ok(hooks).build();
	}

	@Path("/regionTypes")
	@GET
	@UnitOfWork
	public Response listRegionTypes() {
		final List<RegionType> hooks = planetologyService.listRegionTypes();
		return Response.ok(hooks).build();
	}

	@Path("/regionTypes")
	@POST
	@UnitOfWork
	public Response createRegionType(final RegionType hook) {
		RegionType regionType = planetologyService.createRegionType(hook);
		return Response.ok(regionType).build();
	}

	@Path("/regionTypes")
	@PUT
	@UnitOfWork
	public Response updateRegionType(final RegionType hook) {
		RegionType regionType = planetologyService.updateRegionType(hook);
		return Response.ok(regionType).build();
	}

	@Path("/regionTypes/{id}")
	@DELETE
	@UnitOfWork
	public Response deleteRegionType(final @PathParam("id") int id) {
		planetologyService.deleteRegionType(id);
		return Response.ok().build();
	}

	@Path("/regionTypes/{id}")
	@GET
	@UnitOfWork
	public Response readRegionType(final @PathParam("id") int id) {
		final RegionType hook = planetologyService.readRegionType(id);
		return Response.ok(hook).build();
	}

	@Path("/displayTypes")
	@GET
	@UnitOfWork
	public Response listDisplayTypes() {
		final List<DisplayType> hooks = planetologyService.listDisplayTypes();
		return Response.ok(hooks).build();
	}

	@Path("/displayTypes")
	@POST
	@UnitOfWork
	public Response createDisplayType(final DisplayType hook) {
		DisplayType displayType = planetologyService.createDisplayType(hook);
		return Response.ok(displayType).build();
	}

	@Path("/displayTypes")
	@PUT
	@UnitOfWork
	public Response updateDisplayType(final DisplayType hook) {
		DisplayType displayType = planetologyService.updateDisplayType(hook);
		return Response.ok(displayType).build();
	}

	@Path("/displayTypes/{id}")
	@DELETE
	@UnitOfWork
	public Response deleteDisplayType(final @PathParam("id") int id) {
		planetologyService.deleteDisplayType(id);
		return Response.ok().build();
	}

	@Path("/displayTypes/{id}")
	@GET
	@UnitOfWork
	public Response readDisplayType(final @PathParam("id") int id) {
		final DisplayType hook = planetologyService.readDisplayType(id);
		return Response.ok(hook).build();
	}

	@Path("/landWaterDistributions")
	@GET
	@UnitOfWork
	public Response listLandWaterDistributions() {
		final List<LandWaterDistribution> hooks = planetologyService.listLandWaterDistributions();
		return Response.ok(hooks).build();
	}

	@Path("/landWaterDistributions")
	@POST
	@UnitOfWork
	public Response createLandWaterDistribution(final LandWaterDistribution hook) {
		LandWaterDistribution landWaterDistribution = planetologyService.createLandWaterDistribution(hook);
		return Response.ok(landWaterDistribution).build();
	}

	@Path("/landWaterDistributions")
	@PUT
	@UnitOfWork
	public Response updateLandWaterDistribution(final LandWaterDistribution hook) {
		LandWaterDistribution landWaterDistribution = planetologyService.updateLandWaterDistribution(hook);
		return Response.ok(landWaterDistribution).build();
	}

	@Path("/landWaterDistributions/{id}")
	@DELETE
	@UnitOfWork
	public Response deleteLandWaterDistribution(final @PathParam("id") int id) {
		planetologyService.deleteLandWaterDistribution(id);
		return Response.ok().build();
	}

	@Path("/landWaterDistributions/{id}")
	@GET
	@UnitOfWork
	public Response readLandWaterDistribution(final @PathParam("id") int id) {
		final LandWaterDistribution hook = planetologyService.readLandWaterDistribution(id);
		return Response.ok(hook).build();
	}

	@Path("/landWaterMasses")
	@GET
	@UnitOfWork
	public Response listLandWaterMassses() {
		final List<LandWaterMass> hooks = planetologyService.listLandWaterMasses();
		return Response.ok(hooks).build();
	}

	@Path("/landWaterMasses")
	@POST
	@UnitOfWork
	public Response createLandWaterMass(final LandWaterMass hook) {
		LandWaterMass landWaterDistribution = planetologyService.createLandWaterMass(hook);
		return Response.ok(landWaterDistribution).build();
	}

	@Path("/landWaterMasses")
	@PUT
	@UnitOfWork
	public Response updateLandWaterMass(final LandWaterMass hook) {
		LandWaterMass landWaterDistribution = planetologyService.updateLandWaterMass(hook);
		return Response.ok(landWaterDistribution).build();
	}

	@Path("/landWaterMasses/{id}")
	@DELETE
	@UnitOfWork
	public Response deleteLandWaterMass(final @PathParam("id") int id) {
		planetologyService.deleteLandWaterMass(id);
		return Response.ok().build();
	}

	@Path("/landWaterMasses/{id}")
	@GET
	@UnitOfWork
	public Response readLandWaterMass(final @PathParam("id") int id) {
		final LandWaterMass hook = planetologyService.readLandWaterMass(id);
		return Response.ok(hook).build();
	}

	@Path("/landWaterMasses/generate")
	@POST
	@UnitOfWork
	public Response generateLandWaterMasses(final @QueryParam("hId") int hId, final @QueryParam("dId") int dId)
			throws ServiceException {
		final LandWaterMassResults results = planetologyService.generateLandWaterMasses(hId, dId);
		return Response.ok(results).build();
	}
}
