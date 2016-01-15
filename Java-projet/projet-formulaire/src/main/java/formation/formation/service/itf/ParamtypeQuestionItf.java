package formation.formation.service.itf;

import formation.domain.ParamtypeQuestion;

import java.util.List;

/**
 * Created by victor on 12/12/2015.
 */
public interface ParamtypeQuestionItf {

    /**
     * Return list of #{ParamtypeQuestion}
     * @return  List<ParamtypeQuestion>
     */
    public List<ParamtypeQuestion> getAll();
}
