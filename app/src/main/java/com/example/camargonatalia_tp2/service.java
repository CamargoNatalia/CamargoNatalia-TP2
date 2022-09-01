package com.example.camargonatalia_tp2;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class service extends Service {
    public service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static int bandera = 1;
    Thread tarea;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("salida", " iniciado");

        bandera = 1;
        tarea = new Thread((new Cuenta()));
        tarea.start();
        return START_NOT_STICKY;

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        bandera=0;
        tarea = null;

        Log.d("salida", "Servicio destruido");
    }

    private class Cuenta implements Runnable {
        public void run() {
            long contador = 0;
            while (bandera == 1) {
                contador++;
                    try {
                        Thread.sleep(9000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d("salida",  "mensaje");
                }
            }
        }
    }


