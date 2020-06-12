package br.com.devdojo.maratonajsf.bean.comunicacao;

import br.com.devdojo.maratonajsf.model.Estudante;
import br.com.devdojo.maratonajsf.util.ApplicationMapUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class ComunicacaoTeste11Bean implements Serializable {
    private Estudante estudante;
    private Estudante segundoEstudante = new Estudante();

    public void init() {
        estudante = (Estudante) ApplicationMapUtil.getValueFromApplicationMap("estudante");
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Estudante getSegundoEstudante() {
        return segundoEstudante;
    }

    public void setSegundoEstudante(Estudante segundoEstudante) {
        this.segundoEstudante = segundoEstudante;
    }
}
