package com.progavanzada.tripfighters;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.progavanzada.tripfighters.openGLUtil.MyGLSurfaceView;

public class CharacterSelectionActivity extends AppCompatActivity {

    private MyGLSurfaceView glSurfaceView;
    private Button btnFlecha, btnSiguiente;
    private int villanoActual = 0;
    private Button btnHeroe;
    private int heroeActual = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection); // Usa el layout con FrameLayout

        glSurfaceView = findViewById(R.id.gl_surface);
        btnFlecha = findViewById(R.id.btn_siguiente);
        btnSiguiente = findViewById(R.id.btn_batalla);

        btnFlecha.setOnClickListener(v -> {
            villanoActual = (villanoActual + 1) % 10; // Cambia entre 9 personajes
            glSurfaceView.setVillano(villanoActual); // Método que debes implementar
        });

        btnSiguiente.setOnClickListener(v -> {
            Intent intent = new Intent(this, BattleActivity.class);
            intent.putExtra("personaje", villanoActual);
            startActivity(intent);
        });

        btnHeroe = findViewById(R.id.btn_heroe);

        btnHeroe.setOnClickListener(v -> {
            heroeActual = (heroeActual + 1) % 3; // Supongamos que tienes 3 héroes
            glSurfaceView.setHeroe(heroeActual);
        });

        btnSiguiente.setOnClickListener(v -> {
            Intent intent = new Intent(this, EscenarioActivity.class);
            intent.putExtra("villano", villanoActual);
            intent.putExtra("heroe", heroeActual);
            startActivity(intent);
        });


    }
}

