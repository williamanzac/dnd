package nz.co.manager.resources;

import java.util.List;
import java.util.Set;

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
import nz.co.manager.api.*;
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
	public Response listLandWaterMasses() {
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

	@Path("/tectonicPlates/generate")
	@POST
	@UnitOfWork
	public Response generateTechtonicPlates(final @QueryParam("times") Integer times) throws ServiceException {
		final List<PlateResults> results = planetologyService.generatePlates(times);
		return Response.ok(results).build();
	}

	@Path("/plateMovements")
	@GET
	@UnitOfWork
	public Response listPlateMovements() {
		final List<PlateMovement> hooks = planetologyService.listPlateMovements();
		return Response.ok(hooks).build();
	}

	@Path("/plateMovements")
	@POST
	@UnitOfWork
	public Response createPlateMovement(final PlateMovement hook) {
		PlateMovement landWaterDistribution = planetologyService.createPlateMovement(hook);
		return Response.ok(landWaterDistribution).build();
	}

	@Path("/plateMovements")
	@PUT
	@UnitOfWork
	public Response updatePlateMovement(final PlateMovement hook) {
		PlateMovement landWaterDistribution = planetologyService.updatePlateMovement(hook);
		return Response.ok(landWaterDistribution).build();
	}

	@Path("/plateMovements/{id}")
	@DELETE
	@UnitOfWork
	public Response deletePlateMovement(final @PathParam("id") int id) {
		planetologyService.deletePlateMovement(id);
		return Response.ok().build();
	}

	@Path("/plateMovements/{id}")
	@GET
	@UnitOfWork
	public Response readPlateMovement(final @PathParam("id") int id) {
		final PlateMovement hook = planetologyService.readPlateMovement(id);
		return Response.ok(hook).build();
	}

	@Path("/volcanicActivities")
	@GET
	@UnitOfWork
	public Response listVolcanicActivities() {
		final List<VolcanicActivity> hooks = planetologyService.listVolcanicActivities();
		return Response.ok(hooks).build();
	}

	@Path("/volcanicActivities")
	@POST
	@UnitOfWork
	public Response createVolcanicActivity(final VolcanicActivity hook) {
		VolcanicActivity landWaterDistribution = planetologyService.createVolcanicActivity(hook);
		return Response.ok(landWaterDistribution).build();
	}

	@Path("/volcanicActivities")
	@PUT
	@UnitOfWork
	public Response updateVolcanicActivity(final VolcanicActivity hook) {
		VolcanicActivity landWaterDistribution = planetologyService.updateVolcanicActivity(hook);
		return Response.ok(landWaterDistribution).build();
	}

	@Path("/volcanicActivities/{id}")
	@DELETE
	@UnitOfWork
	public Response deleteVolcanicActivity(final @PathParam("id") int id) {
		planetologyService.deleteVolcanicActivity(id);
		return Response.ok().build();
	}

	@Path("/volcanicActivities/{id}")
	@GET
	@UnitOfWork
	public Response readVolcanicActivity(final @PathParam("id") int id) {
		final VolcanicActivity hook = planetologyService.readVolcanicActivity(id);
		return Response.ok(hook).build();
	}

	@Path("/earthquakeActivities")
	@GET
	@UnitOfWork
	public Response listEarthquakeActivities() {
		final List<EarthquakeActivity> hooks = planetologyService.listEarthquakeActivities();
		return Response.ok(hooks).build();
	}

	@Path("/earthquakeActivities")
	@POST
	@UnitOfWork
	public Response createEarthquakeActivity(final EarthquakeActivity hook) {
		EarthquakeActivity landWaterDistribution = planetologyService.createEarthquakeActivity(hook);
		return Response.ok(landWaterDistribution).build();
	}

	@Path("/earthquakeActivities")
	@PUT
	@UnitOfWork
	public Response updateEarthquakeActivity(final EarthquakeActivity hook) {
		EarthquakeActivity landWaterDistribution = planetologyService.updateEarthquakeActivity(hook);
		return Response.ok(landWaterDistribution).build();
	}

	@Path("/earthquakeActivities/{id}")
	@DELETE
	@UnitOfWork
	public Response deleteEarthquakeActivity(final @PathParam("id") int id) {
		planetologyService.deleteEarthquakeActivity(id);
		return Response.ok().build();
	}

	@Path("/earthquakeActivities/{id}")
	@GET
	@UnitOfWork
	public Response readEarthquakeActivity(final @PathParam("id") int id) {
		final EarthquakeActivity hook = planetologyService.readEarthquakeActivity(id);
		return Response.ok(hook).build();
	}

	@Path("/earthquakeActivities/earthquakeStrengths")
	@GET
	@UnitOfWork
	public Response listEarthquakeStrengths() {
		final Set<EarthquakeStrength> hooks = planetologyService.listEarthquakeStrengths();
		return Response.ok(hooks).build();
	}

	@Path("/earthquakeActivities/earthquakeFrequencies")
	@GET
	@UnitOfWork
	public Response listEarthquakeFrequencies() {
		final Set<EarthquakeFrequency> hooks = planetologyService.listEarthquakeFrequencies();
		return Response.ok(hooks).build();
	}

	@Path("/mountainProperties")
	@GET
	@UnitOfWork
	public Response listMountainProperties() {
		final List<MountainProperty> hooks = planetologyService.listMountainProperties();
		return Response.ok(hooks).build();
	}

	@Path("/mountainProperties")
	@POST
	@UnitOfWork
	public Response createMountainProperty(final MountainProperty hook) {
		MountainProperty landWaterDistribution = planetologyService.createMountainProperty(hook);
		return Response.ok(landWaterDistribution).build();
	}

	@Path("/mountainProperties")
	@PUT
	@UnitOfWork
	public Response updateMountainProperty(final MountainProperty hook) {
		MountainProperty landWaterDistribution = planetologyService.updateMountainProperty(hook);
		return Response.ok(landWaterDistribution).build();
	}

	@Path("/mountainProperties/{id}")
	@DELETE
	@UnitOfWork
	public Response deleteMountainProperty(final @PathParam("id") int id) {
		planetologyService.deleteMountainProperty(id);
		return Response.ok().build();
	}

	@Path("/mountainProperties/{id}")
	@GET
	@UnitOfWork
	public Response readMountainProperty(final @PathParam("id") int id) {
		final MountainProperty hook = planetologyService.readMountainProperty(id);
		return Response.ok(hook).build();
	}

	@Path("/mountainPlacements")
	@GET
	@UnitOfWork
	public Response listMountainPlacements() {
		final List<MountainPlacement> hooks = planetologyService.listMountainPlacements();
		return Response.ok(hooks).build();
	}

	@Path("/mountainPlacements")
	@POST
	@UnitOfWork
	public Response createMountainPlacement(final MountainPlacement hook) {
		MountainPlacement landWaterDistribution = planetologyService.createMountainPlacement(hook);
		return Response.ok(landWaterDistribution).build();
	}

	@Path("/mountainPlacements")
	@PUT
	@UnitOfWork
	public Response updateMountainPlacement(final MountainPlacement hook) {
		MountainPlacement landWaterDistribution = planetologyService.updateMountainPlacement(hook);
		return Response.ok(landWaterDistribution).build();
	}

	@Path("/mountainPlacements/{id}")
	@DELETE
	@UnitOfWork
	public Response deleteMountainPlacement(final @PathParam("id") int id) {
		planetologyService.deleteMountainPlacement(id);
		return Response.ok().build();
	}

	@Path("/mountainPlacements/{id}")
	@GET
	@UnitOfWork
	public Response readMountainPlacement(final @PathParam("id") int id) {
		final MountainPlacement hook = planetologyService.readMountainPlacement(id);
		return Response.ok(hook).build();
	}
}
