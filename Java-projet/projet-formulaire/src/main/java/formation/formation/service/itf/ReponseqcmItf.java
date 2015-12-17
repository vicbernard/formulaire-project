package formation.formation.service.itf;

import formation.domain.Reponseqcm;

/**
 * Created by victor on 12/12/2015.
 */
public interface ReponseqcmItf {

    public Reponseqcm create(Reponseqcm reponseqcm);

    public Reponseqcm get (Long id);
}
