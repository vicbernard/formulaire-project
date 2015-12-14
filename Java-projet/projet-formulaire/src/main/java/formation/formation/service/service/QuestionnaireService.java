package formation.formation.service.service;

import formation.domain.Questionnaire;
import formation.formation.service.itf.QuestionnaireItf;
import formation.persistence.questionnaire.QuestionnaireDAOItf;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by victor on 12/12/2015.
 */

@Remote
@Stateless
public class QuestionnaireService implements QuestionnaireItf{

    @EJB
    QuestionnaireDAOItf dao;

    @Override
    public Questionnaire get(Long id) {
        return dao.find(id);
    }

    @Override
    public Questionnaire create(Questionnaire questionnaire) {
        return dao.create(questionnaire);
    }
}
