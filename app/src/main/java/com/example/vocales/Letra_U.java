package com.example.vocales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

public class Letra_U extends AppCompatActivity {
    MediaPlayer Mu;
    ImageButton U;
    ImageButton VolverU;
    ImageButton AtrasU;
    MediaPlayer fondoU;
    public static int MILISEGUNDOS_ESPERA = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letra_u);
        Mu = MediaPlayer.create(getApplicationContext(),R.raw.u);
        U = (ImageButton) findViewById(R.id.ImgBU);
        fondoU = MediaPlayer.create(getApplicationContext(),R.raw.fondoapp);
        fondoU.stop();
        U.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fondoU.stop();
                Mu.start();
                esperarYReproducir(MILISEGUNDOS_ESPERA);
            }
        });

        VolverU = (ImageButton) findViewById(R.id.ImgVolverU);
        VolverU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Inicio = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Inicio);
                fondoU.stop();
            }
        });
       AtrasU = (ImageButton) findViewById(R.id.ImgAtrasU);
       AtrasU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AtrasU = new Intent(getApplicationContext(), Letra_O.class);
                startActivity(AtrasU);

            }
        });
    }
    public void esperarYReproducir(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                fondoU = MediaPlayer.create(getApplicationContext(),R.raw.fondoapp);
                fondoU.start();
            }
        }, milisegundos);
    }
}