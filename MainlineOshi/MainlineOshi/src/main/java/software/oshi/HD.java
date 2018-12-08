package software.oshi;

import oshi.software.os.OSFileStore;
import oshi.util.FormatUtil;

public class HD {

    private final Oshi oshi = new Oshi();
    private final OSFileStore[] fls = oshi.getFileSystem().getFileStores();

    public String getEspacoTotal() {
        long total = fls[0].getTotalSpace();

        return FormatUtil.formatBytes(total);
    }

    public String getEspacoDisponivel() {
        long usavel = fls[0].getUsableSpace();

        return FormatUtil.formatBytes(usavel);
    }

    public String getEspacoUsado() {
        long total = fls[0].getTotalSpace();
        long usavel = fls[0].getUsableSpace();

        return FormatUtil.formatBytes(total - usavel);
    }

    public float getConsumoHD() {
        long totalHD = fls[0].getTotalSpace();
        long disponivelHD = fls[0].getUsableSpace();
        long consumoHD = (100 * (totalHD - disponivelHD)) / totalHD;

        return consumoHD;
    }

}
