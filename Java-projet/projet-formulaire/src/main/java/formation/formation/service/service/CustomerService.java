package formation.formation.service.service;

import formation.domain.Customer;
import formation.formation.service.itf.CustomerServiceItf;
import formation.persistence.customer.CustomerDAOItf;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Service Customer
 */
@Remote
@Stateless
public class CustomerService implements CustomerServiceItf {

    @EJB
    CustomerDAOItf dao;

    @Override
    public int total() {
        return dao.findAll().size();
    }

    @Override
    public Customer create(Customer user) {
        //FIXME validate user
        Customer u =  dao.create(user);
        return u;
    }

    @Override
    public Customer get(Long id){return dao.find(id);}
}
