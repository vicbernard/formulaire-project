package formation.persistence.reponseqcm;

import formation.domain.Reponseqcm;

import java.util.List;

/**
 * Created by victor on 14/12/2015.
 */
public interface ReponseqcmDAOItf {

    public List<Reponseqcm> findAll();

    public Reponseqcm create(Reponseqcm question);

    public Reponseqcm find(Long id);
}
