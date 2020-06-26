package br.com.devdojo.maratonajsf.validators;

import br.com.devdojo.maratonajsf.bean.login.LoginBean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

@Named
@RequestScoped
public class FileValidator implements Serializable {

    public void validateFile(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException{
        Part file = (Part) o;

        try {
            validateFileNameLength(file);
            validateFileSize(file);
            validateContentType(file);
        }
        catch(RuntimeException e) {
            FacesMessage mensagem =
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            e.getMessage(),
                            "");

            throw new ValidatorException(mensagem);
        }
    }

    private void validateFileNameLength(Part file) {
        if(file.getSubmittedFileName().length() > 10) {
            throw new RuntimeException("O nome + extensão nã pode ser maior que dez caracteres");
        }
    }

    private void validateContentType(Part file) {
        String contentType = file.getContentType();

        if(!contentType.equals("image/png") && !contentType.equals("image/jpge")) {
            throw new RuntimeException("Apenas imagens com extensão PNG E JPGE são permitidas");
        }
    }

    private void validateFileSize(Part file) {
        if(file.getSize() > 1048576) {
            throw new RuntimeException("O tamanho do arquivo não pode exceder 1MB");
        }
    }
}
