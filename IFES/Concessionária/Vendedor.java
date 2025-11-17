import java.util.ArrayList;

public class Vendedor extends Funcionario {
    private double comissao;
    private ArrayList<Venda> vendidos;

    public Vendedor(String nome, String cpf, int dia, int mes, int ano, double salario, double comissao){
        super(nome, cpf, dia, mes, ano, salario);
        this.comissao = comissao;
        this.vendidos = new ArrayList<>();
    }

    public void addVenda(Venda v) {
        this.vendidos.add(v);
    }

    public double comissaoTotal(int mes, int ano) {
        double total = 0;
        for (Venda v : vendidos)
            if (v.getData().getMes() == mes && v.getData().getAno() == ano){
                total += v.valor() + (v.valor() * this.comissao);
            }
        return total;
    }

    public double getSalario(int mes, int ano) {
        return this.salario + this.comissaoTotal(mes, ano);
    }

    public ArrayList<Venda> getVendidos() {
        return vendidos;
    }
}
