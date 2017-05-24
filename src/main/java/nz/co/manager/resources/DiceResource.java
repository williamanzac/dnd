package nz.co.manager.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nz.co.manager.core.DiceService;
import nz.co.manager.core.ServiceException;

@Path("/tools/dice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DiceResource {

	private final DiceService diceService;

	@Inject
	public DiceResource(final DiceService diceService) {
		this.diceService = diceService;
	}

	@Path("/roll/{data:(\\d+)+d(\\d+)+[\\+-](\\d+)+}")
	@POST
	public Response rollDice(final @PathParam("data") String data,
			final @QueryParam("times") @DefaultValue("1") int times) throws ServiceException {
		final List<Integer> roll = diceService.roll(data, times);
		return Response.ok(roll).build();
	}
}
