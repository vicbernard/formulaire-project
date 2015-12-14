package formation.persistence.reponseqcm;

import formation.domain.Reponseqcm;

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
public class ReponseqcmDAO implements ReponseqcmDAOItf {

    @PersistenceContext(unitName = "projet")
    private EntityManager em;

    @Override
    public List<Reponseqcm> findAll() {
        TypedQuery<Reponseqcm> query = em.createNamedQuery("Reponseqcm.findAll", Reponseqcm.class);
        return query.getResultList();
    }

    @Override
    public Reponseqcm create(Reponseqcm reponseqcm) {
        //TODO manage transaction ??
        try {
            em.persist(reponseqcm);
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
                throw new IllegalArgumentException(constraintViolation.getMessage(), e);
            }
        }
        return reponseqcm;

    }

    @Override
    public Reponseqcm find(Long id) {
        return em.find(Reponseqcm.class,id);
    }
}
