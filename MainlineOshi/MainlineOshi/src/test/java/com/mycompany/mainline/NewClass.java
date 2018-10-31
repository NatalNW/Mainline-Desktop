//TESTES FEITOS AQUI!!!!
package com.mycompany.mainline;
//TESTES FEITOS AQUI!!!!

import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.Display;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PowerSource;
import oshi.hardware.UsbDevice;
import oshi.hardware.common.AbstractHardwareAbstractionLayer;
import oshi.software.common.AbstractOperatingSystem;
import oshi.software.os.FileSystem;
import oshi.software.os.NetworkParams;
import oshi.software.os.OSFileStore;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystemVersion;
import oshi.util.FormatUtil;
//TESTES FEITOS AQUI!!!!

public class NewClass {

    //TESTES FEITOS AQUI!!!!
    public static void main(String[] args) {
        SystemInfo si = new SystemInfo();// classe de informacoes do sistema
        
        /* TESTE StringBuider
        StringBuilder select = new StringBuilder();
        
        int t = 123123;
        int t2 = 23434;
        
        select.append("SELECT * FROM usuario WHERE email = ");
        select.append(t);
        select.append(" and senha = ");
        select.append(t2);
        */
        
        //System.out.println(si.getHardware().getComputerSystem().getBaseboard().getSerialNumber());

        // Firmware
        /* String name = si.getHardware().getComputerSystem().getFirmware().getName();
        String date = si.getHardware().getComputerSystem().getFirmware().getReleaseDate();
        String vercao = si.getHardware().getComputerSystem().getFirmware().getVersion();
         */
        // Ativo(ex: PC, Notebook)
        /* String fabricante = si.getHardware().getComputerSystem().getManufacturer();
        String modelo = si.getHardware().getComputerSystem().getModel();
        String numSerial = si.getHardware().getComputerSystem().getSerialNumber();
         */
        // Baseboard(Placa Mãe)
        /* String numSerial2 = si.getHardware().getComputerSystem().getBaseboard().getSerialNumber();
          String js = si.getHardware().getComputerSystem().getBaseboard().getVersion();
         */
        // Tela(Monitor)
        //Display[] display = si.getHardware().getDisplays();      
        // TIMER
        /*int delay = 5000;
        int interval = 1000;
        Timer timer = new Timer();
         timer.scheduleAtFixedRate(new TimerTask() {
                //    @Override
                //  public void run() {
                //System.out.println(consumo);
                // }
                //}, delay, interval);
         */
        // Consumo RAM
          /*  HardwareAbstractionLayer hal = si.getHardware();
            long memoriaDisponivel = hal.getMemory().getAvailable();
            long memoriaTotal = hal.getMemory().getTotal();
            long memUso = memoriaTotal - memoriaDisponivel;
            long consumo = ((100*memUso)/ memoriaTotal);
       */
        // Consumo HD
          /*  OSFileStore[] fls = si.getOperatingSystem().getFileSystem().getFileStores(); 
            long fs = new OSFileStore().getTotalSpace();
            long usageHD = fls[0].getTotalSpace() - fls[0].getUsableSpace();
            long consumoHD = (100*usageHD)/ fls[0].getTotalSpace();
            */
           // System.out.println(consumo);
            
        // Consumo CPU
      /* HardwareAbstractionLayer hal = si.getHardware();
        CentralProcessor cp = hal.getProcessor();
        double teste = cp.getSystemCpuLoad() * 100;
                teste = Math.round(teste);
                System.out.println(teste);
        */  

        // TIMER
       /* int delay = 5000;
        int interval = 1000;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                
            }
        }, delay, interval);
*/
        // Info SO
        /* int processos = si.getOperatingSystem().getProcessCount();
                int IDprocessos = si.getOperatingSystem().getProcessId();
                int numThread = si.getOperatingSystem().getThreadCount();
                String buildNumber = si.getOperatingSystem().getVersion().getBuildNumber(); // Não sei oq é
                long maxFlieDescriptors = si.getOperatingSystem().getFileSystem().getMaxFileDescriptors(); // Não sei oq é
                long openFileDescriptors = si.getOperatingSystem().getFileSystem().getOpenFileDescriptors(); // Não sei oq é
                String fabricanteSO = si.getOperatingSystem().getManufacturer();
                String nomeSO = si.getOperatingSystem().getFamily();
                String versaoSO = si.getOperatingSystem().getVersion().getVersion();
                
                
                
                // Rede
                String nomeDominio = si.getOperatingSystem().getNetworkParams().getDomainName();
                String gatewayIPV4 = si.getOperatingSystem().getNetworkParams().getIpv4DefaultGateway();
                String[] DNS = si.getOperatingSystem().getNetworkParams().getDnsServers();
                
                
                
                System.out.println("\n"+Nome_Da_Variavel+"\n");//
         */
        
       // testeMetodos tm = new testeMetodos();
        
        //System.out.println(tm.getConsumoCPU());
    }
}
