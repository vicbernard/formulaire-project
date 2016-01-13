package formation.formation.service.service;

import formation.domain.FormulaireReponses;
import formation.formation.service.itf.FormulaireReponsesItf;
import formation.persistence.formulaireReponses.FormulaireReponsesDAOItf;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by victor on 12/12/2015.
 */

@Remote
@Stateless
public class FormulaireReponsesService implements FormulaireReponsesItf {

    @EJB
    FormulaireReponsesDAOItf dao;

    @Override
    public FormulaireReponses create(FormulaireReponses formrep) {
        return dao.create(formrep);
    }

    @Override
    public FormulaireReponses get(Long id) {
        return dao.find(id);
    }
}
