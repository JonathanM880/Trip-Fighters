package com.progavanzada.tripfighters.modelos.personajesJugables;

import com.progavanzada.tripfighters.figuras.Cono;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Sphere;

import java.util.ArrayList;
import java.util.List;

public class ChicoCubo {
    private List<Figura> partes;

    public ChicoCubo() {

        //Modela el personaje en (0f en x) y (-2f en z) el centro de tu personaje

        partes = new ArrayList<>();

        // cuerpo
        Cono cuerpo = new Cono(0.5f, 2.5f, 4);
        cuerpo.move(0f, 0f, -2f);
        float[] colorPiel = new float[]{1.0f, 0.8f, 0.6f, 1.0f};
        cuerpo.setColorPart("all", colorPiel);
        partes.add(cuerpo);

        // cabeza
        Sphere cabeza = new Sphere(1f, 30, 30);
        cabeza.setColor(new float[]{1.0f, 0.8f, 0.6f, 1.0f});
        cabeza.move(0f, 3.5f, -2f);
        cabeza.scale(0.5f,1.5f,1.0f);
        partes.add(cabeza);
    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}

