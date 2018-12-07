package com.example.mauriziosalini.tcpvalues;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client extends AsyncTask<Void, Double, Double> {

    Socket s;
    DataInputStream dis;
    InputStream is;
    TextView textView;

    String server;
    int port;
    double speed;


    public Client(String server, int port, TextView textView){
        this.server = server;
        this.port = port;
        this.textView = textView;
    }



    @Override
    protected Double doInBackground(Void... voids) {
        try {
            s = new Socket(server, port);
            is = s.getInputStream();
            dis = new DataInputStream(is);

            while (s.isConnected()){
                speed = dis.readDouble();
                speed = Math.round(speed);
                Log.i("Speed", Double.toString(speed));
                //intent.putExtra("Speed", speed);
                publishProgress(speed);

            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Double ... speed){
        super.onProgressUpdate(speed);
        textView.setText(Double.toString(speed[0]));


    }


}
