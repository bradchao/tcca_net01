package tw.org.tcca.app.myproj02;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class MyNetworkTest {
    public static void main(String[] args) {
        // UDP Receiver
        byte[] buf = new byte[4096];
        try {
            DatagramSocket socket =
                    new DatagramSocket(8888);
            DatagramPacket packet =
                    new DatagramPacket(buf, buf.length);
            System.out.println("wait...");
            socket.receive(packet);
            socket.close();

            InetAddress urip = packet.getAddress();
            byte[] data = packet.getData();
            int len = packet.getLength();
            System.out.println(urip.getHostAddress());
            System.out.println(new String(data,0, len));

        } catch (Exception e) {
            System.out.println(e.toString());
        }


    }
}

