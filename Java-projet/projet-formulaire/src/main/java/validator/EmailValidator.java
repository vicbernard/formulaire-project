package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by victor on 18/12/2015.
 */
@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

    static String emailRegex = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
    static Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
    static Matcher matcher;

    public EmailValidator() {
        log("EmailValidator Constructor");
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        matcher = pattern.matcher(value.toString());

        if (!matcher.matches()) {

            FacesMessage msg =
                    new FacesMessage("Erreur validation du mail",
                            "Entrer un mail de la forme: abcd@abc.com");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);

            throw new ValidatorException(msg);
        }
    }

    private void log(String msg) {
        System.out.println(msg);

    }
}

