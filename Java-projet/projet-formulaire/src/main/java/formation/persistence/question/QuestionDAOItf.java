package formation.persistence.question;

import formation.domain.Question;

import java.util.List;

/**
 * Created by victor on 14/12/2015.
 */
public interface QuestionDAOItf {

    public List<Question> findAll();

    public Question create(Question question);

    public Question find(Long id);

    public List<Question> findByQuestionnaireId(int id);
}
