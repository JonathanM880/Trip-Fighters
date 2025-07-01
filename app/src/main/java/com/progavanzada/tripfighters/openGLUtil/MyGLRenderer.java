package com.progavanzada.tripfighters.openGLUtil;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;


import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.modelos.escenas.ArenaInfierno;
import com.progavanzada.tripfighters.modelos.escenas.ArenaLegendaria;
import com.progavanzada.tripfighters.modelos.escenas.SalaDeOro;
import com.progavanzada.tripfighters.modelos.personajesJugables.ChicaCubo;
import com.progavanzada.tripfighters.modelos.personajesJugables.ChicaRubia;
import com.progavanzada.tripfighters.modelos.personajesJugables.ChicoCubo;
import com.progavanzada.tripfighters.modelos.personajesJugables.ChicoGamer;
import com.progavanzada.tripfighters.modelos.personajesJugables.Mateo;
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
    private float angle =0.0f;
    private float heroAngle = 0f;
    private float villainAngle = 0f;
    private float escenarioAngle = 0f;
    private int screenWidth;
    private int screenHeight;

    //HEROES
    private ChicaCubo chicaCubo;
    private ChicaRubia chicaRubia;
    private ChicoGamer chicoGamer;
    private Mateo mateo;
    private ChicoCubo chicoCubo;
    //VILLANOS
    private Trump trump;
    private Cactus cactus;
    private Robot robot;
    private Payaso payaso;
    private Jack jack;
    private Bestia bestia;
    private Herobrine herobrine;
    private Raton raton;
    private Kira kira;
    private Cleopatra cleopatra;

    //ESCENARIOS

    private SalaDeOro salaDeOro;
    private ArenaInfierno arenaInfierno;
    private ArenaLegendaria arenaLegendaria;


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

    private boolean modoBatalla = false;

    public void setModoBatalla(boolean valor) {
        this.modoBatalla = valor;
    }


    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);
        //HEROES
        chicoCubo = new ChicoCubo();
        chicaCubo = new ChicaCubo();
        chicaRubia = new ChicaRubia();
        chicoGamer = new ChicoGamer();
        mateo = new Mateo();
        //VILLANOS
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
        //ESCENARIOS
        salaDeOro = new SalaDeOro();
        arenaInfierno = new ArenaInfierno();
        arenaLegendaria = new ArenaLegendaria();
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        GLES20.glClearColor(0.455f, 0.592f, 0.71f, 1.0f);
        GLES20.glEnable(GLES20.GL_DEPTH_TEST); // ¡Habilita el test de profundidad!

        screenWidth = width;
        screenHeight = height;
        GLES20.glViewport(0, 0, width, height);

        float ratio = (float) width / height;
        Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 1, 25);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        // ESTO ES SOLO PARA LA BATTLE ACTIVITY (DAVID)

        // === MATRICES DE VISTA Y PROYECCIÓN ===
        float[] viewM = new float[16];
        float[] viewProjectionM = new float[16];

// === CÁMARA ORBITAL ===
        angle += .77f; // ajusta la velocidad de rotación
        if (angle > 360) angle -= 360;

        float radius = 10f;
        float camX = (float) (Math.sin(Math.toRadians(angle)) * radius);
        float camZ = (float) (Math.cos(Math.toRadians(angle)) * radius);
        float camY = 1f; // Altura de la cámara

        Matrix.setLookAtM(viewM, 0,
                camX, camY, camZ,   // posición de la cámara
                0f, 0.5f, 0f,       // punto al que mira (centro de la escena)
                0f, 1f, 0f          // vector "up"
        );

        Matrix.multiplyMM(viewProjectionM, 0, mProjectionMatrix, 0, viewM, 0);

