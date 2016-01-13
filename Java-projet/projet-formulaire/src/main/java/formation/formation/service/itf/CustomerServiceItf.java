package formation.formation.service.itf;

import formation.domain.Customer;


public interface CustomerServiceItf {

    /**
     * Count the number of user.
     *
     * @return le nombre de user.
     */
    public int total();

    /**
     * Create a new user.
     *
     * @param user The user to create.
     * @return The created user.
     */
    public Customer create(Customer user);

    /**
     * Return the customer with the given identifier
     * @param id the identifier of the customer
     * @return  The found customer or null if not found.
     */
    public Customer get(int id);
}
