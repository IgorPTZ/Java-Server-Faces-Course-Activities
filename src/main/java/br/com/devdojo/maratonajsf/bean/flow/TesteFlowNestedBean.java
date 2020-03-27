package br.com.devdojo.maratonajsf.bean.flow;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@FlowScoped(value = "pendencies")
public class TesteFlowNestedBean implements Serializable {
    private String nomeUsuario;
    private String sobrenomeUsuario;

    public String validarUsuario() {
        System.out.println("Validating...");

        if(true) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "First Name e Last Name are required", "Insert required informations"));

            return null;
        }

        return "proceedToRegistration3";
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSobrenomeUsuario() {
        return sobrenomeUsuario;
    }

    public void setSobrenomeUsuario(String sobrenomeUsuario) {
        this.sobrenomeUsuario = sobrenomeUsuario;
    }
}
