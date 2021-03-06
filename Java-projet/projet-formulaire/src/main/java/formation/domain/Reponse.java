package formation.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by victor on 10/12/2015.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Reponse.findAll", query = "select c from Reponse c"),
        @NamedQuery(name = "Reponse.findByQuestion", query = "select c from Reponse c where c.questionByIdQuestion.idQuestion = :id and c.questionByIdQuestion.paramtypequestionByIdType.libelle = 'Oui/Non'")
})
public class Reponse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReponse;
    private String reponse;
    private Question questionByIdQuestion;
    private FormulaireReponses formulairereponsesByIdFormulaire;

    @Column(name = "IdReponse")
    public int getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(int idReponse) {
        this.idReponse = idReponse;
    }

    @Basic
    @Column(name = "Reponse")
    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reponse reponse1 = (Reponse) o;

        if (idReponse != reponse1.idReponse) return false;
        if (reponse != null ? !reponse.equals(reponse1.reponse) : reponse1.reponse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReponse;
        result = 31 * result + (reponse != null ? reponse.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdQuestion", referencedColumnName = "IdQuestion", nullable = false)
    public Question getQuestionByIdQuestion() {
        return questionByIdQuestion;
    }

    public void setQuestionByIdQuestion(Question questionByIdQuestion) {
        this.questionByIdQuestion = questionByIdQuestion;
    }

    @ManyToOne
    @JoinColumn(name = "IdFormulaire", referencedColumnName = "idFormulaire", nullable = false)
    public FormulaireReponses getFormulairereponsesByIdFormulaire() {
        return formulairereponsesByIdFormulaire;
    }

    public void setFormulairereponsesByIdFormulaire(FormulaireReponses formulairereponsesByIdFormulaire) {
        this.formulairereponsesByIdFormulaire = formulairereponsesByIdFormulaire;
    }
}
