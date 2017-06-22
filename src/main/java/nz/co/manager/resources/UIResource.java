package nz.co.manager.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import nz.co.manager.views.GenericView;

@Path("/ui/{sub: .*}")
@Produces(MediaType.TEXT_HTML)
public class UIResource {

	@Context
	UriInfo uriInfo;

	@GET
	public Response html() {
		System.out.println(uriInfo);
		return Response.ok(new GenericView(uriInfo.getPath())).build();
	}
}
