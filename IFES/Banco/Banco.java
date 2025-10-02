package banco;
import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    public static int menuInicial() {
        Scanner s = new Scanner(System.in);

        System.out.println("\nBem-vindo! Opcoes disponiveis:");
        System.out.println("1) Cadastro");
        System.out.println("2) Movimentacao Financeira");
        System.out.println("0) Sair");

        System.out.print("Escolha uma opcao: ");
        return s.nextInt();
    }

    public static void menuCadastro(ArrayList<Pessoa> p, ArrayList<Gerente> g, ArrayList<Conta> c) {
        Scanner s = new Scanner(System.in);

        System.out.println("\nO que deseja cadastrar?");
        System.out.println("1) Novo Cliente");
        System.out.println("2) Novo Gerente");
        System.out.println("3) Nova Conta Corrente");
        System.out.println("4) Nova Conta Poupanca");

        System.out.print("Escolha uma opcao: ");
        int op = s.nextInt();

        System.out.print("\nCadastrando ");

        if (op == 1) {
            System.out.println("novo Cliente:");
            p.add(new Pessoa());}
        if (op == 2) {
            System.out.println("novo Gerente:");
            g.add(new Gerente());}
        if (op == 3) {
            System.out.println("nova Conta Corrente:");
            Pessoa tit = escolherPessoa(p);
            Gerente ger = escolherGerente(g);
            c.add(new ContaCorrente(tit, ger));
        }
        if (op == 4) {
            System.out.println("nova Conta Poupanca:");
            Pessoa tit = escolherPessoa(p);
            Gerente ger = escolherGerente(g);
            c.add(new Poupanca(tit, ger));
        }
    }

    public static Pessoa escolherPessoa(ArrayList<Pessoa> p) {
        Scanner s = new Scanner(System.in);
        int i = 1;
        System.out.println("Escolha o cliente da conta: ");
        for (Pessoa tit : p) {
            System.out.println(i + ") " + tit.getCpf() + " - " + tit.getNome());
            i++;
        }

        int index = s.nextInt();
        return p.get(index - 1);
    }

    public static Gerente escolherGerente(ArrayList<Gerente> g) {
        Scanner s = new Scanner(System.in);
        int i = 1;
        System.out.println("Escolha o gerente da conta: ");
        for (Gerente ger : g) {
            System.out.println(i + ") " + ger.getCpf() + " - " + ger.getNome());
            i++;
        }
        int index = s.nextInt();
        return g.get(index - 1);
    }

    public static void menuMovimentacoes(ArrayList<Conta> c) {
        Scanner s = new Scanner(System.in);

        Conta conta1 = escolherConta(c);
        System.out.println("\nO que deseja realizar?");
        System.out.println("1) Extrato da conta");
        System.out.println("2) Saque");
        System.out.println("3) Deposito");
        System.out.println("4) Transferencia");

        System.out.print("Selecione uma opcao: ");
        int op = s.nextInt();

        System.out.print("Gerando ");

        if (op == 1) {
            System.out.println("Extrato");
            conta1.extrato();}
        if (op == 2) {
            System.out.println("Saque");
            conta1.sacar();}
        if (op == 3) {
            System.out.println("Deposito");
            conta1.depositar();}
        if (op == 4) {
            System.out.println("Transferencia");
            System.out.println("Conta destino: ");
            Conta conta2 = escolherConta(c);
            conta1.transf(conta2);
        }
    }

    public static Conta escolherConta(ArrayList<Conta> c) {
        Scanner s = new Scanner(System.in);

        System.out.println("\nContas cadastradas:");
        int i = 1;
        for (Conta con : c) {
            System.out.println(i + ") " + con.getNumero() + " - " + con.getTitular().getNome());
            i++;
        }
        System.out.print("Selecione a conta: ");
        int index = s.nextInt();
        return c.get(index - 1);
    }

    public static void main(String[] args) {
        ArrayList<Pessoa> p =  new ArrayList<>();
        ArrayList<Gerente> g =  new ArrayList<>();
        ArrayList<Conta> c =  new ArrayList<>();

        int op = menuInicial();
        while (op != 0) {
            if (op == 1) {
                menuCadastro(p, g, c);
            }
            if (op == 2) {
                menuMovimentacoes(c);
            }
            op = menuInicial();
        }
        System.out.println("\nBye! :-)");
    }
}
