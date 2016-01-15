package formation.formation.service.rest;

import formation.domain.FormulaireReponses;
import formation.formation.service.itf.CustomerServiceItf;
import formation.formation.service.itf.FormulaireReponsesItf;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by victor on 12/12/2015.
 */

@Path("/formulaireReponses")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class FormulaireReponsesRestService {


    @EJB
    FormulaireReponsesItf service;

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id")Long id){
        FormulaireReponses fr = service.get(id);
        if(fr == null){
            throw new NotFoundException("FormulaireReponses is not found");
        }
        return Response.ok(fr).build();
    }

    @POST
    public Response create(FormulaireReponses formulaireReponses) throws Exception{
        FormulaireReponses fr = service.create(formulaireReponses);
        return Response.created(new URI("formulaireReponses/"+fr.getIdFormulaire())).build();
    }
}
