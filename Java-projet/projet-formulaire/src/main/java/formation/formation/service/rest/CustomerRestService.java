package formation.formation.service.rest;

import formation.domain.Customer;
import formation.formation.service.itf.CustomerServiceItf;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;


/**
 * Created by victor on 03/12/2015.
 */

@Path("/customer")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Stateless
public class CustomerRestService {

    @EJB
    CustomerServiceItf service;

    @PersistenceContext(unitName = "projet")
    private EntityManager em;

    @GET
    @Path("/count")
    public Response total(){
        return Response.ok(service.total()).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id")int id){
        Customer c = em.find(Customer.class,id);
        if(c == null){
            throw new NotFoundException("Customer is not found");
        }
        return Response.ok(c).build();
    }

    @POST
    public Response create(Customer customer) throws Exception{
        Customer c = service.create(customer);
        return Response.created(new URI("customer/"+c.getId())).build();
    }
}
