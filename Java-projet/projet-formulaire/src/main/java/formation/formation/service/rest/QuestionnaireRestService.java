package formation.formation.service.rest;

import formation.domain.Questionnaire;
import formation.formation.service.itf.QuestionnaireItf;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by victor on 12/12/2015.
 */

@Path("/questionnaire")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class QuestionnaireRestService {

    @EJB
    QuestionnaireItf service;

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id")Long id){
        Questionnaire q = service.get(id);
        if(q == null){
            throw new NotFoundException("Questionnaire is not found");
        }
        return Response.ok(q).build();
    }

    @POST
    public Response create(Questionnaire questionnaire) throws Exception{
        Questionnaire q = service.create(questionnaire);
        return Response.created(new URI("questionnaire/"+q.getIdQuestionnaire())).build();
    }

}
