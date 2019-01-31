package pl.bskop.javaee.zad05.rest;

import pl.bskop.javaee.zad05.domain.Conditioner;
import pl.bskop.javaee.zad05.service.ConditionerManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("conditioner")
public class ConditionerRestService {

    @Inject
    ConditionerManager conditionerManager;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Conditioner> getAllConditioners(){
        return conditionerManager.getAllConditioners();
    }


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addConditioner(Conditioner conditioner) {
        conditionerManager.addConditioner(conditioner);

        return Response.status(Response.Status.CREATED).build();
    }


    @DELETE
    public Response clearPlanes() {
        conditionerManager.deleteAllConditioners();
        return Response.status(200).entity("All condtioners successfully deleted.").build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Conditioner REST Service is running.";
    }
}
