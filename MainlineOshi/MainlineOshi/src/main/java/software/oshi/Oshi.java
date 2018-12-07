package software.oshi;

import oshi.SystemInfo;
import oshi.hardware.Baseboard;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.NetworkParams;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystemVersion;

public class Oshi {

    private final SystemInfo si = new SystemInfo();

    protected HardwareAbstractionLayer getHardware() {
        return si.getHardware();
    }

    protected OperatingSystem getOperatingSystem() {
        return si.getOperatingSystem();
    }

    protected CentralProcessor getProcessor() {
        return getHardware().getProcessor();
    }

    protected Baseboard getBasebosrd() {
        return getComputerSystem().getBaseboard();
    }
    
    protected FileSystem getFileSystem(){
        return si.getOperatingSystem().getFileSystem();
    }
    
    protected OperatingSystemVersion getVersion(){
        return getOperatingSystem().getVersion();
    }
    
    protected GlobalMemory getMemory(){
        return getHardware().getMemory();
    }
    
    protected NetworkParams getNetworkParams(){
        return getOperatingSystem().getNetworkParams();
    }

    private ComputerSystem getComputerSystem() {
        return getHardware().getComputerSystem();
    }

}
