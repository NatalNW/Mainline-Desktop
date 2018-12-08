package software.oshi;

import oshi.util.FormatUtil;

public class Ram {

    private final Oshi oshi = new Oshi();

    public float getConsumoRam() {
        long disponivelRam = oshi.getMemory().getAvailable();
        long totalRam = oshi.getMemory().getTotal();
        long consumoRam = (100 * (totalRam - disponivelRam)) / totalRam;// Regra de 3;

        return consumoRam; // Retorna o consumo da ram em porcentagem;
    }

    public String getMemoriaTotal() {
        long total = oshi.getMemory().getTotal();

        return FormatUtil.formatBytes(total);
    }

    public String getMemoriaDiponivel() {
        long disponivel = oshi.getMemory().getAvailable();

        return FormatUtil.formatBytes(disponivel);
    }

    public String getMemoriaUsada() {
        long total = oshi.getMemory().getTotal();
        long disponivel = oshi.getMemory().getAvailable();

        return FormatUtil.formatBytes(total - disponivel);
    }

}
