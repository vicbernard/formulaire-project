package bean;

import formation.domain.Customer;
import formation.domain.ParamtypeQuestion;
import formation.persistence.paramtypeQuestion.ParamtypeQuestionDAOItf;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by victor on 18/12/2015.
 */
@SessionScoped
@ManagedBean
public class SessionBean implements Serializable {

    @EJB
    private ParamtypeQuestionDAOItf paramtypeQuestionDAOItf;

    private Customer customer = new Customer();

    private List<ParamtypeQuestion> listeTypeQuestion = new ArrayList<>();


    @PostConstruct
    public void loadTypeQuestions(){
        setListeTypeQuestion(paramtypeQuestionDAOItf.findAll());
        HashMap<String,ParamtypeQuestion> mapTypeQuestion=new HashMap<String,ParamtypeQuestion>();
        for(ParamtypeQuestion p:getListeTypeQuestion()){
            mapTypeQuestion.put(p.getLibelle(),p);
            //System.out.println(p.getLibelle());
        }
        StaticList.setList(mapTypeQuestion);
    }

    public void deconnect(){
        this.customer = null;
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        try {
            context.redirect("login.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ParamtypeQuestion> getListeTypeQuestion() {
        return listeTypeQuestion;
    }
    public void setListeTypeQuestion(List<ParamtypeQuestion> listeTypeQuestion) {
        this.listeTypeQuestion = listeTypeQuestion;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
