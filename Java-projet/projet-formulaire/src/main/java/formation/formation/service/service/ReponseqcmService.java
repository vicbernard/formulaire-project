package formation.formation.service.service;

import formation.domain.Reponseqcm;
import formation.formation.service.itf.ReponseqcmItf;
import formation.persistence.reponseqcm.ReponseqcmDAOItf;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by victor on 12/12/2015.
 */
@Remote
@Stateless
public class ReponseqcmService implements ReponseqcmItf {

    @EJB
    ReponseqcmDAOItf dao;

    @Override
    public Reponseqcm create(Reponseqcm reponseqcm) {
        return dao.create(reponseqcm);
    }

    @Override
    public Reponseqcm get(Long id) {
        return dao.find(id);
    }
}
