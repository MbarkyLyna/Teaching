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
    public Response add (TeachingUI Unit) {
        if (businessUI.add(Unit))
            return Response.status(Response.Status.CREATED).entity("true").build();
        else
            return Response.status(Response.Status.NOT_FOUND).entity("false").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("M1")
    // We can use the Response or the List as the type of the  method
    public List<TeachingUI> displayTU() {
        if (businessUI.getAll().size() != 0)
            return businessUI.getAll();
        else return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response SearchBySemester(@QueryParam("semester") int semester) {
        return Response.status(Response.Status.FOUND).entity(businessUI.getBySemester(semester)).build();
    }

    @DELETE
    @Path("{code}")
    public boolean deleteSem(@PathParam("code") int code) {
        if (businessUI.delete(code))
            return true;
        return false;
    }

    @PUT
    @Path("{code}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response update(@PathParam("code") int code, TeachingUI unit) {
        if (businessUI.update(code, unit))
            return Response.status(Response.Status.OK).entity("updated").build();
        else
            return Response.status(Response.Status.NOT_FOUND).entity("not found").build();
    }

    @GET
    @Path("/m2")
    @Produces(MediaType.APPLICATION_JSON)
    public TeachingUI getByCode(@QueryParam("code") int code) {
            return businessUI.getByCode(code);
    }


    }