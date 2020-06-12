package br.com.devdojo.maratonajsf.bean.comunicacao;

import br.com.devdojo.maratonajsf.model.Estudante;
import br.com.devdojo.maratonajsf.util.ApplicationMapUtil;


import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ComunicacaoTeste10Bean implements Serializable {
    private List<Estudante> estudantes = Estudante.obterListaDeEstudantes();

    public String inserirNaSessao(Estudante estudante) {
        ApplicationMapUtil.setValueInApplicationMap("estudante", estudante);
        return "comunicacao11?faces-redirect=true";
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }
}
