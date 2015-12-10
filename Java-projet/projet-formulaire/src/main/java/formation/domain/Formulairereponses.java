package formation.domain;

import javax.persistence.*;

/**
 * Created by victor on 10/12/2015.
 */
@Entity
public class Formulairereponses {
    private int idFormulaire;
    private Customer customerByIdUser;

    @Id
    @Column(name = "idFormulaire")
    public int getIdFormulaire() {
        return idFormulaire;
    }

    public void setIdFormulaire(int idFormulaire) {
        this.idFormulaire = idFormulaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Formulairereponses that = (Formulairereponses) o;

        if (idFormulaire != that.idFormulaire) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idFormulaire;
    }

    @ManyToOne
    @JoinColumn(name = "IdUser", referencedColumnName = "id")
    public Customer getCustomerByIdUser() {
        return customerByIdUser;
    }

    public void setCustomerByIdUser(Customer customerByIdUser) {
        this.customerByIdUser = customerByIdUser;
    }
}
