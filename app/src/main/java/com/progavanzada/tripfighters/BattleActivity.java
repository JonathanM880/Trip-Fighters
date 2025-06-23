package com.progavanzada.tripfighters;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.progavanzada.tripfighters.openGLUtil.MyGLSurfaceView;

public class BattleActivity extends AppCompatActivity {

    private MyGLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obtener héroe y villano correctamente
        int villano = getIntent().getIntExtra("villano", 0);
        int heroe = getIntent().getIntExtra("heroe", 0);
        int escenario = getIntent().getIntExtra("escenario", 0);

        // Crear el SurfaceView y pasar ambos
        glSurfaceView = new MyGLSurfaceView(this);
        glSurfaceView.setVillano(villano);
        glSurfaceView.setHeroe(heroe);
        glSurfaceView.setEscenario(escenario);

        setContentView(glSurfaceView);
    }
}


