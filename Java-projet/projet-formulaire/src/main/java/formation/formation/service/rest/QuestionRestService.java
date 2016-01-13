package formation.formation.service.rest;

import formation.domain.Question;
import formation.formation.service.itf.QuestionItf;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by victor on 12/12/2015.
 */

@Path("/question")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class QuestionRestService {

    @EJB
    QuestionItf service;

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id")Long id){
        Question q = service.get(id);
        if(q == null){
            throw new NotFoundException("Question is not found");
        }
        return Response.ok(q).build();
    }

    @POST
    public Response create(Question question) throws Exception{
        Question q = service.create(question);
        return Response.created(new URI("question/"+q.getIdQuestion())).build();
    }
}
