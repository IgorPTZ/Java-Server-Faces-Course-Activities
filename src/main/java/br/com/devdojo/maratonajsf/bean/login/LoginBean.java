package br.com.devdojo.maratonajsf.bean.login;

import br.com.devdojo.maratonajsf.model.Estudante;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    private String nome;
    private String senha;
    private Estudante estudante;

    public String logar() {
        if(this.getNome().equals("igor.pereira") && this.getSenha().equals("teste321")) {
             this.setEstudante(new Estudante());
             return "/restricted/iniciosistema.xhtml?faces-redirect=true";
        }

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Usuario e/ou senha invalidos", ""));

        return null;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.setEstudante(null);
        return "/login?faces-redirect=true";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
