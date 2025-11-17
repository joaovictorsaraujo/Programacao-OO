import java.util.ArrayList;

public class Sistema {
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Gerente> gerentes;
    private ArrayList<Cliente> clientes;

    public Sistema() {
        this.veiculos = new ArrayList<>();
        this.vendedores = new ArrayList<>();
        this.gerentes = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public ArrayList<Veiculo> getVeiculos() { return veiculos; }

    public ArrayList<Vendedor> getVendedores() { return vendedores; }

    public ArrayList<Gerente> getGerentes() { return gerentes; }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void adicionar(Veiculo veiculo) { this.veiculos.add(veiculo); }

    public void adicionar(Vendedor veiculo) { this.vendedores.add(veiculo); }

    public void adicionar(Gerente gerente) { this.gerentes.add(gerente); }

    public void adicionar(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void listarClientes() {
        System.out.println("Clientes cadastrados:");

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado");
        }
        else {
            for (Cliente c : this.clientes) {
                System.out.println(c);
            }
        }
    }

    public void listarVendedores() {
        System.out.println("Vendedores cadastrados:");

        if (vendedores.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado");
        }
        else {
            for (Vendedor v : this.vendedores) {
                System.out.println(v);
            }
        }
    }

    public void listarGerentes() {
        System.out.println("Gerentes cadastrados:");

        if (gerentes.isEmpty()) {
            System.out.println("Nenhum gerente cadastrado");
        }
        else {
            for (Gerente g : this.gerentes) {
                System.out.println(g);
            }
        }
    }

    public void listarVeiculos() {
        System.out.println("Veiculos cadastrados:");

        if  (veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo cadastrado");
        }
        else {
            for (Veiculo v : this.veiculos) {
                System.out.println(v);
            }
        }
    }

    public Cliente localizarCliente(String cpf) {
        for (Cliente c : this.clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public Gerente localizarGerente(String cpf) {
        for (Gerente g : this.gerentes) {
            if (g.getCpf().equals(cpf)) {
                return g;
            }
        }
        return null;
    }

    public Vendedor localizarVendedor(String cpf) {
        for (Vendedor v : this.vendedores) {
            if (v.getCpf().equals(cpf)) {
                return v;
            }
        }
        return null;
    }

    public Veiculo localizarVeiculo(int num) {
        return veiculos.get(num);
    }

    public void atribuirVendaVendedor(Venda venda, Vendedor vendedor) {
        vendedor.addVenda(venda);
    }

    public void relatorio(int mes, int ano) {
        System.out.println("*** RELATÓRIO DE VENDAS MENSAL DE " + mes + "/" + ano + " ***");
        double totalMes = 0;

        for (Vendedor vendedor : vendedores) {
            for (Venda venda : vendedor.getVendidos()) {
                if (venda.getData().getMes() == mes && venda.getData().getAno() == ano) {
                    double salarioVendedorMes = vendedor.getSalario(mes, ano);
                    System.out.println("Vendedor: " +  vendedor.getNome());
                    System.out.println(venda.toString());
                    System.out.println("***************************************");

                    totalMes += venda.valor();
                }
            }
        }
        System.out.println("Total: R$" + totalMes);
    }

    public void relatorio(int ano) {
        System.out.println("*** RELATÓRIO DE VENDAS ANUAL DE " + ano + " ***");
        double totalAno = 0;

        for (Vendedor vendedor : vendedores) {
            for (Venda venda : vendedor.getVendidos()) {
                if (venda.getData().getAno() == ano) {
                    System.out.println("Vendedor: " + vendedor.getNome());
                    System.out.println(venda.toString());
                    System.out.println("***************************************");
                    totalAno += venda.valor();
                }
            }
        }
        System.out.println("Total: R$" + totalAno);
    }

    public void relatorio(Vendedor vendedor) {
        System.out.println("*** RELATÓRIO DE VENDAS DO VENDEDOR ***");
        System.out.println("Vendas do vendedor " + vendedor.getNome() + ":");
        double totalVendedor = 0;

        for (Venda venda : vendedor.getVendidos()) {
            System.out.println(venda.toString());
            System.out.println("***************************************");
            totalVendedor += venda.valor();
        }
        System.out.println("Total: R$" + totalVendedor);
    }
}

