package software.classes;

import oshi.SystemInfo;
import oshi.hardware.Baseboard;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSFileStore;

public class GetDados {

    private UsuarioAndAtivo uaa = new UsuarioAndAtivo();
    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hal = si.getHardware();
    private CentralProcessor cp = hal.getProcessor();
    private Baseboard b = hal.getComputerSystem().getBaseboard();
    private OSFileStore[] fls = si.getOperatingSystem().getFileSystem().getFileStores();

    protected String getAtivoID(){
       String idAtivo = b.getSerialNumber();
       uaa.setIdAtivo(idAtivo);
       return idAtivo;// retorna o id do Ativo;
    }

    protected long getConsumoRam() {
        long disponivelRam = hal.getMemory().getAvailable();
        long totalRam = hal.getMemory().getTotal();
        long consumoRam = (100 * (totalRam - disponivelRam)) / totalRam;// Regra de 3;

        return consumoRam; // Retorna o consumo da ram em porcentagem;
    }

    protected long getConsumoHD() {
        long totalHD = fls[0].getTotalSpace();
        long disponivelHD = fls[0].getUsableSpace();
        long consumoHD = (100 * (totalHD - disponivelHD)) / totalHD;

        return consumoHD;
    }

    protected double getConsumoCPU() {
        double consumoCPU = cp.getSystemCpuLoad() * 100;
        consumoCPU = Math.round(consumoCPU); // Retorna o valor do argumento arredondado para o valor long mais próximo;

        return consumoCPU;
    }

}
