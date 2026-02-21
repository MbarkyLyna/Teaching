package tn.esprit.spring;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("UI")
public class RessourceUI {
    BusinessUI businessUI = new BusinessUI();

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response add(TeachingUI Unit) {
        if (businessUI.add(Unit))
            return Response.status(Response.Status.CREATED).entity("true").build();
        else
            return Response.status(Response.Status.NOT_FOUND).entity("false").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TeachingUI> displayTU() {
        if (businessUI.getAll().size() != 0)
            return businessUI.getAll();
        else return null;
    }

    @GET
    @Path("/m1")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBySemester(@QueryParam("semester") int semester) {
        return Response.status(Response.Status.FOUND).entity(businessUI.getBySemester(semester)).build();
    }

    @PUT
    @Path("{code}")
    public Response UpdateUI(@PathParam("code") int code, TeachingUI Unit) {
        if (businessUI.update(code, Unit)) {
            return Response.status(Response.Status.OK).entity(businessUI.update(code, Unit)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("not found").build();
    }

    @GET
    @Path("/m2")
    @Produces(MediaType.APPLICATION_JSON)
    public TeachingUI getByCode(@QueryParam("code") int code) {
        return (businessUI.getByCode(code));
    }
}