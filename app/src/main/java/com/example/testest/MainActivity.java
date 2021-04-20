package com.example.testest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try{

                    URL url = new URL("https://api.github.com");
                    HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
                    conn.setRequestProperty("User-Agent", "rest-api-v1");
                    if (conn.getResponseCode() == 200){
                        TextView test = (TextView)findViewById(R.id.test);
                        test.setText("Success!");
                    } else{
                        TextView test = (TextView)findViewById(R.id.test);
                        test.setText("Nope");
                    }

                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }; thread.start();
    }
}