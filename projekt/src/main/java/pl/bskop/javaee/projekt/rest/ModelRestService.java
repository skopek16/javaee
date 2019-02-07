package pl.bskop.javaee.projekt.rest;

import pl.bskop.javaee.projekt.domain.Model;
import pl.bskop.javaee.projekt.service.ModelManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("model")
public class ModelRestService {

    @Inject
    ModelManager modelManager;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Model> getAllModels(){
        return modelManager.getAllModels();
    }

    @GET
    @Path("/{modelId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Model getModel(@PathParam("modelId") int id) {
        return modelManager.getModel(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addModel(Model model) {
        modelManager.addModel(model);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{modelId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateModel(@PathParam("modelId") int id, Model transientModel) {
        Model model = modelManager.getModel(id);

        model.setName(transientModel.getName());

        modelManager.updateModel(model);

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{modelId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteConditioner(@PathParam("modelId") int id) {
        modelManager.deleteModel(id);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Model REST Service is running.";
    }
}