// === MODO BATALLA ===
        if (modoBatalla) {
            GLES20.glViewport(0, 0, screenWidth, screenHeight); // pantalla completa

            // === ESCENARIO ===
            float[] modelEscenario = new float[16];
            float[] mvpEscenario = new float[16];
            Matrix.setIdentityM(modelEscenario, 0);
            Matrix.multiplyMM(mvpEscenario, 0, viewProjectionM, 0, modelEscenario, 0);

            switch (escenarioActual) {
                case 0: salaDeOro.draw(mvpEscenario); break;
                case 1: arenaInfierno.draw(mvpEscenario); break;
                case 2: arenaLegendaria.draw(mvpEscenario); break;
            }

            // === HEROE ===
            float[] modelHeroe = new float[16];
            float[] mvpHeroe = new float[16];
            Matrix.setIdentityM(modelHeroe, 0);
            Matrix.translateM(modelHeroe, 0, 0f, 0f, -2f); // donde suelen estar los héroes
            Matrix.multiplyMM(mvpHeroe, 0, viewProjectionM, 0, modelHeroe, 0);

            switch (heroeActual) {
                case 0: chicoCubo.draw(mvpHeroe); break;
                case 1: chicaCubo.draw(mvpHeroe); break;
                case 2: chicaRubia.draw(mvpHeroe); break;
                case 3: mateo.draw(mvpHeroe); break;
                case 4: chicoGamer.draw(mvpHeroe); break;
            }

            // === VILLANO ===
            float[] modelVillano = new float[16];
            float[] mvpVillano = new float[16];
            Matrix.setIdentityM(modelVillano, 0);
            Matrix.translateM(modelVillano, 0, 0f, 0f, 2f); // donde suelen estar los villanos
            Matrix.multiplyMM(mvpVillano, 0, viewProjectionM, 0, modelVillano, 0);

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

            return; // ✅ ¡IMPORTANTE! No sigas con el otro dibujo
        }



        //hasta aqui va tu parte DAVID

        heroAngle += 1.5f;
        villainAngle += 1.5f;
        escenarioAngle += 1.5f;

        // TODO LO DE SELECCION DE ESCENARIO
        float[] viewMatrixEscenario = new float[16];
        Matrix.setLookAtM(viewMatrixEscenario, 0, 0, .5f, 16, 0, 0, 0, 0, 1, 0);

        float[] viewProjectionMatrixEscenario = new float[16];
        Matrix.multiplyMM(viewProjectionMatrixEscenario, 0, mProjectionMatrix, 0, viewMatrixEscenario, 0);

        // === ESCENARIO ===
        if (modoSeleccionEscenario) {
            GLES20.glViewport(0, 0, screenWidth, screenHeight); // pantalla completa

            float[] modelEscenario = new float[16];
            float[] mvpEscenario = new float[16];

            Matrix.setIdentityM(modelEscenario, 0);
            Matrix.rotateM(modelEscenario, 0, escenarioAngle, 0f, 1f, 0f);
            Matrix.multiplyMM(mvpEscenario, 0, viewProjectionMatrixEscenario, 0, modelEscenario, 0);

            switch (escenarioActual) {
                case 0: salaDeOro.draw(mvpEscenario); break;
                case 1: arenaInfierno.draw(mvpEscenario); break;
                case 2: arenaLegendaria.draw(mvpEscenario); break;
            }

            return;
        }

        // TODO LO DE SELECCION DE PERSONAJES
        float[] viewMatrix = new float[16];
        Matrix.setLookAtM(viewMatrix, 0, 0, .2f, 7, 0, 0, 0, 0, 1, 0);

        float[] viewProjectionMatrix = new float[16];
        Matrix.multiplyMM(viewProjectionMatrix, 0, mProjectionMatrix, 0, viewMatrix, 0);


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
            case 1: chicaCubo.draw(mvpHeroe); break;
            case 2: chicaRubia.draw(mvpHeroe); break;
            case 3: mateo.draw(mvpHeroe); break;
            case 4: chicoGamer.draw(mvpHeroe); break;

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
