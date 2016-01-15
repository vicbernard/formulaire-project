package formation.persistence.customer;

import formation.domain.Customer;

import javax.ejb.Local;
import java.util.List;
import java.util.Set;


public interface CustomerDAOItf {

    /**
     * Return all users in the database
     *
     * @return a set of user
     */
    public List<Customer> findAll();

    /**
     * allow to create user (without id)
     *
     * @param user The user to create.
     * @return the new user.
     */
    public Customer create(Customer user);

    /**
     * Find a customer with the given identifier
     *
     * @param id The id of the customer
     * @return The found customer or null if not found
     */
    public Customer find(int id);

    public Customer connection(String mail, String mdp);
}
