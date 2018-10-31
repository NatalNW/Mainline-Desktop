package software;

import oshi.SystemInfo;
import oshi.hardware.Baseboard;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSFileStore;

public class GetDados {
    // Essas variavei serão usadas para coletar informações do hardware do respectivo ativo;
    private SystemInfo si = new SystemInfo();
    private GlobalMemory gm = si.getHardware().getMemory();
    private CentralProcessor cp = si.getHardware().getProcessor();
	private Baseboard b = hal.getComputerSystem().getBaseboard();
    private OSFileStore[] fls = si.getOperatingSystem().getFileSystem().getFileStores(); // Array onde ficam os FileSystems do ativo. Ex: disco local C:, maquina virtual F: e etc;
	
	  protected String getAtivoID(){
       String idAtivo = b.getSerialNumber();
       
       return idAtivo;
    }
    
   public long getConsumoRam(){
        long disponivelRam = gm.getAvailable();
        long totalRam = gm.getTotal();
        long consumoRam = (100*(totalRam - disponivelRam)) / totalRam; // Regra de 3 ou Porcentagem;
        
        return consumoRam; // restorna a porcentagem de uso da memoria Ram
    }
    
    public long getConsumoHD(){
        long totalHD = fls[0].getTotalSpace(); //fls[0] por padrão é o disco C: ou o HD principal do ativo;
        long disponivelHD = fls[0].getUsableSpace();
        long consumoHD = (100*(totalHD - disponivelHD))/totalHD;// Regra de 3 ou Porcentagem;
        
        return consumoHD;// Restorna a porcentagem de uso do HD
    }
    
    public double getConsumoCPU(){
        double consumoCPU = cp.getSystemCpuLoad() * 100;
        consumoCPU = Math.round(consumoCPU); // Arredonda o valor para o long mais proximo
        
        return consumoCPU;// Restorna a porcentagem de uso da CPU
    }
    
}
