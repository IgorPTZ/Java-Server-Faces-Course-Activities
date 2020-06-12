package br.com.devdojo.maratonajsf.validators;

import br.com.devdojo.maratonajsf.bean.login.LoginBean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import java.util.List;

import static java.util.Arrays.asList;

@FacesValidator
public class DuplicatedEmailValidator implements Validator {

    private List<String> emailsDB = asList("igor.ptz@hotmail.com", "igor.ptw@hotmail.com");

    @Inject
    private LoginBean loginBean;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o)
            throws ValidatorException {

        System.out.println(loginBean.getIdioma());

        String email = (String) o;

        if(emailsDB.contains(email)) {
            FacesMessage mensagem =
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Esse email ja existe na base de dados",
                            "");

            throw new ValidatorException(mensagem);
        }
    }
}
