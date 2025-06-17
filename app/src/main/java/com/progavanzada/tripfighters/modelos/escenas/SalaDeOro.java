package com.progavanzada.tripfighters.modelos.escenas;

import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;

import java.util.ArrayList;
import java.util.List;

public class SalaDeOro {
    private List<Figura> partes;

    public SalaDeOro() {


        partes = new ArrayList<>();

        // pared
        Prisma pared = new Prisma(0.5f,2.0f, 2.0f);
        pared.move(-2f, 0f, 0f);
        float[] amarilloOro = new float[]{1.0f, 0.84f, 0.0f, 1.0f};
        pared.setColor(amarilloOro);
        //pared.scale(1f,1f,4f);
        partes.add(pared);

    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}
