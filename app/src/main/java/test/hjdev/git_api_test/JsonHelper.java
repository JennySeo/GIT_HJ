package test.hjdev.git_api_test;

import android.os.Handler;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class JsonHelper {

    public static int TIMEOUT_VALUE = 10000;   // 10초

    public void restCall(String LocalIp, String name, Handler mHandler) throws MalformedURLException {
        String ipAddr = LocalIp;
        String username = name;
        HttpURLConnection urlConnection = null;
        URL url = null;

        url = new URL(ipAddr  + "/" + name);
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            urlConnection = httpsURLConnection;
            try {

                urlConnection.setConnectTimeout(TIMEOUT_VALUE); //Timeout 10seconds
                urlConnection.setReadTimeout(TIMEOUT_VALUE);
            } catch (Exception e) {
                Log.e("TEST!!!! ", "Timeout error");
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
