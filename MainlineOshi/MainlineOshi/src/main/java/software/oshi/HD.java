package software.oshi;

import oshi.software.os.OSFileStore;

public class HD {

    private final Oshi oshi = new Oshi();
    private final OSFileStore[] fls = oshi.getFileSystem().getFileStores();

    public float getEspacoTotal() {
        long total = fls[0].getTotalSpace();

        return total;
    }

    public float getEspacoDisponivel() {
        long usavel = fls[0].getUsableSpace();

        return usavel;
    }

    public float getEspacoUsado() {
        long total = fls[0].getTotalSpace();
        long usavel = fls[0].getUsableSpace();

        return total - usavel;
    }

    public float getConsumoHD() {
        long totalHD = fls[0].getTotalSpace();
        long disponivelHD = fls[0].getUsableSpace();
        long consumoHD = (100 * (totalHD - disponivelHD)) / totalHD;

        return consumoHD;
    }

}
