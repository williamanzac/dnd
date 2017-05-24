package nz.co.manager.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import io.dropwizard.hibernate.UnitOfWork;
import nz.co.manager.core.CRUDService;
import nz.co.manager.jdbi.Idable;

public abstract class CRUDResource<E extends Idable> {
	protected final CRUDService<E> service;

	public CRUDResource(final CRUDService<E> service) {
		this.service = service;
	}

	@GET
	@UnitOfWork
	public Response list() {
		final List<E> list = service.list();
		return Response.ok(list).build();
	}

	@POST
	@UnitOfWork
	public Response create(final E entity) {
		final E created = service.create(entity);
		return Response.ok(created).build();
	}

	@PUT
	@UnitOfWork
	public Response update(final E entity) {
		final E updated = service.update(entity);
		return Response.ok(updated).build();
	}

	@Path("/{id}")
	@DELETE
	@UnitOfWork
	public Response delete(final @PathParam("id") int id) {
		service.delete(id);
		return Response.ok().build();
	}

	@Path("/{id}")
	@GET
	@UnitOfWork
	public Response read(final @PathParam("id") int id) {
		final E entity = service.read(id);
		return Response.ok(entity).build();
	}
}
