package tw.org.tcca.app.myproj02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.Enumeration;

public class MainActivity extends AppCompatActivity {
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
    }

    public void getIP(View view) {
        new Thread(){
            @Override
            public void run() {
                fetchMyIP();
            }
        }.start();
    }

    private void fetchMyIP(){
        try {
            Enumeration<NetworkInterface> en =
                    NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()){
                NetworkInterface networkInterface = en.nextElement();
                Enumeration<InetAddress> ips =
                        networkInterface.getInetAddresses();
                while (ips.hasMoreElements()){
                    InetAddress ip = ips.nextElement();
                    Log.v("brad", ip.getHostAddress());
                }

            }
        }catch (Exception e){
            Log.v("brad", e.toString());
        }
    }

    public void sendUDP(View view) {
        new Thread(){
            @Override
            public void run() {
                String stringInput = input.getText().toString();
                byte[] buf = stringInput.getBytes();

                try {
                    DatagramSocket socket = new DatagramSocket();
                    DatagramPacket packet = new DatagramPacket(
                            buf, buf.length,
                            InetAddress.getByName("10.0.2.2"),8888
                    );
                    socket.send(packet);
                    socket.close();
                    Log.v("brad", "Send OK");

                }catch (Exception e){
                    Log.v("brad", e.toString());
                }
            }
        }.start();

    }


    public void sendTCP(View view) {
        new Thread(){
            @Override
            public void run() {
                try {
                    String stringInput = input.getText().toString();
                    byte[] buf = stringInput.getBytes();

                    Socket socket = new Socket(InetAddress.getByName("10.0.2.2"), 9999);
                    OutputStream out = socket.getOutputStream();
                    out.write(buf);
                    out.flush();
                    out.close();

                    Log.v("brad", "send OK");

                }catch (Exception e){
                    Log.v("brad", e.toString());
                }
            }
        }.start();


    }
}
