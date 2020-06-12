package br.com.devdojo.maratonajsf.bean.comunicacao;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ComunicacaoTeste4Bean implements Serializable {

    private String nomeDoButao = "Nome do botão";

    public void executar(ActionEvent evento) {
        String nome      = (String) evento.getComponent().getAttributes().get("nome");
        String sobrenome = (String) evento.getComponent().getAttributes().get("sobrenome");

        System.out.println(nome);
        System.out.println(sobrenome);
    }

    public String getNomeDoButao() {
        return nomeDoButao;
    }

    public void setNomeDoButao(String nomeDoButao) {
        this.nomeDoButao = nomeDoButao;
    }
}
