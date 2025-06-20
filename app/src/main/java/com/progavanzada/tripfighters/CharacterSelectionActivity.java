package com.progavanzada.tripfighters;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.progavanzada.tripfighters.modelos.villanos.BattleActivity;
import com.progavanzada.tripfighters.openGLUtil.MyGLSurfaceView;

public class CharacterSelectionActivity extends AppCompatActivity {

    private MyGLSurfaceView glSurfaceView;
    private Button btnSiguiente, btnBatalla;
    private int personajeActual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection); // Usa el layout con FrameLayout

        glSurfaceView = findViewById(R.id.gl_surface);
        btnSiguiente = findViewById(R.id.btn_siguiente);
        btnBatalla = findViewById(R.id.btn_batalla);

        btnSiguiente.setOnClickListener(v -> {
            personajeActual = (personajeActual + 1) % 3; // Cambia entre 3 personajes
            glSurfaceView.setPersonaje(personajeActual); // Método que debes implementar
        });

        btnBatalla.setOnClickListener(v -> {
            Intent intent = new Intent(this, BattleActivity.class);
            intent.putExtra("personaje", personajeActual);
            startActivity(intent);
        });
    }
}

