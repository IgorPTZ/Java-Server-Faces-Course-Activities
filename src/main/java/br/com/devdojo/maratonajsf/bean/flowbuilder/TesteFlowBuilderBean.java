package br.com.devdojo.maratonajsf.bean.flowbuilder;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@FlowScoped(value = "newregistration")
public class TesteFlowBuilderBean implements Serializable {
    private String nome;
    private String sobrenome;
    private String endereco;

    public void salvar() {
        System.out.println("Saving data...");
        //return "exitToBegin";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
