package com.example.vocales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

public class Letra_O extends AppCompatActivity {
    MediaPlayer Mo;
    ImageButton O;
    ImageButton SiguienteO;
    ImageButton AtrasO;
    ImageButton InicioO;
    MediaPlayer fondoO;
    public static int MILISEGUNDOS_ESPERA = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letra_o);
        Mo = MediaPlayer.create(getApplicationContext(),R.raw.o);
        O = (ImageButton) findViewById(R.id.ImgBO);
        fondoO = MediaPlayer.create(getApplicationContext(),R.raw.fondoapp);
        fondoO.start();
        O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fondoO.stop();
                Mo.start();
                esperarYReproducir(MILISEGUNDOS_ESPERA);
            }
        });

        SiguienteO = (ImageButton) findViewById(R.id.ImgSiguienteO);
        SiguienteO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LetraU = new Intent(getApplicationContext(), Letra_U.class);
                startActivity(LetraU);
                fondoO.stop();
            }
        });

        AtrasO = (ImageButton) findViewById(R.id.ImgAtrasO);
        AtrasO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LetraI = new Intent(getApplicationContext(), Letra_I.class);
                startActivity(LetraI);
                fondoO.stop();
            }
        });

        InicioO = (ImageButton) findViewById(R.id.ImgInicioO);
        InicioO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Inicio = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(Inicio);
                fondoO.stop();
            }
        });

    }
    public void esperarYReproducir(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                fondoO = MediaPlayer.create(getApplicationContext(),R.raw.fondoapp);
                fondoO.start();
            }
        }, milisegundos);
    }
}