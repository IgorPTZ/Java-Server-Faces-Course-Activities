package br.com.devdojo.maratonajsf.bean.datatable;

import br.com.devdojo.maratonajsf.model.Estudante;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named
@ViewScoped
public class DataTableTesteBean implements Serializable {

    private List<Estudante> estudanteList = Estudante.obterListaDeEstudantes();
    private Set<Estudante> estudanteSet = new HashSet<>(Estudante.obterListaDeEstudantes());
    private List<Estudante> estudanteLinkedList = new LinkedList<>(Estudante.obterListaDeEstudantes());
    private Map<String, Estudante> mapEstudanteList = new HashMap<>();

    public void init() {
        mapEstudanteList.put("Estudante 1", new Estudante(1,"Joao", "Oliveira"));
        mapEstudanteList.put("Estudante 2", new Estudante(2,"Ana", "Silva"));
        mapEstudanteList.put("Estudante 3", new Estudante(3,"Maria", "Pereira"));
    }

    public void ordenarPorNome(String ordem) {
        if(ordem.equals("asc")) {
            estudanteList.sort(Comparator.comparing(Estudante::getNome));
        }
        else {
            estudanteList.sort(Comparator.comparing(Estudante::getNome).reversed());
        }
    }

    public void ordenarPorSobrenome(String ordem) {
        if(ordem.equals("asc")) {
            estudanteList.sort(Comparator.comparing(Estudante::getSobrenome));
        }
        else {
            estudanteList.sort(Comparator.comparing(Estudante::getSobrenome).reversed());
        }
    }

    public void remover(Estudante estudante) {
        estudanteList.remove(estudante);
    }

    public void editar(Estudante estudante) {
        estudante.setEditando(true);
    }

    public void salvar() {
        estudanteList.forEach(estudante -> {
            if(estudante.isEditando()) {
                System.out.println(estudante);
            }

            estudante.setEditando(false);
        });
    }

    public List<Estudante> getEstudanteList() {
        return estudanteList;
    }

    public void setEstudanteList(List<Estudante> estudanteList) {
        this.estudanteList = estudanteList;
    }

    public Set<Estudante> getEstudanteSet() {
        return estudanteSet;
    }

    public void setEstudanteSet(Set<Estudante> estudanteSet) {
        this.estudanteSet = estudanteSet;
    }

    public List<Estudante> getEstudanteLinkedList() {
        return estudanteLinkedList;
    }

    public void setEstudanteLinkedList(List<Estudante> estudanteLinkedList) {
        this.estudanteLinkedList = estudanteLinkedList;
    }

    public Map<String, Estudante> getMapEstudanteList() {
        return mapEstudanteList;
    }

    public void setMapEstudanteList(Map<String, Estudante> mapEstudanteList) {
        this.mapEstudanteList = mapEstudanteList;
    }
}
