package banco;

import java.util.Scanner;

/**
 *
 * @author 20241bsi0319
 */
public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente(Pessoa tit, Gerente ger){
        super(tit, ger);
        this.alterarLimite();
    }

    public ContaCorrente(String num, Pessoa tit, Gerente ger, Data d) {
        super(num, tit, ger, d);
        this.limite = 200;
    }

    protected double disponivel() {
        return this.saldo + this.limite;
    }

    public void extrato() {
        System.out.println("*** EXTRATO DA CONTA-CORRENTE: ***");
        super.extrato();
    }

    public void alterarLimite(String s) {
        if(this.ger.validarAcesso(s)) {
            System.out.print("Defina o limite da conta " + this.numero + ": ");
            Scanner limite = new Scanner(System.in);
            this.limite = limite.nextDouble();
            System.out.println("Sucesso! Limite atual: " + this.limite);
        }
        else {
            System.out.println("Senha incorreta, tente novamente!");
        }
    }

    public void alterarLimite() {
        System.out.print("Digite a senha: ");
        Scanner pass = new Scanner(System.in);
        this.alterarLimite(pass.nextLine());
    }

    public void chequeEspecial(double taxa) {
        if (this.saldo < 0) {
            this.saldo += this.saldo * (taxa / 100);
        }
    }
}
