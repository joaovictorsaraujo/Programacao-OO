public class Combustao extends Veiculo {
    private double autonomiaComb;
    private double capacidadeComb;

    public Combustao(String marca, String modelo, int anoFab, int mesFab, int anoMod, double valorVeiculo, double autonomiaComb, double capacidadeComb) {
        super(marca, modelo, anoFab, mesFab, anoMod, valorVeiculo);
        this.autonomiaComb = autonomiaComb;
        this.capacidadeComb = capacidadeComb;
    }

    public int getAutonomia() {
        return (int) this.autonomiaComb;
    }

    public String getAutonomiaString() {
        return super.toString() + " (Combustão)";
    }
}
