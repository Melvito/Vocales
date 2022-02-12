package com.example.vocales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;



public class Letra_A extends AppCompatActivity {

    ImageButton letraA;
    MediaPlayer letra;
    ImageButton atrasA;
    ImageButton Siguiente;
    ImageButton inicioA;
    MediaPlayer fondoA;
    public static int MILISEGUNDOS_ESPERA = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letra);
        letra = MediaPlayer.create(getApplicationContext(),R.raw.a);
        letraA = (ImageButton) findViewById(R.id.ImgBA);
        fondoA = MediaPlayer.create(getApplicationContext(),R.raw.fondoapp);
        fondoA.start();
        letraA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fondoA.stop();
                letra.start();
                esperarYReproducir(MILISEGUNDOS_ESPERA);

            }
        });
        atrasA = (ImageButton) findViewById(R.id.ImgAtrasA);
        atrasA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Atras = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Atras);
                fondoA.stop();
            }
        });
        Siguiente = (ImageButton) findViewById(R.id.ImgSiguienteA);
        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(getApplicationContext(), Letra_E.class);
                startActivity(siguiente);
                fondoA.stop();
            }
        });
        inicioA = (ImageButton) findViewById(R.id.ImgInicioA);
        inicioA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Inicio = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(Inicio);
                fondoA.stop();
            }
        });

    }
    public void esperarYReproducir(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                fondoA= MediaPlayer.create(getApplicationContext(),R.raw.fondoapp);
                fondoA.start();
            }
        }, milisegundos);
    }

}