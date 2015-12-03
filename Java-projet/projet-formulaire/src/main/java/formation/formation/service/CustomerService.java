package formation.formation.service;

import formation.domain.Customer;
import formation.persistence.CustomerDAOItf;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Service Customer
 */
@Remote
@Stateless
public class CustomerService implements CustomerServiceItf{

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
