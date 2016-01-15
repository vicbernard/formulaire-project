package bean;

import formation.domain.Customer;
import formation.persistence.customer.CustomerDAOItf;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by victor on 18/12/2015.
 */
@RequestScoped
@ManagedBean
public class ConnectionBean implements Serializable {

    @EJB
    private CustomerDAOItf customerDAOItf;

    @ManagedProperty(value="#{sessionBean}")
    private SessionBean sessionBean;


    private Customer customer = new Customer();

    public void connection(){
        customer = customerDAOItf.connection(getCustomer().getMail(), getCustomer().getPwd());
        if(customer != null){
            getSessionBean().setCustomer(customer);
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            try {
                context.redirect("index.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            FacesContext.getCurrentInstance().addMessage("form:mail", new FacesMessage("Erreur dans l'adresse et/ou le mot de passe"));
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
