package software.oshi;

public class Ram {

    private final Oshi oshi = new Oshi();

    public float getConsumoRam() {
        long disponivelRam = oshi.getMemory().getAvailable();
        long totalRam = oshi.getMemory().getTotal();
        long consumoRam = (100 * (totalRam - disponivelRam)) / totalRam;// Regra de 3;

        return consumoRam; // Retorna o consumo da ram em porcentagem;
    }

    public float getMemoriaTotal() {
        long total = oshi.getMemory().getTotal();

        return total;
    }

    public float getMemoriaDiponivel() {
        long disponivel = oshi.getMemory().getAvailable();

        return disponivel;
    }

    public float getMemoriaUsada() {
        long total = oshi.getMemory().getTotal();
        long disponivel = oshi.getMemory().getAvailable();

        return total - disponivel;
    }

}
