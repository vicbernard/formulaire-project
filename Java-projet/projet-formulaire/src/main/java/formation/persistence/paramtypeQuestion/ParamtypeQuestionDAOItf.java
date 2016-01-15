package formation.persistence.paramtypeQuestion;

import formation.domain.ParamtypeQuestion;

import java.util.List;

/**
 * Created by victor on 14/12/2015.
 */
public interface ParamtypeQuestionDAOItf {

    public List<ParamtypeQuestion> findAll();
}
