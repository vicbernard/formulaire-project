package formation.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**Classe représentant les utilisateurs**/

@Entity
@NamedQueries({
        @NamedQuery(name = "findAll", query = "select c from Customer c")
})
public class CustomerOld implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Email obligatoire")
    private String mail;

    @NotNull(message = "Mot de passe obligatoire")
    private String pwd;

    @NotNull(message = "Nom obligatoire")
    private String name;

    @NotNull(message = "Prénom obligatoire")
    private String fistName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }
}
