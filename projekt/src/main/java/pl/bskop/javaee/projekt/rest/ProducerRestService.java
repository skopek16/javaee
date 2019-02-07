package pl.bskop.javaee.projekt.rest;

import pl.bskop.javaee.projekt.domain.Producer;
import pl.bskop.javaee.projekt.service.ProducerManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("producer")
public class ProducerRestService {

    @Inject
    ProducerManager producerManager;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Producer> getAllProducers(){
        return producerManager.getAllProducers();
    }

    @GET
    @Path("/{producerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producer getProducer(@PathParam("producerId") long id) {
        return producerManager.getProducer(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducer(Producer producer) {
        producerManager.addProducer(producer);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{producerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProducer(@PathParam("producerId") long id, Producer transientProducer) {
        Producer producer = producerManager.getProducer(id);

        producer.setName(transientProducer.getName());

        producerManager.updateProducer(producer);

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{producerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProducer(@PathParam("producerId") int id) {
        producerManager.deleteProducer(id);

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Producer REST Service is running.";
    }
}
