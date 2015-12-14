package formation.persistence.paramtypeQuestion;

import formation.domain.ParamtypeQuestion;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by victor on 14/12/2015.
 */
@Local
@Stateless
public class ParamtypeQuestionDAO implements ParamtypeQuestionDAOItf {

    @PersistenceContext(unitName = "projet")
    private EntityManager em;

    @Override
    public List<ParamtypeQuestion> findAll() {
        TypedQuery<ParamtypeQuestion> query = em.createNamedQuery("ParamtypeQuestion.findAll", ParamtypeQuestion.class);
        return query.getResultList();
    }
}
