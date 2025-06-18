package com.progavanzada.tripfighters.modelos.villanos;

import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;
import com.progavanzada.tripfighters.figuras.Sphere;
import com.progavanzada.tripfighters.figuras.Torus;

import java.util.ArrayList;
import java.util.List;

public class Cactus {
    private List<Figura> partes;

    public Cactus() {

        //Modela el personaje en (0f en x) y (2f en z)
        // el centro de tu personaje

        partes = new ArrayList<>();

        //MACETA
        Cilindro base = new Cilindro(4,.75f,.5f);
        base.move(0f,-1.5f,2f);
        base.setColorPart("all", new float[]{0.55f, 0.27f, 0.07f, 1.0f});
        base.rotate(0,45,0);
        partes.add(base);

        Cilindro tapa = new Cilindro(4,.9f,.2f);
        tapa.move(0f,-1.25f,2f);
        tapa.setColorPart("all", new float[]{0.55f, 0.27f, 0.07f, 1.0f});
        tapa.rotate(0,45,0);
        partes.add(tapa);

        //CUERPO
        Cilindro cuerpo = new Cilindro(4,.6f,2f);
        cuerpo.move(0f,-.15f,2f);
        cuerpo.setColorPart("all", new float[]{0.28f, 0.45f, 0.16f, 1.0f});
        cuerpo.rotate(0,45,0);
        partes.add(cuerpo);

        //BRAZOS
        Prisma brazoIzq = new Prisma(.7f,.7f,.4f);
        brazoIzq.move(-.7f,-.5f,2f);
        brazoIzq.setColor(new float[]{0.28f, 0.45f, 0.16f, 1.0f});
        partes.add(brazoIzq);

        Prisma manoIzq = new Prisma(.35f,.35f,.3f); //si quiero hacerle simetrico le cambio de color
        manoIzq.move(-.91f,-.17f,2f);
        manoIzq.setColor(new float[]{0.28f, 0.45f, 0.16f, 1.0f});
        partes.add(manoIzq);

        Prisma brazoDer = new Prisma(.7f,.7f,.4f);
        brazoDer.move(.7f,0.1f,2f);
        brazoDer.setColor(new float[]{0.28f, 0.45f, 0.16f, 1.0f});
        partes.add(brazoDer);

        Prisma manoDer = new Prisma(.35f,.35f,.3f);
        manoDer.move(.91f,0.43f,2f);
        manoDer.setColor(new float[]{0.28f, 0.45f, 0.16f, 1.0f});
        partes.add(manoDer);

        //OJOS

        Sphere ojoIzq = new Sphere(.13f,30,30);
        ojoIzq.move(-.15f, 0.4f,2.35f);
        ojoIzq.setColor(new float[]{1f,1f, 1f, 1.0f});
        partes.add(ojoIzq);

        Sphere ojoDer = new Sphere(.13f,30,30);
        ojoDer.move(.15f, 0.4f,2.35f);
        ojoDer.setColor(new float[]{1f,1f, 1f, 1.0f});
        partes.add(ojoDer);

        //falta cejas, pupilas, boca
    }



    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}
