package formation.formation.service.service;

import formation.domain.Reponse;
import formation.formation.service.itf.ReponseItf;
import formation.persistence.reponse.ReponseDAOItf;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by victor on 12/12/2015.
 */
@Remote
@Stateless
public class ReponseService implements ReponseItf{

    @EJB
    ReponseDAOItf dao;

    @Override
    public Reponse create(Reponse reponse) {
        return dao.create(reponse);
    }

    @Override
    public Reponse get(Long id) {
        return dao.find(id);
    }
}
