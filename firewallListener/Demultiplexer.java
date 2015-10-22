package firewallListener;

import java.io.IOException;
import java.io.OutputStream;

import java.net.Socket;

public class Demultiplexer implements Runnable {

    private Socket socket;
    private String firewallIp;
    private String code;
    private String packet;
	
	public Demultiplexer(QueueListenedInfo receivedInfo) {
        this.socket = receivedInfo.getSocket();
        this.firewallIp = receivedInfo.getFirewallIp();
        this.code = receivedInfo.getCode();
        if (this.code.equals("exp")) {
          this.packet = receivedInfo.getPacket();
        }
	}
	
	public void run() {

        try {
            EventHandler eventHandler = new EventHandler("localhost",
                "root", "klpsoma123");

            PacketAnalyzer packetAnalyzer = null;
            OutputStream outputStream = socket.getOutputStream();

            switch(code) {
                case "ini":
                    eventHandler.initEvent(socket);
                    break;
                case "exp":
                    packetAnalyzer = new PacketAnalyzer(code, this.packet);
                    eventHandler.expiredEvent(packetAnalyzer);
                    outputStream.write("success".getBytes());
                    break;
                case "alm":
                    packetAnalyzer = new PacketAnalyzer(code, this.packet);
                    eventHandler.alarmEvent(packetAnalyzer);
                    outputStream.write("success".getBytes());
                    break;
                default:
                    outputStream.write("cdError".getBytes());
                    break;
            }

            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
