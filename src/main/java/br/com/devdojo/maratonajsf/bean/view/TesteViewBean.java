package br.com.devdojo.maratonajsf.bean.view;

import br.com.devdojo.maratonajsf.bean.dependent.TesteDependentBean;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
@ViewScoped
public class TesteViewBean implements Serializable {
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();
    private final TesteDependentBean dependentBean;

    @Inject
    public TesteViewBean(TesteDependentBean dependentBean) {
        this.dependentBean = dependentBean;
    }

    // Executado apos o construtor
    @PostConstruct
    public void init() {
        System.out.println("Post Construct executado");
        personagens = asList("Goku", "Gohan", "Goten", "Vegeta");
    }

    public TesteDependentBean getDependentBean() {
        return dependentBean;
    }

    public void selecionarPersonagem() {
        int index = ThreadLocalRandom.current().nextInt(3);
        String personagem = personagens.get(index);

        personagemSelecionado.add(personagem);
        dependentBean.getPersonagemSelecionado().add(personagem);
    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }
}
