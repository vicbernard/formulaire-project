package formation.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by victor on 10/12/2015.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "FormulaireReponses.findAll", query = "select c from FormulaireReponses c")
})
public class FormulaireReponses implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFormulaire;
    private Customer customerByIdUser;

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

        FormulaireReponses that = (FormulaireReponses) o;

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
