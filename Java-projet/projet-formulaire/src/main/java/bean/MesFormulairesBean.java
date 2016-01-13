package bean;

import bean.tmpObject.QuestionnaireDTO;
import formation.domain.Question;
import formation.domain.Questionnaire;
import formation.persistence.question.QuestionDAOItf;
import formation.persistence.questionnaire.QuestionnaireDAOItf;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by victor on 18/12/2015.
 */
@ViewScoped
@ManagedBean
public class MesFormulairesBean implements Serializable {

    private List<QuestionnaireDTO> listeQuestionnaires = new ArrayList<>();

    @EJB
    private QuestionnaireDAOItf questionnaireDAOItf;

    @EJB
    private QuestionDAOItf questionDAOItf;

    public void initialize(int idUser){
        List<Questionnaire> mesQuestionnaires =  questionnaireDAOItf.ListQuestionnaireFindByUser(idUser);
        List<Question> mesQuestions = new ArrayList<>();
        if(mesQuestionnaires != null && !mesQuestionnaires.isEmpty()){
            for(Questionnaire q : mesQuestionnaires){
                mesQuestions =questionDAOItf.findByQuestionnaireId(q.getIdQuestionnaire());
                if(mesQuestions != null && !mesQuestions.isEmpty()){
                    getListeQuestionnaires().add(new QuestionnaireDTO(q, mesQuestions.size(), mesQuestions));
                }else{
                    getListeQuestionnaires().add(new QuestionnaireDTO(q, 0, null));
                }
            }
        }

    }

    public void loadForm(QuestionnaireDTO dto){
        FormulaireGenereBean formulaireGenereBean = new FormulaireGenereBean();
        formulaireGenereBean.initialize(dto);
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        try {
            context.redirect("form.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<QuestionnaireDTO> getListeQuestionnaires() {
        return listeQuestionnaires;
    }

    public void setListeQuestionnaires(List<QuestionnaireDTO> listeQuestionnaires) {
        this.listeQuestionnaires = listeQuestionnaires;
    }
}
