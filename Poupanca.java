package banco;

/**
 *
 * @author 20241bsi0319
 */
public class Poupanca extends Conta{

    public Poupanca(Gerente ger){
        super(ger);
    }

    public Poupanca(String num, Pessoa tit, Gerente ger, Data d){
        super(num, tit, ger, d);
    }

    public void extrato() {
        System.out.println("*** EXTRATO DA POUPANCA: ***");
        super.extrato();
    }
    
    public void rendimentos(double taxa) {
        this.saldo += this.saldo * (taxa / 100);
    }
}


