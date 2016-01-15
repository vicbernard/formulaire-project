package formation.classTmp;


import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by victor on 10/12/2015.
 */
@XmlRootElement
public class ReponseMoyenne implements Serializable {


    private String libelleQuestion;
    private int nbOui;
    private int nbNon;

    public String getLibelleQuestion() {
        return libelleQuestion;
    }

    public void setLibelleQuestion(String libelleQuestion) {
        this.libelleQuestion = libelleQuestion;
    }

    public int getNbOui() {
        return nbOui;
    }

    public void setNbOui(int nbOui) {
        this.nbOui = nbOui;
    }

    public int getNbNon() {
        return nbNon;
    }

    public void setNbNon(int nbNon) {
        this.nbNon = nbNon;
    }
}
