package com.progavanzada.tripfighters.modelos.villanos;

import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Cono;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;
import com.progavanzada.tripfighters.figuras.Sphere;
import com.progavanzada.tripfighters.figuras.Torus;

import java.util.ArrayList;
import java.util.List;

public class Cactus {
    private List<Figura> partes;

    public Cactus() {
        partes = new ArrayList<>();

        // EJE X
        Sphere sp = new Sphere(.3f, 30, 30);
        sp.move(0, 0, 0);
        //partes.add(sp);

        // --- MACETA ---
        Cilindro base = new Cilindro(4, .75f, .5f);
        base.move(0f, .25f, 2f);
        base.setColorPart("all", new float[]{0.55f, 0.27f, 0.07f, 1.0f});
        base.rotate(0, 45, 0);
        partes.add(base);

        Cilindro tapa = new Cilindro(4, .9f, .2f);
        tapa.move(0f, .5f, 2f);
        tapa.setColorPart("all", new float[]{0.55f, 0.27f, 0.07f, 1.0f});
        tapa.rotate(0, 45, 0);
        partes.add(tapa);

        // --- CUERPO ---
        Cilindro cuerpo = new Cilindro(4, .6f, 2f);
        cuerpo.move(0f, 1.6f, 2f);
        cuerpo.setColorPart("all", new float[]{0.28f, 0.45f, 0.16f, 1.0f});
        cuerpo.rotate(0, 45, 0);
        partes.add(cuerpo);

        // --- BRAZOS ---
        Prisma brazoIzq = new Prisma(.7f, .7f, .4f);
        brazoIzq.move(-.7f, 1.25f, 2f);
        brazoIzq.setColor(new float[]{0.28f, 0.45f, 0.16f, 1.0f});
        partes.add(brazoIzq);

        Prisma manoIzq = new Prisma(.35f, .35f, .3f);
        manoIzq.move(-.91f, 1.58f, 2f);
        manoIzq.setColor(new float[]{0.28f, 0.45f, 0.16f, 1.0f});
        partes.add(manoIzq);

        Prisma brazoDer = new Prisma(.7f, .7f, .4f);
        brazoDer.move(.7f, 1.85f, 2f);
        brazoDer.setColor(new float[]{0.28f, 0.45f, 0.16f, 1.0f});
        partes.add(brazoDer);

        Prisma manoDer = new Prisma(.35f, .35f, .3f);
        manoDer.move(.91f, 2.18f, 2f);
        manoDer.setColor(new float[]{0.28f, 0.45f, 0.16f, 1.0f});
        partes.add(manoDer);

        // --- OJOS ---
        Sphere ojoIzq = new Sphere(.13f, 30, 30);
        ojoIzq.move(-.15f, 2.15f, 1.65f);
        ojoIzq.setColor(new float[]{1f, 1f, 1f, 1.0f});
        partes.add(ojoIzq);

        Sphere pupIzq = new Sphere(.065f, 30, 30);
        pupIzq.move(-.15f, 2.15f, 1.56f);
        pupIzq.setColor(new float[]{1f, 0f, 0f, 1.0f}); // rojo amenazante
        partes.add(pupIzq);

        Sphere ojoDer = new Sphere(.13f, 30, 30);
        ojoDer.move(.15f, 2.15f, 1.65f);
        ojoDer.setColor(new float[]{1f, 1f, 1f, 1.0f});
        partes.add(ojoDer);

        Sphere pupDer = new Sphere(.065f, 30, 30);
        pupDer.move(.15f, 2.15f, 1.56f);
        pupDer.setColor(new float[]{1f, 0f, 0f, 1.0f}); // rojo amenazante
        partes.add(pupDer);

        // --- CEJAS ---
        Prisma cejaIzq = new Prisma(.2f, .05f, .05f);
        cejaIzq.setColor(new float[]{0f, 0f, 0f, 1});
        cejaIzq.move(-.2f, 2.3f, 1.6f);
        partes.add(cejaIzq);

        Prisma cejaDer = new Prisma(.2f, .05f, .05f);
        cejaDer.setColor(new float[]{0f, 0f, 0f, 1});
        cejaDer.move(.2f, 2.3f, 1.6f);
        partes.add(cejaDer);

        // --- BOCA (cono invertido como sonrisa malvada) ---
        Cono boca = new Cono(.25f, .15f, 10);
        boca.setColorPart("all", new float[]{0f, 0f, 0f, 1});
        boca.move(0f, 1.9f, 1.62f);
        boca.rotate(180, 0, 0);
        partes.add(boca);

        // --- ESPINAS PEQUEÑAS MEJORADAS ---
        float[][] espinas = {
                {0f, 2.3f, 1.6f, 180},       // arriba centro
                {-0.25f, 1.8f, 1.6f, 180}, // izquierda
                {0.25f, 1.5f, 1.6f, 180},   // derecha
                {-0.25f, 1.2f, 1.6f, 180},
                {0.25f, 1f, 1.6f, 180},
                {-0.75f, 1.5f, 1.6f, 180}, // brazo izq
                {0.75f, 2f, 1.6f, 180},     // brazo der
                {0f, 0.8f, 1.6f, 180},
        };

        float[][] espinas2 = {
                {0f, 2.3f, 2.4f, 0},       // arriba centro
                {-0.25f, 1.8f, 2.4f, 0}, // izquierda
                {0.25f, 1.5f, 2.4f, 0},   // derecha
                {-0.25f, 1.2f, 2.4f, 0},
                {0.25f, 1f, 2.4f, 0},
                {-0.75f, 1.5f, 2.4f, 0}, // brazo izq
                {0.75f, 2f, 2.4f, 0},     // brazo der
                {0f, 0.8f, 2.4f, 0}
        };

        for (float[] pos : espinas) {
            Cono espina = new Cono(0.05f, 0.1f, 6);
            espina.setColorPart("all", new float[]{0.9f, 0.9f, 0.9f, 1});
            espina.move(pos[0], pos[1], pos[2]);

            // Rotar hacia afuera (eje Z si están a los lados)
            espina.rotate(270, 0, pos[3]);

            partes.add(espina);
        }

        for (float[] pos : espinas2) {
            Cono espina = new Cono(0.05f, 0.1f, 6);
            espina.setColorPart("all", new float[]{0.9f, 0.9f, 0.9f, 1});
            espina.move(pos[0], pos[1], pos[2]);

            // Rotar hacia afuera (eje Z si están a los lados)
            espina.rotate(90, 0, pos[3]);

            partes.add(espina);
        }

        // --- PINCHO SOBRE MANO IZQUIERDA ---
        Cono pinchoIzq = new Cono(0.1f, 0.3f, 8);
        pinchoIzq.setColorPart("all", new float[]{0.8f, 0.8f, 0.8f, 1});
        pinchoIzq.move(-0.91f, 1.78f, 2f); // un poco más arriba de la mano izq
        partes.add(pinchoIzq);

        // --- PINCHO SOBRE MANO DERECHA ---
        Cono pinchoDer = new Cono(0.1f, 0.3f, 8);
        pinchoDer.setColorPart("all", new float[]{0.8f, 0.8f, 0.8f, 1});
        pinchoDer.move(0.91f, 2.38f, 2f); // un poco más arriba de la mano der
        partes.add(pinchoDer);


        // --- PINCHO EN LA CABEZA ---
        Cono pinchoCabeza = new Cono(0.1f, 0.3f, 8);
        pinchoCabeza.setColorPart("all", new float[]{0.8f, 0.8f, 0.8f, 1});
        pinchoCabeza.move(0f, 2.7f, 2f);
        partes.add(pinchoCabeza);
    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}
