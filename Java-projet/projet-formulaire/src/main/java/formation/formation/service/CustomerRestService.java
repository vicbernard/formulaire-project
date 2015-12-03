package formation.formation.service;

import formation.domain.Customer;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;


/**
 * Created by victor on 03/12/2015.
 */

@Path("/customer")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class CustomerRestService {

    @EJB
    CustomerServiceItf service;

    @GET
    @Path("/count")
    public Response total(){
        return Response.ok(service.total()).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id")Long id){
        Customer c = service.get(id);
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
