package formation.formation.service;

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
}
