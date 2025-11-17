public class Venda {
    private Vendedor vendedor;
    private Veiculo veiculo;
    private Cliente cliente;
    private double desconto;
    private Data d;
    private String chassi;

    public Venda(Vendedor vendedor, Veiculo veiculo, Cliente Cliente, double desconto, int dia, int mes, int ano, String chassi) {
        this.vendedor = vendedor;
        this.veiculo = veiculo;
        this.cliente = Cliente;
        this.desconto = desconto;
        this.d = new Data(dia, mes, ano);
        this.chassi = chassi;
    }

    public double valor() {
        return this.veiculo.valorVeiculo - this.desconto;
    }

    public void setDesconto(double desconto, Gerente gerente, String senha) {
        if (gerente.validarAcesso(senha)) {
            this.desconto = desconto;
            System.out.println("Desconto alterado com sucesso!");
        }
        else {
            System.out.println("Acesso negado!");
        }
    }

    public String toString() {
        String retorno = "Veiculo: " + this.veiculo.toString() + "\n" +
                        "Cliente: " +  this.cliente.toString() + "\n" +
                        "Valor da venda: R$" + this.valor() + "\n" +
                        "Data: " + this.d.toString();
        return retorno;
    }

    public Data getData() { return this.d; }

    public Veiculo getVeiculo() { return this.veiculo; }

    public Cliente getCliente() { return this.cliente; }
}
