package com.progavanzada.tripfighters.modelos.villanos;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.progavanzada.tripfighters.openGLUtil.MyGLSurfaceView;

public class BattleActivity extends AppCompatActivity {

    private MyGLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int personaje = getIntent().getIntExtra("personaje", 0);

        glSurfaceView = new MyGLSurfaceView(this);
        glSurfaceView.setPersonaje(personaje);

        setContentView(glSurfaceView);
    }
}

