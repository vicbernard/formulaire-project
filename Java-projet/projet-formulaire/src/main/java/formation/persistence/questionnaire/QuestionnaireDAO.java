package formation.persistence.questionnaire;

import formation.domain.Questionnaire;

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
public class QuestionnaireDAO implements QuestionnaireDAOItf {

    @PersistenceContext(unitName = "projet")
    private EntityManager em;

    @Override
    public List<Questionnaire> findAll() {
        TypedQuery<Questionnaire> query = em.createNamedQuery("Questionnaire.findAll", Questionnaire.class);
        return query.getResultList();
    }

    @Override
    public Questionnaire create(Questionnaire questionnaire) {
        //TODO manage transaction ??
        try {
            em.persist(questionnaire);
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
                throw new IllegalArgumentException(constraintViolation.getMessage(), e);
            }
        }
        return questionnaire;

    }

    @Override
    public Questionnaire find(Long id) {
        return em.find(Questionnaire.class,id);
    }

    @Override
    public List<Questionnaire> ListQuestionnaireFindByUser(int idUser) {
        TypedQuery<Questionnaire> query = em.createNamedQuery("Questionnaire.findByUser", Questionnaire.class);
        query.setParameter("idUser", idUser);
        return query.getResultList();
    }
}
