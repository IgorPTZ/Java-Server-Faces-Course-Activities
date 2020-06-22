package br.com.devdojo.maratonajsf.bean.html5;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Named
@ViewScoped
public class Html5TesteBean implements Serializable {

    private int numero;
    private String email;
    private String url;
    private Map<String, String> atributos = new HashMap<>();

    public void init() {
        atributos.put("type", "email");
        atributos.put("placeholder", "Insert your email");
    }

    public void salvar() {
        System.out.println(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getAtributos() {
        return atributos;
    }

    public void setAtributos(Map<String, String> atributos) {
        this.atributos = atributos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
