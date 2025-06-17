package com.progavanzada.tripfighters.openGLUtil;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;


import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.modelos.escenas.SalaDeOro;
import com.progavanzada.tripfighters.modelos.personajesJugables.ChicoCubo;
import com.progavanzada.tripfighters.modelos.villanos.Cactus;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MyGLRenderer implements GLSurfaceView.Renderer {

    private final float[] mProjectionMatrix = new float[16];
    private final float[] mViewMatrix = new float[16];
    private final float[] mVPMatrix = new float[16];

    private ChicoCubo chicoCubo;
    private SalaDeOro salaDeOro;
    private Cactus cactus;

    //Apreciar 3d
    private float angle = 0.0f;


    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);

        chicoCubo= new ChicoCubo();
        salaDeOro= new SalaDeOro();
        cactus= new Cactus();
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        GLES20.glClearColor(0.455f, 0.592f, 0.71f, 1.0f);
        GLES20.glEnable(GLES20.GL_DEPTH_TEST); // ¡Habilita el test de profundidad!

        GLES20.glViewport(0, 0, width, height);

        float ratio = (float) width / height;
        Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 1, 10);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        angle += 0.5f; // ajusta la velocidad
        if (angle > 360) angle -= 360;

        float radius = 3.0f;
        float camX = (float) (Math.sin(Math.toRadians(angle)) * radius);
        float camZ = (float) (Math.cos(Math.toRadians(angle)) * radius);
        float camY = 1.5f; // Altura de la cámara

        // La cámara orbita alrededor del punto (0, 0.5, 0)
        Matrix.setLookAtM(
                mViewMatrix, 0,
                camX, camY, camZ,  // posición de la cámara
                0.0f, 0f, 0.0f,  // punto al que mira (centro de la escena)
                0.0f, 1.0f, 0.0f   // up vector
        );

        Matrix.multiplyMM(mVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);


        chicoCubo.draw(mVPMatrix);

        salaDeOro.draw(mVPMatrix);

        cactus.draw(mVPMatrix);
    }

    public static int loadShader(int type, String shaderCode) {
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }
}
