package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.LandWaterDistribution;
import nz.co.manager.core.LandWaterDistributionService;

@Path("/tools/worldBuilder/planetology/landWaterDistributions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LandWaterDistributionResource extends CRUDResource<LandWaterDistribution> {

	@Inject
	public LandWaterDistributionResource(LandWaterDistributionService service) {
		super(service);
	}
}
