package br.com.devdojo.maratonajsf.bean.comunicacao;

import br.com.devdojo.maratonajsf.model.Estudante;
import org.omnifaces.util.Faces;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class ComunicacaoTeste9Bean implements Serializable {
    private String senha;
    private List<Estudante> estudantes = Estudante.obterListaDeEstudantes();

    public void salvar() {
        System.out.println(senha);
    }

    public void removerEstudante(Estudante estudante) {

        estudantes.remove(estudante);

        System.out.println("Removido com sucesso ->" + estudante);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }
}
