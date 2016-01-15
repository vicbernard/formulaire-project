package formation.formation.service.itf;

import formation.domain.Reponse;

/**
 * Created by victor on 12/12/2015.
 */
public interface ReponseItf {

    public Reponse create(Reponse reponse);

    public Reponse get(Long id);
}

