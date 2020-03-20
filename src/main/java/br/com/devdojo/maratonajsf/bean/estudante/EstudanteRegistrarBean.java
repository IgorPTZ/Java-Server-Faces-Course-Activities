package br.com.devdojo.maratonajsf.bean.estudante;

import br.com.devdojo.maratonajsf.model.Estudante;

import javax.el.LambdaExpression;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

import static java.util.Arrays.asList;

// Em JSF os controller sao conhecidos como Beans

@Named
@ViewScoped
public class EstudanteRegistrarBean implements Serializable {
    private Estudante estudante = new Estudante();
    private String[] nomesArray = {"DevDojo", "eh", "legal"};
    private List<String> nomesList = asList("DevDojo", "eh", "bom");
    private Set<String> nomesSet = new HashSet<>(asList("DevDojo", "eh", "otimo"));
    private Map<String, String> nomesMap = new HashMap<>();
    private boolean exibirNotas;
    private boolean exibirLink;

    {
        nomesMap.put("a", "DevDojo");
        nomesMap.put("b", "eh");
        nomesMap.put("c", "excelente");
    }

    public void executar() {
        System.out.println("Executing searching on database...");
    }

    public void executar(String param) {
        System.out.println("Searching student with id = " + param);
    }

    public String retornarIndex() {
        return "index2?faces-redirect=true";
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public String[] getNomesArray() {
        return nomesArray;
    }

    public void setNomesArray(String[] nomesArray) {
        this.nomesArray = nomesArray;
    }

    public List<String> getNomesList() {
        return nomesList;
    }

    public void setNomesList(List<String> nomesList) {
        this.nomesList = nomesList;
    }

    public Set<String> getNomesSet() {
        return nomesSet;
    }

    public void setNomesSet(Set<String> nomesSet) {
        this.nomesSet = nomesSet;
    }

    public Map<String, String> getNomesMap() {
        return nomesMap;
    }

    public void setNomesMap(Map<String, String> nomesMap) {
        this.nomesMap = nomesMap;
    }

    public boolean isExibirNotas() {
        return exibirNotas;
    }

    public void setExibirNotas(boolean exibirNotas) {
        this.exibirNotas = exibirNotas;
    }

    public boolean isExibirLink() {
        return exibirLink;
    }

    public void setExibirLink(boolean exibirLink) {
        this.exibirLink = exibirLink;
    }

    public void renderizarNotas() {
        this.exibirNotas = true;
    }

    public void esconderNotas() {
        this.exibirNotas = false;
    }

    public void renderizarLink() {
        this.exibirLink = true;
    }

    public void esconderLink() {
        this.exibirLink = false;
    }

    public void calcularCubo(LambdaExpression expression, long value) {
        long result = (long) expression.invoke(FacesContext.getCurrentInstance().getELContext(), value);
        System.out.println(result);
    }
}
