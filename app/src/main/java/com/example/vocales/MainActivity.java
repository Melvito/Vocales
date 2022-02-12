package com.example.vocales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton comienzo;
    MediaPlayer fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fondo = MediaPlayer.create(getApplicationContext(),R.raw.fondoapp);
        comienzo = (ImageButton) findViewById(R.id.ImgBComenzar);
        fondo.start();
        comienzo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent LetraA = new Intent(getApplicationContext(), Letra_A.class);
                startActivity(LetraA);
                fondo.stop();
            }
        });

    }
}