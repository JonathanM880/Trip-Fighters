package com.progavanzada.tripfighters;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.progavanzada.tripfighters.openGLUtil.MyGLSurfaceView;


public class MainActivity extends AppCompatActivity {

    private MyGLSurfaceView glSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new MyGLSurfaceView(this);
        setContentView(glSurfaceView);
    }
}