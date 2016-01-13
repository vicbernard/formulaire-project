package formation.formation.service.rest;

import formation.classTmp.ReponseMoyenne;
import formation.domain.Question;
import formation.domain.Reponse;
import formation.formation.service.itf.ReponseItf;
import formation.persistence.question.QuestionDAOItf;
import formation.persistence.reponse.ReponseDAOItf;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

/**
 * Created by victor on 12/12/2015.
 */

@Path("/reponse")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Stateless
public class ReponseRestService {

    @EJB
    ReponseItf service;

    @EJB
    QuestionDAOItf questionDAOItf;

    @EJB
    ReponseDAOItf reponseDAOItf;

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

    @GET
    @Path("/moyenne")
    public Response getMoyenne(){
        List<Question> listQ = questionDAOItf.findAll();

        if(listQ == null || listQ.isEmpty()){
            throw new NotFoundException("Question is not found");
        }

        List<Reponse> reponses = reponseDAOItf.findByQuestion(listQ.get(0).getIdQuestion());
        //if(reponses == null || reponses.isEmpty()){
          //  throw new NotFoundException("Reponse is not found");
        //}
        System.out.println("taille: "+reponses.size());
        ReponseMoyenne rspm = new ReponseMoyenne();
        rspm.setLibelleQuestion(listQ.get(0).getLibelle());
        for(Reponse resp : reponses){
            System.out.println(resp.getReponse());
            if(resp.getReponse().equals("Non")){
                rspm.setNbNon(rspm.getNbNon()+1);
            }else{
                rspm.setNbOui(rspm.getNbOui()+1);
            }
        }
        return Response.ok(rspm).build();
    }
}
