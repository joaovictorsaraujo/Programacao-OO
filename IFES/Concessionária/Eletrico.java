public class Eletrico extends Veiculo{
    private double autonomiaBat;
    private double capacidadeBat;

    public Eletrico(String marca, String modelo, int anoFab, int mesFab, int anoMod, double valorVeiculo, double autonomiaBat, double capacidadeBat) {
        super(marca, modelo, anoFab, mesFab, anoMod, valorVeiculo);
        this.autonomiaBat = autonomiaBat;
        this.capacidadeBat = capacidadeBat;
    }

    public int getAutonomia() {
        return (int) this.autonomiaBat;
    }

    public String getAutonomiaString() {
        return super.toString() + " (Elétrico)";
    }
}
