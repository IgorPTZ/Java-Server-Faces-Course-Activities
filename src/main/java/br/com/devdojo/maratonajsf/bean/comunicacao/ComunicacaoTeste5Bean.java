package br.com.devdojo.maratonajsf.bean.comunicacao;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ComunicacaoTeste5Bean implements Serializable {
    private String nome;
    private String sobrenome;

    public void executar(ActionEvent evento) {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        System.out.println(nome);
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        System.out.println(sobrenome);
        this.sobrenome = sobrenome;
    }
}
