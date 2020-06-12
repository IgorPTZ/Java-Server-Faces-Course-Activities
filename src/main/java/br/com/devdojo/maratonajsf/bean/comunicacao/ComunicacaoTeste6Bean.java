package br.com.devdojo.maratonajsf.bean.comunicacao;

import br.com.devdojo.maratonajsf.model.Estudante;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ComunicacaoTeste6Bean implements Serializable {
    private List<Estudante> listaDeEstudantes = Estudante.obterListaDeEstudantes();

    public String editar(int index) {
        Estudante estudante = listaDeEstudantes.get(index);

        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("estudante", estudante);

        return "comunicacao7?faces-redirect=true";
    }

    public List<Estudante> getListaDeEstudantes() {
        return listaDeEstudantes;
    }

    public void setListaDeEstudantes(List<Estudante> listaDeEstudantes) {
        this.listaDeEstudantes = listaDeEstudantes;
    }
}
