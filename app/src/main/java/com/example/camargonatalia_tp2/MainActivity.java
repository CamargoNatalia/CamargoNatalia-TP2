package com.example.camargonatalia_tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnIniciar, btnParar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVista();
    }

    private void inicializarVista(){
        Intent i =new Intent(MainActivity.this, service.class);
        btnIniciar=findViewById(R.id.btnIniciar);
        btnParar=findViewById(R.id.btnParar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startService(i);
            }
        });
        btnParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopService(i);
            }
        });
    }
}