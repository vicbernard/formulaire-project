package formation.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by victor on 10/12/2015.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Question.findAll", query = "select c from Question c")
})
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idQuestion;
    private String libelle;
    private Questionnaire questionnaireByIdQuestionnaire;
    private ParamtypeQuestion paramtypequestionByIdType;

    @Column(name = "IdQuestion")
    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
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

        Question question = (Question) o;

        if (idQuestion != question.idQuestion) return false;
        if (libelle != null ? !libelle.equals(question.libelle) : question.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQuestion;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdQuestionnaire", referencedColumnName = "IdQuestionnaire", nullable = false)
    public Questionnaire getQuestionnaireByIdQuestionnaire() {
        return questionnaireByIdQuestionnaire;
    }

    public void setQuestionnaireByIdQuestionnaire(Questionnaire questionnaireByIdQuestionnaire) {
        this.questionnaireByIdQuestionnaire = questionnaireByIdQuestionnaire;
    }

    @ManyToOne
    @JoinColumn(name = "IdType", referencedColumnName = "IdType", nullable = false)
    public ParamtypeQuestion getParamtypequestionByIdType() {
        return paramtypequestionByIdType;
    }

    public void setParamtypequestionByIdType(ParamtypeQuestion paramtypequestionByIdType) {
        this.paramtypequestionByIdType = paramtypequestionByIdType;
    }
}
