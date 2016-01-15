package formation.formation.service.itf;

import formation.domain.FormulaireReponses;

/**
 * Created by victor on 12/12/2015.
 */
public interface FormulaireReponsesItf {

    /**
     * Create a new #{Formulairereponses}
     *
     * @param formrep
     * @return #{Formulairereponses}
     */
    public FormulaireReponses create(FormulaireReponses formrep);

    /**
     * Return the #{Formulairereponses} with the given identifier
     * @param id the identifier of the #{Formulairereponses}
     * @return  The found #{Formulairereponses} or null if not found.
     */
    public FormulaireReponses get (Long id);
}
