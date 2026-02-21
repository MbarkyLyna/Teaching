package tn.esprit.spring;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/modules")
public class ModuleResource {

    public static ModuleBusiness mb = new ModuleBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllModules() {
        return Response.ok(mb.getAllModules()).build();
    }

    @GET
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModuleByCode(@PathParam("code") String code) {
        Module m = mb.getModuleByCode(code);
        if (m == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(m).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addModule(Module m) {
        if (mb.addModule(m))
            return Response.status(Response.Status.CREATED).entity(m).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{code}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateModule(@PathParam("code") String code, Module m) {
        if (mb.updateModule(code, m))
            return Response.ok(m).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{code}")
    public Response deleteModule(@PathParam("code") String code) {
        if (mb.deleteModule(code))
            return Response.noContent().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}