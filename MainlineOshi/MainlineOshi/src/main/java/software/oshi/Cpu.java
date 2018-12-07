package software.oshi;

import oshi.util.FormatUtil;

public class Cpu {

    private final Oshi oshi = new Oshi();

    public String getVersaoCpu() {
        String nomeCPU = oshi.getProcessor().getName();

        return nomeCPU;
    }

    public String getTempoDeAtividade() {
        long tda = oshi.getProcessor().getSystemUptime();

        return FormatUtil.formatElapsedSecs(tda);
    }

    public int getNumeroDeThreads() {
        int ndt = oshi.getOperatingSystem().getThreadCount();

        return ndt;
    }

    public int getNumeroDeProcessos() {
        int ndp = oshi.getOperatingSystem().getProcessCount();

        return ndp;
    }

    public long getInterrupcoes() {
        long interrupcoes = oshi.getProcessor().getInterrupts();

        return interrupcoes;
    }

    public float getConsumoCPU() {
        float consumoCPU = (float) (oshi.getProcessor().getSystemCpuLoad() * 100);
        consumoCPU = Math.round(consumoCPU); // Retorna o valor do argumento arredondado para o valor long mais próximo;

        return consumoCPU;
    }
}
