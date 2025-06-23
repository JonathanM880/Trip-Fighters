package com.progavanzada.tripfighters.openGLUtil;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class MyGLSurfaceView extends GLSurfaceView {

    private MyGLRenderer renderer;

    public MyGLSurfaceView(Context context) {
        super(context);

        setEGLContextClientVersion(2);

        renderer = new MyGLRenderer();
        setRenderer(renderer);

    }

    public MyGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        setEGLContextClientVersion(2);
        renderer = new MyGLRenderer();
        setRenderer(renderer);
        setRenderMode(RENDERMODE_CONTINUOUSLY);
    }

    public void setVillano(int index) {
        renderer.setVillano(index);
        requestRender();
    }

    public void setHeroe(int index) {
        renderer.setHeroe(index);
        requestRender();
    }

    public void setEscenario(int index) {
        renderer.setEscenario(index);
        requestRender();
    }

    public void setModoSeleccionEscenario(boolean valor) {
        renderer.setModoSeleccionEscenario(valor);
        requestRender();
    }




}
