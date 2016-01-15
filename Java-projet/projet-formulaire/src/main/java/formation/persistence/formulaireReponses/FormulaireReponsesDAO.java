package formation.persistence.formulaireReponses;

import formation.domain.FormulaireReponses;

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
public class FormulaireReponsesDAO implements FormulaireReponsesDAOItf {

    @PersistenceContext(unitName = "projet")
    private EntityManager em;

    @Override
    public List<FormulaireReponses> findAll() {
        TypedQuery<FormulaireReponses> query = em.createNamedQuery("FormulaireReponsesDAO.findAll", FormulaireReponses.class);
        return query.getResultList();
    }

    @Override
    public FormulaireReponses create(FormulaireReponses formulaireReponses) {
        //TODO manage transaction ??
        try {
            em.persist(formulaireReponses);
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
                throw new IllegalArgumentException(constraintViolation.getMessage(), e);
            }
        }
        return formulaireReponses;
    }

    @Override
    public FormulaireReponses find(Long id) {
       return em.find(FormulaireReponses.class,id);
    }
}
