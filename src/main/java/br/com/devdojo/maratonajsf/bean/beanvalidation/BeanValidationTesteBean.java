package br.com.devdojo.maratonajsf.bean.beanvalidation;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.*;
import java.io.Serializable;

@Named
@ViewScoped
public class BeanValidationTesteBean implements Serializable {

    @Size(max = 10, message = "O nome deve ter entre 3 e 10 caracteres")
    @NotNull(message= "O nome é um campo obrigatório")
    private String nome;

    @Pattern(regexp ="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message="O email inserido não é válido")
    private String email;

    @DecimalMax(value = "50.00", message = "O valor decimal não pode ser superior a 50.00")
    @DecimalMin(value = "5.00", message = "O valor decimal não pode ser inferior a 5.00")
    private double decimal;

    @Digits(integer = 3, fraction = 2, message = "O valor pode apenas ter 3 numeros antes da virgula e 2 numeros apos a virgula")
    private double numero;

    public void salvar() {
        System.out.println(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }
}
