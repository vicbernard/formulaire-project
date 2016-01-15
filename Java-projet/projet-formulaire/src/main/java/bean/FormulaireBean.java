package bean;

import formation.domain.Question;
import formation.domain.Questionnaire;
import formation.persistence.question.QuestionDAOItf;
import formation.persistence.questionnaire.QuestionnaireDAOItf;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by victor on 18/12/2015.
 */
@ViewScoped
@ManagedBean
public class FormulaireBean implements Serializable {

    private int nombreQuestions = 1;

    private Questionnaire questionnaire = new Questionnaire();

    private List<Question> listeQuestions = new ArrayList<>();

    private Boolean popUp = false;

    @EJB
    private QuestionnaireDAOItf questionnaireDAOItf;

    @EJB
    private QuestionDAOItf questionDAOItf;

    @ManagedProperty(value="#{sessionBean}")
    private SessionBean sessionBean;

    @PostConstruct
    public void init(){
        if(nombreQuestions == 1){
            Question quest1 = new Question();
            listeQuestions.add(quest1);
        }
    }

    public void listener() {
        listeQuestions = new ArrayList<>();
        for(int i=0;i<nombreQuestions;i++){
            Question question = new Question();
            listeQuestions.add(question);
        }
    }

    public void validerFormulaire(){
        Boolean verif = true;
        if(StringUtils.isBlank(questionnaire.getLibelle())){
            FacesContext.getCurrentInstance().addMessage(":nomForm", new FacesMessage("Veuillez entrer un nom pour le formulaire"));
            verif = false;
            return;
        }
        int idx = 0;
        for(Question q : listeQuestions){
            if(StringUtils.isBlank(q.getLibelle())){
                FacesContext.getCurrentInstance().addMessage(":questions:"+idx+":nomQuestion", new FacesMessage("Veuillez entrer un nom pour la question"));
                verif = false;
                return;
            }
            idx++;
        }
        if(verif == true) {
            questionnaire.setCustomerByIdUser(sessionBean.getCustomer());
            questionnaire = questionnaireDAOItf.create(questionnaire);

            for (Question q : listeQuestions) {
                q.setQuestionnaireByIdQuestionnaire(questionnaire);
                questionDAOItf.create(q);
            }
            popUp = true;
        }
    }

    public List<Question> getListeQuestions() {
        return listeQuestions;
    }

    public void setListeQuestions(List<Question> listeQuestions) {
        this.listeQuestions = listeQuestions;
    }

    public int getNombreQuestions() {
        return nombreQuestions;
    }

    public void setNombreQuestions(int nombreQuestions) {
        this.nombreQuestions = nombreQuestions;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Boolean getPopUp() {
        return popUp;
    }

    public void setPopUp(Boolean popUp) {
        this.popUp = popUp;
    }
}
