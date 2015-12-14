package formation.persistence.formulaireReponses;

import formation.domain.FormulaireReponses;

import java.util.List;

/**
 * Created by victor on 14/12/2015.
 */
public interface FormulaireReponsesDAOItf {

    /**
     * Return all FormulaireReponses in the database
     *
     * @return a set of FormulaireReponses
     */
    public List<FormulaireReponses> findAll();

    /**
     * allow to create FormulaireReponses (without id)
     *
     * @param user The FormulaireReponses to create.
     * @return the new FormulaireReponses.
     */
    public FormulaireReponses create(FormulaireReponses user);

    /**
     * Find a FormulaireReponses with the given identifier
     *
     * @param id The id of the FormulaireReponses
     * @return The found FormulaireReponses or null if not found
     */
    public FormulaireReponses find(Long id);
}
