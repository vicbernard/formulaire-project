package formation.persistence.customer;

import formation.domain.Customer;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Local
@Stateless
public class CustomerDAO implements CustomerDAOItf {

    @PersistenceContext(unitName = "projet")
    private EntityManager em;

    @Override
    public List<Customer> findAll() {
         TypedQuery<Customer> query = em.createNamedQuery("Customer.findAll", Customer.class);
         return query.getResultList();
    }

    @Override
    public Customer create(Customer user) {
        //TODO manage transaction ??
        try {
            em.persist(user);
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
                throw new IllegalArgumentException(constraintViolation.getMessage(), e);
            }
        }
            return user;
    }

    @Override
    public Customer find(Long id){return em.find(Customer.class,id);}


}
