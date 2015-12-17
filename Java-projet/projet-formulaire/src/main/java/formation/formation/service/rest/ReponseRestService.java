package formation.formation.service.rest;

import formation.domain.Reponse;
import formation.formation.service.itf.ReponseItf;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by victor on 12/12/2015.
 */

@Path("/reponse")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class ReponseRestService {

    @EJB
    ReponseItf service;

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id")Long id){
        Reponse r = service.get(id);
        if(r == null){
            throw new NotFoundException("Reponse is not found");
        }
        return Response.ok(r).build();
    }

    @POST
    public Response create(Reponse reponse) throws Exception{
        Reponse r = service.create(reponse);
        return Response.created(new URI("reponse/"+r.getIdReponse())).build();
    }
}
