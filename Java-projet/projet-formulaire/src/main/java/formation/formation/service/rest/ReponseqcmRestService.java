package formation.formation.service.rest;

import formation.domain.Reponse;
import formation.domain.Reponseqcm;
import formation.formation.service.itf.ReponseqcmItf;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by victor on 12/12/2015.
 */

@Path("/reponseqcm")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class ReponseqcmRestService {

    @EJB
    ReponseqcmItf service;

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id")Long id){
        Reponseqcm r = service.get(id);
        if(r == null){
            throw new NotFoundException("Reponse is not found");
        }
        return Response.ok(r).build();
    }

    @POST
    public Response create(Reponseqcm reponseqcm) throws Exception{
        Reponseqcm r = service.create(reponseqcm);
        return Response.created(new URI("reponseqcm/"+r.getIdReponseQcm())).build();
    }

}
