package com.progavanzada.tripfighters;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.progavanzada.tripfighters.openGLUtil.MyGLSurfaceView;
/*

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu); // Carga el layout XML

        Button btnPlay = findViewById(R.id.btnPlay);
        Button btnHelp = findViewById(R.id.btnAjustes); // o btnHelp si cambiaste el ID
        Button btnExit = findViewById(R.id.btnSalir);

        btnPlay.setOnClickListener(v -> {
            Intent intent = new Intent(this, CharacterSelectionActivity.class);
            startActivity(intent);
        });

        btnHelp.setOnClickListener(v -> {
            Toast.makeText(this, "Mensajito de ayuda xd", Toast.LENGTH_SHORT).show();
        });

        btnExit.setOnClickListener(v -> finish());
    }
}

*/

public class MainActivity extends AppCompatActivity {

    private MyGLSurfaceView glSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new MyGLSurfaceView(this);
        setContentView(glSurfaceView);
    }
}




