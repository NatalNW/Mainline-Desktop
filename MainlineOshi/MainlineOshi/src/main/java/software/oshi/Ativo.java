package software.oshi;

import com.sun.jna.Platform;

public class Ativo {

    private final Oshi oshi = new Oshi();

    public String getAtivoID() {
       if(Platform.isLinux()){
           return oshi.getProcessor().getProcessorID();
       }else if(Platform.isWindows()){
           return oshi.getBasebosrd().getSerialNumber();
       }else{
           return null;
       }
    }

    public String getSO() {
        String versao = oshi.getVersion().getVersion();
        String so = oshi.getOperatingSystem().getFamily();

        return so + " " + versao;
    }

}
