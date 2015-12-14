package formation.formation.service.rest;

import formation.domain.ParamtypeQuestion;
import formation.formation.service.itf.ParamtypeQuestionItf;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by victor on 12/12/2015.
 */

@Path("/paramtypeQuestion")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class ParamtypeQuestionRestService {

    @EJB
    ParamtypeQuestionItf service;

    @GET
    public Response get(){
        List<ParamtypeQuestion> list = service.getAll();
        if(list == null){
            throw new NotFoundException("ParamtypeQuestion is not found");
        }
        return Response.ok(list).build();
    }
}
