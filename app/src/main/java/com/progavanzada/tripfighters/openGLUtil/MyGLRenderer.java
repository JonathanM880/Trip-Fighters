package com.progavanzada.tripfighters.openGLUtil;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;


import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.modelos.escenas.SalaDeOro;
import com.progavanzada.tripfighters.modelos.personajesJugables.ChicoCubo;
import com.progavanzada.tripfighters.modelos.villanos.Bestia;
import com.progavanzada.tripfighters.modelos.villanos.Cactus;
import com.progavanzada.tripfighters.modelos.villanos.Cleopatra;
import com.progavanzada.tripfighters.modelos.villanos.Herobrine;
import com.progavanzada.tripfighters.modelos.villanos.Jack;
import com.progavanzada.tripfighters.modelos.villanos.Kira;
import com.progavanzada.tripfighters.modelos.villanos.Payaso;
import com.progavanzada.tripfighters.modelos.villanos.Raton;
import com.progavanzada.tripfighters.modelos.villanos.Robot;
import com.progavanzada.tripfighters.modelos.villanos.Trump;

import java.util.Arrays;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MyGLRenderer implements GLSurfaceView.Renderer {

    private final float[] mProjectionMatrix = new float[16];
    private final float[] mViewMatrix = new float[16];
    private final float[] mVPMatrix = new float[16];
    private final float[] mHeroeVPMatrix = new float[16];
    private final float[] mVillanoVPMatrix = new float[16];
    private float heroAngle = 0f;
    private float villainAngle = 0f;
    private float escenarioAngle = 0f;

    private int screenWidth;
    private int screenHeight;

    private Trump trump;
    private ChicoCubo chicoCubo;
    private SalaDeOro salaDeOro;
    private Cactus cactus;
    private Robot robot;
    private Payaso payaso;
    private Jack jack;
    private Bestia bestia;
    private Herobrine herobrine;
    private Raton raton;
    private Kira kira;
    private Cleopatra cleopatra;
    //Apreciar 3d
    private float angle = 0.0f;
    private int villanoActual = 0;

    public void setVillano(int index) {
        villanoActual = index;
    }

    private int heroeActual = 0;

    public void setHeroe(int index) {
        heroeActual = index;
    }

    private int escenarioActual = 0;

    public void setEscenario(int index) {
        this.escenarioActual = index;
    }


    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);

        chicoCubo = new ChicoCubo();
        salaDeOro = new SalaDeOro();
        cactus = new Cactus();
        robot = new Robot();
        payaso = new Payaso();
        jack = new Jack();
        bestia = new Bestia();
        herobrine = new Herobrine();
        raton = new Raton();
        kira = new Kira();
        trump = new Trump();
        cleopatra = new Cleopatra();
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        GLES20.glClearColor(0.455f, 0.592f, 0.71f, 1.0f);
        GLES20.glEnable(GLES20.GL_DEPTH_TEST); // ¡Habilita el test de profundidad!

        screenWidth = width;
        screenHeight = height;
        GLES20.glViewport(0, 0, width, height);

        float ratio = (float) width / height;
        Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 1, 15);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        //PARA QUE VEAN COMO SE DIBUJA EN 3D, ROTAR CAMARA

        angle += 1f; // ajusta la velocidad
        if (angle > 360) angle -= 360;

        float radius = 8f;
        float camX = (float) (Math.sin(Math.toRadians(angle)) * radius);
        float camZ = (float) (Math.cos(Math.toRadians(angle)) * radius);
        float camY = 1f; // Altura de la cámara

        // La cámara orbita alrededor del punto (0, 0.5, 0)
        Matrix.setLookAtM(
                mViewMatrix, 0,
                0, 0, -6,  // posición de la cámara
                0.0f, 0f, 0.0f,  // punto al que mira (centro de la escena)
                0.0f, 1.0f, 0.0f   // up vector
        );

        Matrix.multiplyMM(mVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);

        //cleopatra.draw(mVPMatrix);

        //chicoCubo.draw(mVPMatrix);

        //salaDeOro.draw(mVPMatrix);

        //villanos

        //cactus.draw(mVPMatrix);
        //robot.draw(mVPMatrix);
        //payaso.draw(mVPMatrix);
        //jack.draw(mVPMatrix);
        //herobrine.draw(mVPMatrix);
        //raton.draw(mVPMatrix);
        bestia.draw(mVPMatrix);
        //kira.draw(mVPMatrix);
        //trump.draw(mVPMatrix);

        /*
        heroAngle += 1.5f;
        villainAngle += 1.5f;
        escenarioAngle += 1.5f;

        float[] viewMatrix = new float[16];
        Matrix.setLookAtM(viewMatrix, 0, 0, .5f, 6, 0, 0, 0, 0, 1, 0);

        float[] viewProjectionMatrix = new float[16];
        Matrix.multiplyMM(viewProjectionMatrix, 0, mProjectionMatrix, 0, viewMatrix, 0);

        // === ESCENARIO ===
        if (modoSeleccionEscenario) {
            GLES20.glViewport(0, 0, screenWidth, screenHeight); // pantalla completa

            float[] modelEscenario = new float[16];
            float[] mvpEscenario = new float[16];

            Matrix.setIdentityM(modelEscenario, 0);
            Matrix.rotateM(modelEscenario, 0, escenarioAngle, 0f, 1f, 0f);
            Matrix.multiplyMM(mvpEscenario, 0, viewProjectionMatrix, 0, modelEscenario, 0);

            switch (escenarioActual) {
                case 0:
                    salaDeOro.draw(mvpEscenario);
                    break;
                // más escenarios si tienes
            }

            return;
        }

        // === HEROE (parte superior) ===
        GLES20.glViewport(0, screenHeight / 2, screenWidth, screenHeight / 2);

        float[] modelHeroe = new float[16];
        float[] mvpHeroe = new float[16];
        Matrix.setIdentityM(modelHeroe, 0);
        Matrix.translateM(modelHeroe, 0, 0f, 0f, -2f);
        Matrix.rotateM(modelHeroe, 0, heroAngle, 0f, 1f, 0f);
        Matrix.translateM(modelHeroe, 0, 0f, 0f, 2f);
        Matrix.multiplyMM(mvpHeroe, 0, viewProjectionMatrix, 0, modelHeroe, 0);

        switch (heroeActual) {
            case 0: chicoCubo.draw(mvpHeroe); break;
            case 1: salaDeOro.draw(mvpHeroe); break;
        }

        // === VILLANO (parte inferior) ===
        GLES20.glViewport(0, 0, screenWidth, screenHeight / 2);

        float[] modelVillano = new float[16];
        float[] mvpVillano = new float[16];
        Matrix.setIdentityM(modelVillano, 0);
        Matrix.translateM(modelVillano, 0, 0f, 0f, 2f);
        Matrix.rotateM(modelVillano, 0, villainAngle, 0f, 1f, 0f);
        Matrix.translateM(modelVillano, 0, 0f, 0f, -2f);
        Matrix.multiplyMM(mvpVillano, 0, viewProjectionMatrix, 0, modelVillano, 0);

        switch (villanoActual) {
            case 0: cactus.draw(mvpVillano); break;
            case 1: robot.draw(mvpVillano); break;
            case 2: payaso.draw(mvpVillano); break;
            case 3: jack.draw(mvpVillano); break;
            case 4: herobrine.draw(mvpVillano); break;
            case 5: raton.draw(mvpVillano); break;
            case 6: bestia.draw(mvpVillano); break;
            case 7: kira.draw(mvpVillano); break;
            case 8: trump.draw(mvpVillano); break;
            case 9: cleopatra.draw(mvpVillano); break;
        }

*/
    }

    private boolean modoSeleccionEscenario = false;

    public void setModoSeleccionEscenario(boolean valor) {
        this.modoSeleccionEscenario = valor;
    }


    public static int loadShader(int type, String shaderCode) {
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }
}
