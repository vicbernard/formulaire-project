package formation.persistence.questionnaire;

import formation.domain.Questionnaire;

import java.util.List;

/**
 * Created by victor on 14/12/2015.
 */
public interface QuestionnaireDAOItf {

    public List<Questionnaire> findAll();

    public Questionnaire create(Questionnaire question);

    public Questionnaire find(Long id);

    public List<Questionnaire> ListQuestionnaireFindByUser(int idUser);
}
