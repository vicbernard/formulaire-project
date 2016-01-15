package formation.formation.service.itf;

import formation.domain.Question;

/**
 * Created by victor on 12/12/2015.
 */
public interface QuestionItf {

    /**
     * Create a new #{Formulairereponses}
     * @param question
     * @return #{Formulairereponses} created
     */
    public Question create(Question question);

    /**
     * Return the #{Question} with the given identifier
     * @param id the identifier of the #{Question}
     * @return  The found #{Question} or null if not found.
     */
    public Question get(int id);
}
