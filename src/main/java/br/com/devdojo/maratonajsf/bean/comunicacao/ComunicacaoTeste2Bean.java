package br.com.devdojo.maratonajsf.bean.comunicacao;

import org.omnifaces.cdi.Param;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@Named
@ViewScoped
public class ComunicacaoTeste2Bean implements Serializable {

    @Inject @Param(name = "nome")
    private String nome;

    @Inject @Param(name = "sobrenome")
    private String sobrenome;

    @PostConstruct
    public void init() {
        /*Map<String, String> parametros = FacesContext.
                                        getCurrentInstance().
                                        getExternalContext().
                                        getRequestParameterMap();

        this.nome = parametros.get("nome");
        this.sobrenome = parametros.get("sobrenome"); */

        System.out.println(this.nome);
        System.out.println(this.sobrenome);
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
