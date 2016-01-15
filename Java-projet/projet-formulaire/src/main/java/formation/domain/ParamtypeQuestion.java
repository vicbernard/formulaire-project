package formation.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by victor on 10/12/2015.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "ParamtypeQuestion.findAll", query = "select c from ParamtypeQuestion c")
})
public class ParamtypeQuestion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idType;
    private String libelle;

    @Column(name = "IdType")
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "Libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParamtypeQuestion that = (ParamtypeQuestion) o;

        if (idType != that.idType) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idType;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        return result;
    }
}
