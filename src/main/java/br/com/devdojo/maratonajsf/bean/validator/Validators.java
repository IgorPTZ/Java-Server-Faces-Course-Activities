package br.com.devdojo.maratonajsf.bean.validator;

import br.com.devdojo.maratonajsf.bean.login.LoginBean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

@Named
@RequestScoped
public class Validators implements Serializable {

    private List<String> emailsDB = asList("igor.ptz@hotmail.com", "igor.ptw@hotmail.com");

    @Inject
    private LoginBean loginBean;

    public void validateDuplicatedEmail(FacesContext facesContext, UIComponent uiComponent, Object o)
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
