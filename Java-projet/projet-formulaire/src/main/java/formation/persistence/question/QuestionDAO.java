package formation.persistence.question;

import formation.domain.Question;

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
public class QuestionDAO implements QuestionDAOItf {

    @PersistenceContext(unitName = "projet")
    private EntityManager em;

    @Override
    public List<Question> findAll() {
        TypedQuery<Question> query = em.createNamedQuery("Question.findAll", Question.class);
        return query.getResultList();
    }

    @Override
    public Question create(Question question) {
        //TODO manage transaction ??
        try {
            em.persist(question);
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
                throw new IllegalArgumentException(constraintViolation.getMessage(), e);
            }
        }
        return question;
    }

    @Override
    public Question find(int id) {
        return em.find(Question.class,id);
    }

    @Override
    public List<Question> findByQuestionnaireId(int id) {
        TypedQuery<Question> query = em.createNamedQuery("Question.findByQuestionnaire", Question.class);
        query.setParameter("idQuestionnaire", id);
        return query.getResultList();
    }
}
