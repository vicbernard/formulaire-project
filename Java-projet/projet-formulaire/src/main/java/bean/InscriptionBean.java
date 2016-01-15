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
import java.util.Date;

/**
 * Created by victor on 18/12/2015.
 */
@RequestScoped
@ManagedBean
public class InscriptionBean implements Serializable {

    @EJB
    private CustomerDAOItf customerDAOItf;

    private Customer customer = new Customer();

    public void inscription(){
        Date utilDate = new Date();
        customer.setDateinscription(new java.sql.Date(utilDate.getTime()));
        customer = customerDAOItf.create(customer);
        if(customer != null){
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            try {
                context.redirect("login.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            FacesContext.getCurrentInstance().addMessage("form:mail", new FacesMessage("Erreur dans les champs"));
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
