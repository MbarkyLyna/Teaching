package tn.esprit.spring;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("UI")
public class RessourceUI {
    BusinessUI businessUI = new BusinessUI();
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void add (TeachingUI unit ){
        BusinessUI.add(unit);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TeachingUI> displayTU(){

        if ( businessUI.getAll().size() != 0 )
            return businessUI.getAll() ;
            else return null;

    }

}
