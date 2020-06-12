package br.com.devdojo.maratonajsf.bean.login;

import br.com.devdojo.maratonajsf.model.Estudante;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import static java.util.Arrays.asList;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    private String nome;
    private String senha;
    private Estudante estudante;
    private String idioma;
    private List<Locale> localeList = asList(new Locale("en"), new Locale("pt"));
    private int quantidadeDeMensagens;

    public String logar() {
        if(this.getNome().equals("i") && this.getSenha().equals("1")) {
             this.setEstudante(new Estudante());
             quantidadeDeMensagens++;
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

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public List<Locale> getLocaleList() {
        return localeList;
    }

    public void setLocaleList(List<Locale> localeList) {
        this.localeList = localeList;
    }

    public int getQuantidadeDeMensagens() {
        return quantidadeDeMensagens;
    }

    public void setQuantidadeDeMensagens(int quantidadeDeMensagens) {
        this.quantidadeDeMensagens = quantidadeDeMensagens;
    }
}
