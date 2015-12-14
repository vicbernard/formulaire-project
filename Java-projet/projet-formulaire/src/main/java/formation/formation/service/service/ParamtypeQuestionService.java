package formation.formation.service.service;

import formation.domain.ParamtypeQuestion;
import formation.formation.service.itf.ParamtypeQuestionItf;
import formation.persistence.paramtypeQuestion.ParamtypeQuestionDAOItf;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by victor on 12/12/2015.
 */

@Remote
@Stateless
public class ParamtypeQuestionService implements ParamtypeQuestionItf {

    @EJB
    ParamtypeQuestionDAOItf dao;

    @Override
    public List<ParamtypeQuestion> getAll() {
        return dao.findAll();
    }
}
