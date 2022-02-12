package com.example.vocales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

public class Letra_E extends AppCompatActivity {
    MediaPlayer Me;
    ImageButton E;
    ImageButton SiguienteE;
    ImageButton AtrasE;
    ImageButton InicioE;
    MediaPlayer fondoE;
    public static int MILISEGUNDOS_ESPERA = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letra_e);
        fondoE = MediaPlayer.create(getApplicationContext(),R.raw.fondoapp);
        fondoE.start();
        Me = MediaPlayer.create(getApplicationContext(),R.raw.e);
        E = (ImageButton) findViewById(R.id.ImgBE);
        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fondoE.stop();
                Me.start();
                esperarYReproducir(MILISEGUNDOS_ESPERA);
            }
        });

        SiguienteE = (ImageButton) findViewById(R.id.ImgBSiguienteE);
        SiguienteE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LetraI = new Intent(getApplicationContext(), Letra_I.class);
                startActivity(LetraI);
                fondoE.stop();
            }
        });

        AtrasE = (ImageButton) findViewById(R.id.ImgAtrasE);
        AtrasE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LetraA = new Intent(getApplicationContext(), Letra_A.class);
                startActivity(LetraA);
                fondoE.stop();
            }
        });

        InicioE = (ImageButton) findViewById(R.id.ImgInicioE);
        InicioE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Inicio = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(Inicio);
                fondoE.stop();
            }
        });

    }
    public void esperarYReproducir(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                fondoE = MediaPlayer.create(getApplicationContext(),R.raw.fondoapp);
                fondoE.start();
            }
        }, milisegundos);
    }
}