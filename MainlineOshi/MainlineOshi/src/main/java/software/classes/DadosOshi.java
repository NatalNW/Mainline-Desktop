package software.classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import oshi.SystemInfo;
import oshi.hardware.Baseboard;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;
import oshi.software.os.OSFileStore;

public class DadosOshi {

    private final SystemInfo si = new SystemInfo();
    private final HardwareAbstractionLayer hal = si.getHardware();
    private final CentralProcessor cp = hal.getProcessor();
    private final Baseboard b = hal.getComputerSystem().getBaseboard();
    private final OSFileStore[] fls = si.getOperatingSystem().getFileSystem().getFileStores();
    private final NetworkIF[] net = hal.getNetworkIFs();

    public String getAtivoID() {
        String idAtivo = b.getSerialNumber();

        return idAtivo;// retorna o id do Ativo;
    }

    public float getConsumoRam() {
        long disponivelRam = hal.getMemory().getAvailable();
        long totalRam = hal.getMemory().getTotal();
        long consumoRam = (100 * (totalRam - disponivelRam)) / totalRam;// Regra de 3;

        return consumoRam; // Retorna o consumo da ram em porcentagem;
    }

    public float getConsumoHD() {
        long totalHD = fls[0].getTotalSpace();
        long disponivelHD = fls[0].getUsableSpace();
        long consumoHD = (100 * (totalHD - disponivelHD)) / totalHD;

        return consumoHD;
    }

    public float getConsumoCPU() {
        float consumoCPU = (float) (cp.getSystemCpuLoad() * 100);
        consumoCPU = Math.round(consumoCPU); // Retorna o valor do argumento arredondado para o valor long mais próximo;

        return consumoCPU;
    }

    protected float getUpload() throws InterruptedException {
        int deltaTime = 1000;

        net[0].updateNetworkStats();
        long env = net[0].getBytesSent();
        Thread.sleep(deltaTime);
        net[0].updateNetworkStats();
        long envAgain = net[0].getBytesSent() - env;

        float upload = (float) ((envAgain / deltaTime) * 8);

        return upload;
    }

    protected float getDownload() throws InterruptedException {
        int deltaTime = 1000;

        net[0].updateNetworkStats();
        long receb = net[0].getBytesRecv();
        Thread.sleep(deltaTime);
        net[0].updateNetworkStats();
        long recebAgain = net[0].getBytesRecv() - receb;

        float dowload = (float) ((recebAgain / deltaTime) * 8);

        return dowload;
    }

    protected String getDia() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    protected String getHora() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
