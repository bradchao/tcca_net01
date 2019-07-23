package tw.org.tcca.app.myproj02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.net.NetworkInterface;
import java.util.Enumeration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

            }
        }catch (Exception e){

        }
    }

}
