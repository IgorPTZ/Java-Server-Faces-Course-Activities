package br.com.devdojo.maratonajsf.bean.comunicacao;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ComunicacaoTeste1Bean implements Serializable {
    private String nome;
    private String sobrenome;

    public String salvar() {
        System.out.println(this.nome);
        System.out.println(this.sobrenome);

        return "comunicacao2";
    }

    public void imprimirAtributos() {
        String initParameter = FacesContext.getCurrentInstance().
                getExternalContext().
                getInitParameter("images.location");

        System.out.println(initParameter);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
