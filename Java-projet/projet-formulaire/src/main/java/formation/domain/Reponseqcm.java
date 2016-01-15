package formation.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by victor on 10/12/2015.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Reponseqcm.findAll", query = "select c from Reponseqcm c")
})
public class Reponseqcm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReponseQcm;
    private String libelle;
    private Question questionByIdQuestion;

    @Column(name = "idReponseQCM")
    public int getIdReponseQcm() {
        return idReponseQcm;
    }

    public void setIdReponseQcm(int idReponseQcm) {
        this.idReponseQcm = idReponseQcm;
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

        Reponseqcm that = (Reponseqcm) o;

        if (idReponseQcm != that.idReponseQcm) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReponseQcm;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
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
}
