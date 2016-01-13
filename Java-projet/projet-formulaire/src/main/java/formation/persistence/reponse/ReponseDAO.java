package formation.persistence.reponse;

import formation.domain.Reponse;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * Created by victor on 14/12/2015.
 */
@Local
@Stateless
public class ReponseDAO implements ReponseDAOItf {

    @PersistenceContext(unitName = "projet")
    private EntityManager em;

    @Override
    public List<Reponse> findAll() {
        TypedQuery<Reponse> query = em.createNamedQuery("Reponse.findAll", Reponse.class);
        return query.getResultList();
    }

    @Override
    public Reponse create(Reponse reponse) {
        //TODO manage transaction ??
        try {
            em.persist(reponse);
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
                throw new IllegalArgumentException(constraintViolation.getMessage(), e);
            }
        }
        return reponse;
    }

    @Override
    public Reponse find(Long id) {
        return em.find(Reponse.class,id);
    }

    @Override
    public List<Reponse> findByQuestion(int id) {
        TypedQuery<Reponse> query = em.createNamedQuery("Reponse.findByQuestion", Reponse.class);
        query.setParameter("id",id);
        return query.getResultList();
    }
}
