package nz.co.manager.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.manager.api.SeasonalVariation;
import nz.co.manager.core.SeasonalVariationService;

@Path("/tools/worldBuilder/planetology/seasonalVariations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SeasonalVariationResource extends CRUDResource<SeasonalVariation> {

	@Inject
	public SeasonalVariationResource(final SeasonalVariationService service) {
		super(service);
	}
}
