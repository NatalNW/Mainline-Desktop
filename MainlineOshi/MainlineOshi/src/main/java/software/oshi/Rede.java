package software.oshi;

import oshi.hardware.NetworkIF;

public class Rede {

    private final Oshi oshi = new Oshi();
    private final NetworkIF[] net = oshi.getHardware().getNetworkIFs();

    public String getDominioRede() {
        String dr = oshi.getNetworkParams().getDomainName();

        return dr;
    }

    public String getNomeRede() {
        String nr = net[0].getDisplayName();

        return nr;
    }

    public float getUpload() throws InterruptedException {
        int deltaTime = 1000;

        net[0].updateNetworkStats();
        long env = net[0].getBytesSent();
        Thread.sleep(deltaTime);
        net[0].updateNetworkStats();
        long envAgain = net[0].getBytesSent() - env;

        float upload = (float) ((envAgain / deltaTime) * 8);

        return upload;
    }

    public float getDownload() throws InterruptedException {
        int deltaTime = 1000;

        net[0].updateNetworkStats();
        long receb = net[0].getBytesRecv();
        Thread.sleep(deltaTime);
        net[0].updateNetworkStats();
        long recebAgain = net[0].getBytesRecv() - receb;

        float dowload = (float) ((recebAgain / deltaTime) * 8);

        return dowload;
    }
}
