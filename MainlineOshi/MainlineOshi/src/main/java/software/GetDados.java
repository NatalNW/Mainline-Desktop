package software;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSFileStore;

public class GetDados {
    
    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hal = si.getHardware();
    private CentralProcessor cp = hal.getProcessor();
    private OSFileStore[] fls = si.getOperatingSystem().getFileSystem().getFileStores();
    
   public long getConsumoRam(){
        long disponivelRam = hal.getMemory().getAvailable();
        long totalRam = hal.getMemory().getTotal();
        long consumoRam = (100*(totalRam - disponivelRam)) / totalRam;
        
        return consumoRam;
    }
    
    public long getConsumoHD(){
        long totalHD = fls[0].getTotalSpace();
        long disponivelHD = fls[0].getUsableSpace();
        long consumoHD = (100*(totalHD - disponivelHD))/totalHD;
        
        return consumoHD;
    }
    
    public double getConsumoCPU(){
        double consumoCPU = cp.getSystemCpuLoad() * 100;
        consumoCPU = Math.round(consumoCPU);
        
        return consumoCPU;
    }
    
}
