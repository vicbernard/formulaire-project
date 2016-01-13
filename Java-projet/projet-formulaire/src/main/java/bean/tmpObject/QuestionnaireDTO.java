package bean.tmpObject;

import formation.domain.Question;
import formation.domain.Questionnaire;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 13/01/2016.
 */
public class QuestionnaireDTO implements Serializable {

    private Questionnaire questionnaire;
    private List<Question> questionList = new ArrayList<>();

    private int nbQuestions;

    public QuestionnaireDTO(Questionnaire q, int nb, List<Question> listQ){
        this.questionnaire = q;
        this.nbQuestions = nb;
        this.setQuestionList(listQ);
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public int getNbQuestions() {
        return nbQuestions;
    }

    public void setNbQuestions(int nbQuestions) {
        this.nbQuestions = nbQuestions;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
