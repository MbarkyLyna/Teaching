package tn.esprit.spring;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.client.Entity.entity;

@Path("/modules")
public class ModuleResource {

    public static ModuleBusiness mb = new ModuleBusiness();

    @GET
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModuleByCode(@PathParam("code") String code) {
        Module m = mb.getModuleByCode(code);
        if (m != null)
            return Response.status(Response.Status.OK).entity(m).build();
        else return Response.status(Response.Status.NOT_FOUND).build();
     }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response AddModule (Module m){
        if (mb.addModule(m)){
            return Response.status(Response.Status.CREATED).entity(mb.getAllModules()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllModules(){
        List<Module> modules = mb.getAllModules();
        return Response.status(Response.Status.OK).entity(modules).build();
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
    @Path("/TU")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModuleByTU(@QueryParam("codeUE") int codeUE){
        TeachingUI tu = new TeachingUI();
        tu.setCode(codeUE);
        List<Module> m = mb.getModulesByTeachingUnit(tu);
        if (m.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
        }
        return Response.status(Response.Status.OK).entity(m).build();
    }


}