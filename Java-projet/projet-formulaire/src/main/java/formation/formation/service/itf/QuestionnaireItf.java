package formation.formation.service.itf;

import formation.domain.Questionnaire;

/**
 * Created by victor on 12/12/2015.
 */
public interface QuestionnaireItf {

    public Questionnaire get (Long id);

    public Questionnaire create(Questionnaire questionnaire);
}
