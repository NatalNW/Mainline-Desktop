package software.oshi;

public class Ativo {

    private final Oshi oshi = new Oshi();

    public String getAtivoID() {
        String idAtivo = oshi.getBasebosrd().getSerialNumber();

        return idAtivo;
    }

    public String getSO() {
        String versao = oshi.getVersion().getVersion();
        String so = oshi.getOperatingSystem().getFamily();

        return so + " " + versao;
    }

    public long getTempoDeAtividade() {
        long tda = oshi.getProcessor().getSystemUptime();

        return tda;
    }
}
