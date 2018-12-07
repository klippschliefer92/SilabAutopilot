package com.example.mauriziosalini.tcpvalues;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {



    public TextView speedText;
    String server = "192.168.2.105";
    int port = 25143;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speedText = (TextView)findViewById(R.id.textView);

        }



    public void connect(View view) {
        Client client = new Client(server, port, speedText);
        client.execute();

    }


}
