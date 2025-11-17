public class Veiculo {
    protected String marca;
    protected String modelo;
    protected int anoFab, mesFab, anoMod;
    protected double valorVeiculo;

    public Veiculo(String marca, String modelo, int anoFab, int mesFab, int anoMod, double valorVeiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFab = anoFab;
        this.mesFab = mesFab;
        this.anoMod = anoMod;
        this.valorVeiculo = valorVeiculo;
    }

    public int getAutonomia() {
        return 0;
    }

    public String toString() {
        return marca + " " + modelo + " " +  anoFab + "/" + anoMod  + " - Autonomia: " + this.getAutonomia() + "km";
    }
}
