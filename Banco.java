package banco;

/**
 *
 * @author 20241bsi0319
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Pessoa p1, p2, p3, p4;
        p1 = new Pessoa("Joao Victor Santos Araujo", 14, 6, 2005, 'M', "129.280.157-36");
        p2 = new Pessoa("Maria Fernanda Oliveira", 23, 11, 2003, 'F', "348.192.765-20");
        p3 = new Pessoa("Carlos Eduardo Silva", 7, 4, 2001, 'M', "517.384.992-14");
        p4 = new Pessoa("Beatriz Almeida Rocha", 30, 1, 2004, 'F', "621.984.357-09");

        Gerente g1, g2;
        System.out.println("NOVO(A) GERENTE:");
        g1 = new Gerente("Ana Beatriz Costa", 12, 8, 1990, 'F', "245.678.901-32", "MAT001");
        g2 = new Gerente();

        ContaCorrente cc1, cc2;
        Poupanca pp1, pp2;
        cc1 = new ContaCorrente(g1);
        pp1 = new Poupanca(g1);
        pp2 = new Poupanca(g2);
        cc2 = new ContaCorrente(g2);

        cc1.depositar(500);
        cc1.sacar(200);
        cc1.transf(250, pp1);
        cc1.extrato();
    }
}
