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
    @Path("/model/{modelName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Conditioner getConditioner(@PathParam("modelName") String modelName) {
        return conditionerManager.getConditionerByModelName(modelName);
    }

    @GET
    @Path("/{capacity}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Conditioner> getConditionerByCapacity(@PathParam("capacity") double  capacity) {
        return conditionerManager.getConditionerByCapacity(capacity);
    }
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addConditioner(Conditioner conditioner) {
        conditionerManager.addConditioner(conditioner);

        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/model/{modelID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addConditionerWithModel(@PathParam("modelID") int  modelID,Conditioner conditioner) {
        int flag=0;
        flag = conditionerManager.addConditionerWithModel(conditioner,modelID);
        if(flag==1){ return  Response.status(403).type("text/plain").entity("model already in used").build();}

        return Response.status(Response.Status.CREATED).build();
    }


    @POST
    @Path("/producer/{prodID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addConditionerWithProducer(@PathParam("prodID") int  prodID,Conditioner conditioner) {

      conditionerManager.addConditionerWithProducer(conditioner,prodID);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{conditionerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateConditioner(@PathParam("conditionerId") long id, Conditioner transientConditioner) {
        Conditioner conditioner = conditionerManager.getConditioner(id);


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
