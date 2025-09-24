package banco;
import java.util.Scanner;
/**
 *
 * @author 20241bsi0319
 */
public class Conta {
    protected String numero;
    protected Pessoa titular;
    protected Data criacao;
    protected double saldo;
    protected Gerente ger;

    public Conta(String num, Pessoa tit, Gerente ger, Data d){
        this.numero = num;
        this.titular = tit;
        this.criacao = d;
        this.saldo = 0;
        this.ger = ger;
    }

    public Conta(Gerente ger){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe os outros atributos: ");

        System.out.print("Numero da conta: ");
        this.numero = input.nextLine();

        this.titular = new Pessoa();
        this.criacao = new Data();
        this.saldo = 0;
        this.ger = ger;
    }

    protected double disponivel() {
        return this.saldo;
    }

    public void extrato(){
        System.out.println("Conta: " + this.numero);
        System.out.println("Titular: " + this.titular.nome + " (" + this.titular.cpf + ")");
        System.out.println("Valor disponível para saque: " + this.disponivel());
    }

    private boolean movimentacao(double valor){
        if ((this.disponivel()) >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean sacar(double valor) {
        if (this.movimentacao(valor)) {
            System.out.println("Saque de " + valor + " realizado com sucesso!");
            System.out.println("Novo saldo: " + this.saldo);
            return true;
        } else {
            System.out.println("Erro: nao foi possivel sacar " + valor);
            System.out.println("Valor disponivel para saque: " + this.disponivel());
            return false;
        }
    }

    public boolean transf(double valor, Conta dest){
        if(this.movimentacao(valor)){
            dest.depositar(valor);
            System.out.println("Transferencia de " + valor + " realizado com sucesso!");
            System.out.println("Novo saldo: " + this.saldo);
            return true;
        }
        else{
            System.out.println("Erro: transferencia nao realizada");
            System.out.println("Valor disponivel para transferencia: " + this.disponivel());
            return false;
        }
    }

    public void depositar(double valor){
        this.saldo += valor;
        System.out.println("Deposito realizado!");
    }
}
