package formation.formation.service.service;

import formation.domain.Question;
import formation.formation.service.itf.QuestionItf;
import formation.persistence.question.QuestionDAOItf;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by victor on 12/12/2015.
 */

@Remote
@Stateless
public class QuestionService  implements QuestionItf{

    @EJB
    QuestionDAOItf dao;


    @Override
    public Question create(Question question) {
        return dao.create(question);
    }

    @Override
    public Question get(int id) {
        return dao.find(id);
    }
}
