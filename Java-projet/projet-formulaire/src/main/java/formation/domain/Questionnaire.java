package formation.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by victor on 10/12/2015.
 */
@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Questionnaire.findAll", query = "select c from Questionnaire c"),
        @NamedQuery(name = "Questionnaire.findByUser", query = "select c from Questionnaire c where c.customerByIdUser.id = :idUser")
})
public class Questionnaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idQuestionnaire;
    private String libelle;
    private Boolean prive;
    private Customer customerByIdUser;

    @Column(name = "IdQuestionnaire")
    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    @Basic
    @Column(name = "Libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "Prive")
    public Boolean getPrive() {
        return prive;
    }

    public void setPrive(Boolean prive) {
        this.prive = prive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Questionnaire that = (Questionnaire) o;

        if (idQuestionnaire != that.idQuestionnaire) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;
        if (prive != null ? !prive.equals(that.prive) : that.prive != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQuestionnaire;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (prive != null ? prive.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdUser", referencedColumnName = "id", nullable = false)
    public Customer getCustomerByIdUser() {
        return customerByIdUser;
    }

    public void setCustomerByIdUser(Customer customerByIdUser) {
        this.customerByIdUser = customerByIdUser;
    }
}
