public class Hibrido extends Veiculo{
    private double autonomiaComb;
    private double capacidadeComb;
    private double autonomiaBat;
    private double capacidadeBat;

    public Hibrido(String marca, String modelo, int anoFab, int mesFab, int anoMod, double valorVeiculo, double autonomiaBat, double capacidadeBat, double autonomiaComb, double capacidadeComb) {
        super(marca, modelo, anoFab, mesFab, anoMod, valorVeiculo);
        this.autonomiaComb = autonomiaBat;
        this.capacidadeComb = capacidadeBat;
        this.autonomiaBat = autonomiaBat;
        this.capacidadeBat = capacidadeBat;
    }

    public int getAutonomia() {
        return (int) (this.autonomiaComb + this.autonomiaBat);
    }

    public String getAutonomiaString() {
        return super.toString() + " (Híbrido)";
    }
}
