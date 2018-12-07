package com.example.mauriziosalini.tcpvalues;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPThread extends Thread {

    Socket s;
    DataInputStream dis;
    InputStream is;

    String server;
    int port;
    double speed;


    public TCPThread(String server, int port) throws IOException {
        this.server = server;
        this.port = port;
    }


    public void run(){
        try {
            s = new Socket(server, port);
            is = s.getInputStream();
            dis = new DataInputStream(is);

            while (s.isConnected()){
                speed = dis.readDouble();
                Log.i("Speed", Double.toString(speed));

                //intent.putExtra("Speed", speed);

            }

        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
