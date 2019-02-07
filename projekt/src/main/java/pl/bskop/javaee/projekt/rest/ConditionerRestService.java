package pl.bskop.javaee.projekt.rest;

import pl.bskop.javaee.projekt.domain.Conditioner;
import pl.bskop.javaee.projekt.domain.Producer;
import pl.bskop.javaee.projekt.service.ConditionerManager;
import pl.bskop.javaee.projekt.service.ProducerManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("conditioner")
public class ConditionerRestService {

    @Inject
    ConditionerManager conditionerManager;
    @Inject
    ProducerManager producerManager;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Conditioner> getAllConditioners(){
        return conditionerManager.getAllConditioners();
    }

    @GET
    @Path("/{conditionerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Conditioner getConditioner(@PathParam("conditionerId") long id) {
        return conditionerManager.getConditioner(id);
    }
    @GET
    @Path("/{capacity}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Conditioner> getConditionerByProducer(@PathParam("capacity") double  capacity) {
        return conditionerManager.getConditionerByCapacity(capacity);
    }
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addConditioner(Conditioner conditioner) {
        conditionerManager.addConditioner(conditioner);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{conditionerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateConditioner(@PathParam("conditionerId") long id, Conditioner transientConditioner) {
        Conditioner conditioner = conditionerManager.getConditioner(id);

        conditioner.setModel(transientConditioner.getModel());
        conditioner.setProduceDate(transientConditioner.getProduceDate());
        conditioner.setCapacity(transientConditioner.getCapacity());
        conditioner.setFans(transientConditioner.getFans());

        conditionerManager.updateConditioner(conditioner);

        return Response.status(Response.Status.OK).build();
    }
    @DELETE
    @Path("/")
    public Response deleteAllCondtioners(){
        conditionerManager.deleteAllConditioners();

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{conditionerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteConditioner(@PathParam("conditionerId") int id) {
        conditionerManager.deleteConditioner(id);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Conditioner REST Service is running.";
    }
}
