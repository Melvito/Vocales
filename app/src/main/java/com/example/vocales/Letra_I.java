package com.example.vocales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

public class Letra_I extends AppCompatActivity {
    MediaPlayer Mi;
    ImageButton I;
    ImageButton SiguienteI;
    ImageButton AtrasI;
    ImageButton InicioI;
    MediaPlayer fondoI;
    public static int MILISEGUNDOS_ESPERA = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letra_i);
        Mi = MediaPlayer.create(getApplicationContext(),R.raw.i);
        I = (ImageButton) findViewById(R.id.ImgBI);
        fondoI = MediaPlayer.create(getApplicationContext(),R.raw.fondoapp);
        fondoI.start();
        I.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fondoI.stop();
                Mi.start();
                esperarYReproducir(MILISEGUNDOS_ESPERA);
            }
        });

        SiguienteI = (ImageButton) findViewById(R.id.ImgSiguienteI);
        SiguienteI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LetraO = new Intent(getApplicationContext(), Letra_O.class);
                startActivity(LetraO);
                fondoI.stop();
            }
        });

        AtrasI = (ImageButton) findViewById(R.id.ImgAtrasI);
        AtrasI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LetraE = new Intent(getApplicationContext(), Letra_E.class);
                startActivity(LetraE);
                fondoI.stop();
            }
        });

        InicioI = (ImageButton) findViewById(R.id.ImgInicioI);
        InicioI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Inicio = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(Inicio);
                fondoI.stop();
            }
        });

    }
    public void esperarYReproducir(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                fondoI = MediaPlayer.create(getApplicationContext(),R.raw.fondoapp);
                fondoI.start();
            }
        }, milisegundos);
    }
}