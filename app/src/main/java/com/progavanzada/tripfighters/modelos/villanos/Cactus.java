package com.progavanzada.tripfighters.modelos.villanos;

import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Torus;

import java.util.ArrayList;
import java.util.List;

public class Cactus {
    private List<Figura> partes;

    public Cactus() {

        //Modela el personaje en (0f en x) y (2f en z)
        // el centro de tu personaje

        partes = new ArrayList<>();

        // flor
        Torus flor = new Torus(20, 0.5f, 0.25f);
        flor.move(0f, 0f, 2f);
        float[] rosa = new float[]{1.0f, 0.4f, 0.7f, 1.0f};
        flor.setColor(rosa);
        flor.scale(0.5f,0.5f,0.5f);
        flor.rotate(90f,0f,0f);
        partes.add(flor);

        // cuerpo
        Cilindro cuerpo = new Cilindro(30, 0.10f, 1f);
        cuerpo.setColorPart("all", new float[]{0.6f, 1.0f, 0.6f, 1.0f});
        cuerpo.move(0f, 0f, 2f);
        partes.add(cuerpo);
    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}
