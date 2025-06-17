package com.progavanzada.tripfighters.figuras;

import android.opengl.GLES20;
import android.opengl.Matrix;

import com.progavanzada.tripfighters.openGLUtil.MyGLRenderer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class Prisma implements Figura {
    private final FloatBuffer vertexBuffer;
    private final int mProgram;
    private int positionHandle, colorHandle, mvpMatrixHandle;

    private final int vertexStride = 3 * 4; // 3 coordenadas * 4 bytes
    private final int vertexCount;

    private final float[] modelMatrix = new float[16];
    private float[] color = {0.5f, 0.8f, 0.2f, 1.0f}; // Verde claro

    // Shaders (igual que en Cilindro)
    private final String vertexShaderCode =
            "uniform mat4 uMVPMatrix;" +
                    "attribute vec4 vPosition;" +
                    "void main() {" +
                    "  gl_Position = uMVPMatrix * vPosition;" +
                    "}";

    private final String fragmentShaderCode =
            "precision mediump float;" +
                    "uniform vec4 vColor;" +
                    "void main() {" +
                    "  gl_FragColor = vColor;" +
                    "}";

    public Prisma(float width, float depth, float height) {
        float w = width / 2;
        float d = depth / 2;
        float h = height / 2;

        float[] vertices = {
                // Cara frontal
                -w, -h,  d,   w, -h,  d,   w,  h,  d,
                -w, -h,  d,   w,  h,  d,  -w,  h,  d,
                // Cara trasera
                -w, -h, -d,  -w,  h, -d,   w,  h, -d,
                -w, -h, -d,   w,  h, -d,   w, -h, -d,
                // Cara izquierda
                -w, -h, -d,  -w, -h,  d,  -w,  h,  d,
                -w, -h, -d,  -w,  h,  d,  -w,  h, -d,
                // Cara derecha
                w, -h, -d,   w,  h, -d,   w,  h,  d,
                w, -h, -d,   w,  h,  d,   w, -h,  d,
                // Cara superior
                -w,  h, -d,  -w,  h,  d,   w,  h,  d,
                -w,  h, -d,   w,  h,  d,   w,  h, -d,
                // Cara inferior
                -w, -h, -d,   w, -h, -d,   w, -h,  d,
                -w, -h, -d,   w, -h,  d,  -w, -h,  d,
        };

        vertexCount = vertices.length / 3;
        vertexBuffer = createFloatBuffer(vertices);

        // Shaders
        int vertexShader = MyGLRenderer.loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        int fragmentShader = MyGLRenderer.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);

        mProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(mProgram, vertexShader);
        GLES20.glAttachShader(mProgram, fragmentShader);
        GLES20.glLinkProgram(mProgram);

        Matrix.setIdentityM(modelMatrix, 0);
    }

    private FloatBuffer createFloatBuffer(float[] vertices) {
        ByteBuffer bb = ByteBuffer.allocateDirect(vertices.length * 4);
        bb.order(ByteOrder.nativeOrder());
        FloatBuffer fb = bb.asFloatBuffer();
        fb.put(vertices);
        fb.position(0);
        return fb;
    }

    public void draw(float[] mvpMatrix) {
        GLES20.glUseProgram(mProgram);

        GLES20.glEnable(GLES20.GL_BLEND);
        GLES20.glBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);

        positionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");
        colorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");
        mvpMatrixHandle = GLES20.glGetUniformLocation(mProgram, "uMVPMatrix");

        float[] finalMVP = new float[16];
        Matrix.multiplyMM(finalMVP, 0, mvpMatrix, 0, modelMatrix, 0);
        GLES20.glUniformMatrix4fv(mvpMatrixHandle, 1, false, finalMVP, 0);

        GLES20.glEnableVertexAttribArray(positionHandle);

        vertexBuffer.position(0);
        GLES20.glVertexAttribPointer(positionHandle, 3, GLES20.GL_FLOAT, false, vertexStride, vertexBuffer);
        GLES20.glUniform4fv(colorHandle, 1, color, 0);
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount);

        GLES20.glDisable(GLES20.GL_BLEND); // Deshabilitar blending después de dibujar las caras

        GLES20.glDisableVertexAttribArray(positionHandle);
    }
    /**
     * Mueve al prisma desde la mitad
     *
     * @param dx translation factor x
     * @param dy translation factor y
     * @param dz translation factor z
     */
    public void move(float dx, float dy, float dz) {
        Matrix.translateM(modelMatrix, 0, dx, dy, dz);
    }

    public void rotate(float angleX, float angleY, float angleZ) {
        float[] rotationMatrix = new float[16];
        Matrix.setIdentityM(rotationMatrix, 0);

        if (angleX != 0) {
            float[] temp = new float[16];
            Matrix.setRotateM(temp, 0, angleX, 1f, 0f, 0f);
            Matrix.multiplyMM(rotationMatrix, 0, temp, 0, rotationMatrix, 0);
        }

        if (angleY != 0) {
            float[] temp = new float[16];
            Matrix.setRotateM(temp, 0, angleY, 0f, 1f, 0f);
            Matrix.multiplyMM(rotationMatrix, 0, temp, 0, rotationMatrix, 0);
        }

        if (angleZ != 0) {
            float[] temp = new float[16];
            Matrix.setRotateM(temp, 0, angleZ, 0f, 0f, 1f);
            Matrix.multiplyMM(rotationMatrix, 0, temp, 0, rotationMatrix, 0);
        }

        float[] result = new float[16];
        Matrix.multiplyMM(result, 0, modelMatrix, 0, rotationMatrix, 0);
        System.arraycopy(result, 0, modelMatrix, 0, 16);
    }

    /**
     * Escalar la figura de manera intuitiva
     * @param sx escalado en x
     * @param sy escalado en y
     * @param sz escalado en z
     */
    public void scale(float sx, float sy, float sz) {
        float[] scaleMatrix = new float[16];
        Matrix.setIdentityM(scaleMatrix, 0); // Iniciar con matriz identidad
        Matrix.scaleM(scaleMatrix, 0, sx, sy, sz); // Aplicar escalado

        float[] result = new float[16];
        Matrix.multiplyMM(result, 0, modelMatrix, 0, scaleMatrix, 0); // modelMatrix * scaleMatrix
        System.arraycopy(result, 0, modelMatrix, 0, 16); // Actualizar modelMatrix
    }

    public void setColor(float[] rgba) {
        if (rgba != null && rgba.length == 4)
            this.color = rgba.clone();
    }
}