package bean;

import bean.tmpObject.QuestionnaireDTO;
import formation.domain.Question;
import formation.domain.Reponse;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by victor on 18/12/2015.
 */
@ViewScoped
@ManagedBean
public class FormulaireGenereBean implements Serializable {

    private QuestionnaireDTO questionnaireDTO;

    private List<Reponse> listReponses =new ArrayList<>();

    public void initialize(QuestionnaireDTO questi){
        this.questionnaireDTO = questi;
        if(questionnaireDTO.getQuestionList() != null && !questionnaireDTO.getQuestionList().isEmpty()){
            List<Question> questions = questionnaireDTO.getQuestionList();
            for(Question quest : questions){
                Reponse rep = new Reponse();
                rep.setQuestionByIdQuestion(quest);
                getListReponses().add(rep);
            }
        }




    }

    public QuestionnaireDTO getQuestionnaireDTO() {
        return questionnaireDTO;
    }

    public void setQuestionnaireDTO(QuestionnaireDTO questionnaireDTO) {
        this.questionnaireDTO = questionnaireDTO;
    }

    public List<Reponse> getListReponses() {
        return listReponses;
    }

    public void setListReponses(List<Reponse> listReponses) {
        this.listReponses = listReponses;
    }
}
