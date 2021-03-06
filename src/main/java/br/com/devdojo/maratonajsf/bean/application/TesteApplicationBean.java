package br.com.devdojo.maratonajsf.bean.application;

import br.com.devdojo.maratonajsf.bean.dependent.TesteDependentBean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

@Named
@ApplicationScoped
public class TesteApplicationBean implements Serializable {
    private List<String> categoriaList;

    private final TesteDependentBean dependentBean;

    @Inject
    public TesteApplicationBean(TesteDependentBean dependentBean) {
        this.dependentBean = dependentBean;
    }

    @PostConstruct
    public void init() {
        System.out.println("Post Construct executado");
        categoriaList = asList("RPG", "Shooter", "Sport");
    }

    public void mudarLista() {
        categoriaList = asList("RPG", "Shooter", "Sport", "Terror");
    }

    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }
}
