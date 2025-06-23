package com.progavanzada.tripfighters;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.progavanzada.tripfighters.openGLUtil.MyGLSurfaceView;

public class EscenarioActivity extends AppCompatActivity {
    private MyGLSurfaceView glSurfaceView;
    private int escenarioActual = 0;
    private final int TOTAL_ESCENARIOS = 3; // o los que tengas
    private int heroe, villano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        heroe = getIntent().getIntExtra("heroe", 0);
        villano = getIntent().getIntExtra("villano", 0);

        setContentView(R.layout.activity_escenario);

        glSurfaceView = findViewById(R.id.myGLSurfaceViewEscenario);
        glSurfaceView.setModoSeleccionEscenario(true);
        glSurfaceView.setEscenario(escenarioActual);

        findViewById(R.id.btnSiguienteEscenario).setOnClickListener(v -> {
            escenarioActual = (escenarioActual + 1) % TOTAL_ESCENARIOS;
            glSurfaceView.setEscenario(escenarioActual);
        });

        findViewById(R.id.btnBatalla).setOnClickListener(v -> {
            Intent intent = new Intent(this, BattleActivity.class);
            intent.putExtra("heroe", heroe);
            intent.putExtra("villano", villano);
            intent.putExtra("escenario", escenarioActual);
            startActivity(intent);
        });
    }
}

