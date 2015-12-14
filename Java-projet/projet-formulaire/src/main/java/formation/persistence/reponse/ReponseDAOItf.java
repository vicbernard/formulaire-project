package formation.persistence.reponse;

import formation.domain.Reponse;

import java.util.List;

/**
 * Created by victor on 14/12/2015.
 */
public interface ReponseDAOItf {

    public List<Reponse> findAll();

    public Reponse create(Reponse question);

    public Reponse find(Long id);
}
