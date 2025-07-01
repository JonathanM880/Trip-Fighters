package com.progavanzada.tripfighters;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.progavanzada.tripfighters.openGLUtil.MyGLSurfaceView;

public class BattleActivity extends AppCompatActivity {

    private MyGLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle); // 👈 usa el layout

        glSurfaceView = findViewById(R.id.myGLSurfaceViewBattle); // 👈 lo buscas por ID

        int villano = getIntent().getIntExtra("villano", 0);
        int heroe = getIntent().getIntExtra("heroe", 0);
        int escenario = getIntent().getIntExtra("escenario", 0);
        glSurfaceView.setModoBatalla(true);

        glSurfaceView.setHeroe(heroe);
        glSurfaceView.setVillano(villano);
        glSurfaceView.setEscenario(escenario);

    }

}


