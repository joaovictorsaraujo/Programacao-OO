import java.util.Scanner;

public class Funcionario extends Pessoa {
    protected double salario;

    public Funcionario(String nome, String cpf, int dia, int mes, int ano, double salario) {
        super(nome, cpf, dia, mes, ano);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public String toString() {
        return this.getNome() + " - CPF: " + this.getCpf() + " - Salário: " + this.getSalario();
    }
}
