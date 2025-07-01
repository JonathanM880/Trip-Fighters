package com.progavanzada.tripfighters;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.progavanzada.tripfighters.openGLUtil.MyGLSurfaceView;


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
            String mensajeAyuda = "<b><font color='#2196F3'>JUGAR:</font></b> este botón le llevará al apartado de selección de personaje, donde podrá escoger a un héroe (jugador) y un jefe (CPU). " +
                    "Una vez elegido, debe presionar el botón SIGUIENTE. Posteriormente se le pedirá elegir un escenario donde se llevará a cabo la pelea. " +
                    "Una vez elija todo esto, deberá presionar el botón BATALLA para empezar a jugar.<br><br>" +
                    "<b><font color='#4CAF50'>AYUDA:</font></b> este botón le ofrecerá una pequeña guía del juego. Si desea volver a ver este mensaje, presione de nuevo el botón AYUDA.<br><br>" +
                    "<b><font color='#F44336'>SALIR:</font></b> este botón le permitirá salir del juego en caso de que esté bien aburrido, <i>PERDÓN :(</i>";

            new AlertDialog.Builder(this)
                    .setTitle("Guía del Juego")
                    .setMessage(Html.fromHtml(mensajeAyuda, Html.FROM_HTML_MODE_LEGACY))
                    .setPositiveButton("Aceptar", null)
                    .show();
        });

        btnExit.setOnClickListener(v -> finish());
    }
}


/*

public class MainActivity extends AppCompatActivity {

    private MyGLSurfaceView glSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new MyGLSurfaceView(this);
        setContentView(glSurfaceView);
    }
}
*/



