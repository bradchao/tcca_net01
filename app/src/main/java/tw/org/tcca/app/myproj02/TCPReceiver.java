package tw.org.tcca.app.myproj02;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPReceiver {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(9999);
            System.out.println("Listen...");
            Socket socket =  server.accept();

            InputStream in =  socket.getInputStream();
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));

            String line = null;
            while ( (line = br.readLine()) != null){
                System.out.println(line);
            }

            br.close();
            server.close();
            System.out.println("ok");
        }catch(Exception e) {
            System.out.println(e.toString());
        }


    }

}
