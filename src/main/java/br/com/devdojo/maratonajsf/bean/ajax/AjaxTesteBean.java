package br.com.devdojo.maratonajsf.bean.ajax;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.asList;

@Named
@ViewScoped
public class AjaxTesteBean implements Serializable {

    private String nome;
    private String sobrenome;
    private String email;
    private Map<String, List<String>> listaDeCidades;
    private List<String> cidades;
    private String paisSelecionado;
    private String cidadeSelecionada;

    public void init() {

        if(!FacesContext.getCurrentInstance().isPostback()) {
            System.out.println("Map inicializado...");
            listaDeCidades = new TreeMap<>();
            listaDeCidades.put("BRASIL", asList("Salvador", "Rio de Janeiro", "São Paulo"));
            listaDeCidades.put("EUA", asList("New York", "Seattle", "Chicago"));
            listaDeCidades.put("ALEMANHA", asList("Berlim", "Hamburgo", "Colonia"));
        }
    }

    public void toUpperCase() {
        this.nome = this.nome.toUpperCase();
        this.sobrenome = this.sobrenome.toUpperCase();
    }

    public void toUpperCaseNome() {
        this.nome = this.nome.toUpperCase();
    }

    public void selecionarPais() {
        if(paisSelecionado == null) {
            cidades = null;
            return;
        }
        cidades = listaDeCidades.get(paisSelecionado);
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

    public Map<String, List<String>> getListaDeCidades() {
        return listaDeCidades;
    }

    public void setListaDeCidades(Map<String, List<String>> listaDeCidades) {
        this.listaDeCidades = listaDeCidades;
    }

    public List<String> getCidades() {
        return cidades;
    }

    public void setCidades(List<String> cidades) {
        this.cidades = cidades;
    }

    public String getPaisSelecionado() {
        return paisSelecionado;
    }

    public void setPaisSelecionado(String paisSelecionado) {
        this.paisSelecionado = paisSelecionado;
    }

    public String getCidadeSelecionada() {
        return cidadeSelecionada;
    }

    public void setCidadeSelecionada(String cidadeSelecionada) {
        this.cidadeSelecionada = cidadeSelecionada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
