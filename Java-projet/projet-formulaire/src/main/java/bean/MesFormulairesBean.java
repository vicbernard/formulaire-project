package bean;

import bean.tmpObject.QuestionnaireDTO;
import formation.domain.*;
import formation.persistence.customer.CustomerDAOItf;
import formation.persistence.formulaireReponses.FormulaireReponsesDAOItf;
import formation.persistence.question.QuestionDAOItf;
import formation.persistence.questionnaire.QuestionnaireDAOItf;
import formation.persistence.reponse.ReponseDAOItf;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
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

    private QuestionnaireDTO questionnaireDTO;

    private List<Reponse> listReponses =new ArrayList<>();

    private Boolean afficherForm;

    private Customer customer;

    @EJB
    private CustomerDAOItf customerDAOItf;

    @EJB
    private QuestionnaireDAOItf questionnaireDAOItf;

    @EJB
    private QuestionDAOItf questionDAOItf;

    @EJB
    private FormulaireReponsesDAOItf formulaireReponsesDAOItf;

    @EJB
    private ReponseDAOItf reponseDAOItf;

    public void initializeMyForms(int idUser){
        setAfficherForm(false);
        customer = customerDAOItf.find(idUser);
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

    public void initializeForm(QuestionnaireDTO questi, Boolean change){
        if(change) {
            setAfficherForm(true);
        }
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

    public void saveReponse(QuestionnaireDTO questi){
        initializeForm(questi,false);
        System.out.println("SaveReponse ");
        FormulaireReponses formulaireReponses = new FormulaireReponses();
        formulaireReponses.setCustomerByIdUser(customer);
        formulaireReponses = formulaireReponsesDAOItf.create(formulaireReponses);

        for(Reponse r: listReponses){
            r.setFormulairereponsesByIdFormulaire(formulaireReponses);
            if(r.getQuestionByIdQuestion().getParamtypequestionByIdType().getLibelle().equals("Oui/Non")){
                int x=(Math.random()<0.5)?0:1;
                if(x==0){
                    r.setReponse("Oui");
                }else {
                    r.setReponse("Non");
                }
            }else if(r.getQuestionByIdQuestion().getParamtypequestionByIdType().getLibelle().equals("Date")){
                r.setReponse("12/12/1986");
            }else{
                r.setReponse("Texte de test...");
            }
            reponseDAOItf.create(r);
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

    public List<QuestionnaireDTO> getListeQuestionnaires() {
        return listeQuestionnaires;
    }

    public void setListeQuestionnaires(List<QuestionnaireDTO> listeQuestionnaires) {
        this.listeQuestionnaires = listeQuestionnaires;
    }

    public Boolean getAfficherForm() {
        return afficherForm;
    }

    public void setAfficherForm(Boolean afficherForm) {
        this.afficherForm = afficherForm;
    }
}
