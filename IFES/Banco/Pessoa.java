package banco;

import java.util.Scanner;

/**
 *
 * @author 20241bsi0319
 */
public class Pessoa {
    protected String nome;
    protected Data nasc;
    protected char sexo;
    protected String cpf;

    public Pessoa() {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o nome: ");
        this.nome = input.nextLine();

        System.out.print("Digite o CPF: ");
        this.cpf = input.nextLine();

        System.out.println("Informe a data de nascimento:");
        this.nasc = new Data();

        System.out.print("Informe o sexo: ");
        this.sexo = input.nextLine().charAt(0);
    }

    public Pessoa(String n, Data d, char s, String c) {
        this.nome = n;
        this.nasc = d;
        this.sexo = s;
        this.cpf = c;
    }

    public Pessoa(String n, int d, int m, int a, char s, String c) {
        this(n, new Data(d, m, a), s, c);
    }

    public int idade(Data hoje) {
        int age = hoje.getAno() - this.nasc.getAno();
        if (this.nasc.getMes() > hoje.getMes()) { //Confere se o mês de aniversário passou
            age--;
        } else if (this.nasc.getMes() == hoje.getMes()) {//Se estiver no mês de aniversário:
            if (this.nasc.getDia() > hoje.getDia()) {  //Confere se o dia de aniversário passou
                age--;
            }
        }
        return age;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
