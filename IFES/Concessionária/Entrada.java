import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe com as rotinas de entrada e saída do projeto
 * @author Hilario Seibel Junior e João Victor S Araujo/João Victor N Ribeiro
 */
public class Entrada {
    public Scanner input;

    /**
     * Construtor da classe Entrada
     * Se houver um arquivo input.txt na pasta em que o projeto está sendo executado,
     * define que o Scanner vai ler deste arquivo e não do teclado.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     * NÃO ALTERE O CODIGO DESSA CLASSE!
     */
    public Entrada() {
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("input.txt"));
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in);
        }
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um double
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para double
     */
    private double lerDouble(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = this.lerLinha(msg);
        return Double.parseDouble(linha);
    }

    /**
     * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public int menu() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.

        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar Cliente\n" +
                "2) Cadastrar Vendedor\n" +
                "3) Cadastrar Gerente\n" +
                "4) Cadastrar Veículo\n" +
                "5) Cadastrar Venda\n" +
                "6) Histórico de Vendas Mensal\n" +
                "7) Histórico de Vendas Anual\n" +
                "8) Histórico de Vendas do Vendedor:\n" +
                "0) Sair\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 11) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;
    }

    /***************************************************/

    /**
     * Lê os dados de um novo Cliente e cadastra-o no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadCliente(Sistema s) {
        s.listarClientes();

        String nome = this.lerLinha("Digite o nome do cliente: ");
        String cpf = this.lerLinha("Digite o cpf do cliente: ");
        int dia = this.lerInteiro("Digite o dia do nascimento do cliente: ");
        int mes = this.lerInteiro("Digite o mês do nascimento do cliente: ");
        int ano = this.lerInteiro("Digite o ano do nascimento do cliente: ");
        String email = this.lerLinha("Digite o email do cliente: ");

        if (s.localizarCliente(cpf) == null) { // Garantindo que o não CPF esteja duplicado.
            Cliente c = new Cliente(nome, cpf, dia, mes, ano, email);
            s.adicionar(c);
        }
        else {
            System.out.println("Erro: CPF duplicado. Cliente não adicionado.");
        }
    }

    public void cadVendedor(Sistema s) {
        s.listarVendedores();

        String nome = this.lerLinha("Digite o nome do vendedor: ");
        String cpf = this.lerLinha("Digite o cpf do vendedor: ");
        int dia  = this.lerInteiro("Digite o dia de nascimento do vendedor: ");
        int mes = this.lerInteiro("Digite o mes de nascimento do vendedor: ");
        int ano = this.lerInteiro("Digite o ano de nascimento do vendedor: ");
        double salario  = this.lerDouble("Digite o salario mensal fixo do vendedor: ");
        double percentual = this.lerDouble("Digite o percentual de comissão deste vendedor: ");

        if (s.localizarVendedor(cpf) == null) { // Garantindo que o não CPF esteja duplicado.
            Vendedor v = new Vendedor(nome, cpf, dia, mes, ano, salario, percentual);
            s.adicionar(v);
        }
        else {
            System.out.println("Erro: CPF duplicado. Vendedor não adicionado.");
        }
    }

    public void cadGerente(Sistema s) {
        s.listarGerentes();

        String nome = this.lerLinha("Digite o nome do gerente: ");
        String cpf = this.lerLinha("Digite o cpf do gerente: ");
        int dia  = this.lerInteiro("Digite o dia de nascimento do gerente: ");
        int mes = this.lerInteiro("Digite o mes de nascimento do gerente: ");
        int ano = this.lerInteiro("Digite o ano de nascimento do gerente: ");
        double salario  = this.lerDouble("Digite o salario mensal fixo do gerente: ");
        String senha = this.lerLinha("Digite a senha do gerente: ");

        if (s.localizarGerente(cpf) == null) { // Garantindo que o não CPF esteja duplicado.
            Gerente g = new Gerente(nome, cpf, dia, mes, ano, salario, senha);
            s.adicionar(g);
        }
        else {
            System.out.println("Erro: CPF duplicado. Vendedor não adicionado.");
        }
    }

    public void cadVeiculo(Sistema s) {
        String marca = this.lerLinha("Digite a Marca do veículo: ");
        String modelo = this.lerLinha("Digite o Modelo do veículo: ");
        int anoFab = this.lerInteiro("Digite o ano de fabricação do veículo: ");
        int mesFab = this.lerInteiro("Digite o mês de fabricação do veículo: ");
        int anoMod = this.lerInteiro("Digite o ano do modelo do veículo: ");
        double valor = this.lerDouble("Digite o valor do veículo: ");

        int opcao = this.lerInteiro("Escolha o tipo do veículo: \n"
        + "1) Elétrico\n"
        + "2) Combustão\n"
        + "3) Híbrido\n");

        if (0 > opcao || opcao < 3) {
            System.out.println("Opção inválida! Tente novamente.");
        }

        double autoMot = 0;
        double capMot = 0;
        double autoBat = 0;
        double capBat = 0;

        if (opcao == 2 || opcao == 3) {
            autoMot = this.lerDouble("Digite a autonomia do motor (em km): ");
            capMot = this.lerDouble("Digite a capacidade do motor (em L): ");
        }
        if (opcao == 1 || opcao == 3) {
            autoBat = this.lerDouble("Digite a autonomia da bateria (em km): ");
            capBat = this.lerDouble("Digite a capacidade da bateria (em kwH): ");
        }

        if (opcao == 1) {
            Eletrico v = new Eletrico(marca, modelo, anoFab, mesFab, anoMod, valor, autoBat, capBat);
            s.adicionar(v);
        }
        if (opcao == 2){
            Combustao v = new Combustao(marca, modelo, anoFab, mesFab, anoMod, valor, autoMot, capMot);
            s.adicionar(v);
        }
        else {
            Hibrido v = new Hibrido(marca, modelo, anoFab, mesFab, anoMod, valor, autoMot, capMot, autoBat, capBat);
            s.adicionar(v);
        }
    }

    public void cadVenda(Sistema s) {
        s.listarVendedores();
        String cpfVendedor = this.lerLinha("Digite o CPF do vendedor: ");

        s.listarVeiculos();
        int veiculo = this.lerInteiro("Escolha um veículo pelo número: ");

        s.listarClientes();
        String cpfCliente = this.lerLinha("Digite o CPF do cliente: ");

        double desconto = lerDouble("Digite o desconto (em R$): ");
        int dia = lerInteiro("Digite o dia da venda: ");
        int mes = lerInteiro("Digite o mes de venda: ");
        int ano = lerInteiro("Digite o ano de venda: ");
        String chassi = lerLinha("Digite o chassi do veículo: ");

        Venda venda = new Venda(s.localizarVendedor(cpfVendedor), s.localizarVeiculo(veiculo - 1), s.localizarCliente(cpfCliente), desconto, dia, mes, ano, chassi);

        s.atribuirVendaVendedor(venda, s.localizarVendedor(cpfVendedor));
    }

    public void relatorioMensal(Sistema s) {
        System.out.println("Gerar relatório de vendas mensal:");
        int mes = this.lerInteiro("Digite o mes: ");
        int ano = this.lerInteiro("Digite o ano: ");

        s.relatorio(mes, ano);
    }

    public void relatorioAnual(Sistema s) {
        System.out.println("Gerar relatório de vendas anual:");
        int ano = this.lerInteiro("Digite o ano: ");

        s.relatorio(ano);
    }

    public void relatorioVendedor(Sistema s) {
        System.out.println("Gerar relatório de vendas do vendedor:");
        String cpf = lerLinha("Digite o CPF do vendedor: ");

        s.relatorio(s.localizarVendedor(cpf));
    }
}
