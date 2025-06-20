package com.progavanzada.tripfighters.modelos.villanos;

import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Cono;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;
import com.progavanzada.tripfighters.figuras.Sphere;

import java.util.ArrayList;
import java.util.List;

public class Payaso {
    private List<Figura> partes;

    public Payaso() {
        partes = new ArrayList<>();

        // EJE X
        Sphere sp = new Sphere(.3f, 30, 30);
        sp.move(0, 0, 0);
        //partes.add(sp);

        // --- PIES (sobre el suelo, y=0) ---
        Cilindro pieIzq = new Cilindro(10, 0.3f, 0.2f);
        pieIzq.setColorPart("all", new float[]{0f, 0f, 0f, 1});
        pieIzq.move(-0.4f, 0.05f, 2);
        partes.add(pieIzq);

        Cilindro pieDer = new Cilindro(10, 0.3f, 0.2f);
        pieDer.setColorPart("all", new float[]{0f, 0f, 0f, 1});
        pieDer.move(0.4f, 0.05f, 2);
        partes.add(pieDer);

        // POMPONES DE ZAPATO
        Sphere bolitaPieIzq = new Sphere(0.1f, 20, 20);
        bolitaPieIzq.setColor(new float[]{.7f, 0f, 0f, 1});
        bolitaPieIzq.move(-0.65f, 0.1f, 2);
        partes.add(bolitaPieIzq);

        Sphere bolitaPieDer = new Sphere(0.1f, 20, 20);
        bolitaPieDer.setColor(new float[]{.7f, 0f, 0f, 1});
        bolitaPieDer.move(0.65f, 0.1f, 2);
        partes.add(bolitaPieDer);

        // --- PIERNAS ---
        Cilindro piernaIzq = new Cilindro(6, 0.15f, 0.4f);
        piernaIzq.setColorPart("all", new float[]{.4f, 0f, .6f, 1});
        piernaIzq.move(-0.2f, 0.35f, 2);
        partes.add(piernaIzq);

        Cilindro piernaDer = new Cilindro(6, 0.15f, 0.4f);
        piernaDer.setColorPart("all", new float[]{.4f, 0f, .6f, 1});
        piernaDer.move(0.2f, 0.35f, 2);
        partes.add(piernaDer);

        // --- CUERPO ---
        Cilindro cuerpo = new Cilindro(6, 0.4f, 0.75f);
        cuerpo.setColorPart("all", new float[]{0.4f, 0f, .6f, 1});
        cuerpo.move(0f, 0.875f, 2);
        partes.add(cuerpo);

        // BOTONES (3)
        for (int i = 0; i < 3; i++) {
            Sphere boton = new Sphere(0.05f, 20, 20);
            boton.setColor(new float[]{.7f, 0f, 0f, 1});
            boton.move(0f, 0.65f + i * 0.15f, 1.65f);
            partes.add(boton);
        }

        // CORBATIN
        Cono ala1 = new Cono(0.1f, 0.05f, 4);
        ala1.setColorPart("all", new float[]{.9f, .4f, 0f, 1});
        ala1.move(-0.1f, 1.15f, 1.6f);
        partes.add(ala1);

        Cono ala2 = new Cono(0.1f, 0.05f, 4);
        ala2.setColorPart("all", new float[]{.9f, .4f, 0f, 1});
        ala2.move(0.1f, 1.15f, 1.6f);
        partes.add(ala2);

        Sphere centroCorbata = new Sphere(0.03f, 20, 20);
        centroCorbata.setColor(new float[]{.9f, .4f, 0f, 1});
        centroCorbata.move(0f, 1.15f, 1.6f);
        partes.add(centroCorbata);

        // --- CABEZA ---
        Cilindro cabeza = new Cilindro(12, 0.3f, 0.4f);
        cabeza.setColorPart("all", new float[]{.98f, 0.95f, 0.98f, 1});
        cabeza.move(0f, 1.5f, 2);
        partes.add(cabeza);

        // NARIZ
        Sphere nariz = new Sphere(0.07f, 20, 20);
        nariz.setColor(new float[]{1f, 0f, 0f, 1});
        nariz.move(0f, 1.5f, 1.7f);
        partes.add(nariz);

        // OJOS
        Sphere ojoIzq = new Sphere(0.05f, 20, 20);
        ojoIzq.setColor(new float[]{0.05f, 0.05f, 0.05f, 1});
        ojoIzq.move(-0.1f, 1.55f, 1.7f);
        partes.add(ojoIzq);

        Sphere ojoDer = new Sphere(0.05f, 20, 20);
        ojoDer.setColor(new float[]{0f, 0f, 0f, 1});
        ojoDer.move(0.1f, 1.55f, 1.7f);
        partes.add(ojoDer);

        // PELO (orejas)
        Sphere orejaIzq = new Sphere(0.08f, 20, 20);
        orejaIzq.setColor(new float[]{0f, 0.6f, 0f, 1});
        orejaIzq.move(-0.35f, 1.5f, 2);
        partes.add(orejaIzq);

        Sphere orejaDer = new Sphere(0.08f, 20, 20);
        orejaDer.setColor(new float[]{0f, 0.6f, 0f, 1});
        orejaDer.move(0.35f, 1.5f, 2);
        partes.add(orejaDer);

        Sphere orejaIzq1 = new Sphere(0.08f, 20, 20);
        orejaIzq1.setColor(new float[]{0f, 0.6f, 0f, 1});
        orejaIzq1.move(-0.35f, 1.65f, 2);
        partes.add(orejaIzq1);

        Sphere orejaDer2 = new Sphere(0.08f, 20, 20);
        orejaDer2.setColor(new float[]{0f, 0.6f, 0f, 1});
        orejaDer2.move(0.35f, 1.65f, 2);
        partes.add(orejaDer2);

        // --- BRAZOS ---
        Cilindro brazoIzq = new Cilindro(6, 0.15f, 0.5f);
        brazoIzq.setColorPart("all", new float[]{0f, 0.4f, 0.3f, 1});
        brazoIzq.move(-0.6f, 1.1f, 2);
        brazoIzq.rotate(0, 0, -45);
        partes.add(brazoIzq);

        Cilindro brazoDer = new Cilindro(6, 0.15f, 0.5f);
        brazoDer.setColorPart("all", new float[]{0f, 0.4f, 0.3f, 1});
        brazoDer.move(0.6f, 1.1f, 2);
        brazoDer.rotate(0, 0, 45);
        partes.add(brazoDer);

        // MANOS
        Sphere manoIzq = new Sphere(0.1f, 20, 20);
        manoIzq.setColor(new float[]{1f, 0.8f, 0.6f, 1});
        manoIzq.move(-0.85f, 1.35f, 2);
        partes.add(manoIzq);

        Sphere manoDer = new Sphere(0.1f, 20, 20);
        manoDer.setColor(new float[]{1f, 0.8f, 0.6f, 1});
        manoDer.move(0.85f, 1.35f, 2);
        partes.add(manoDer);

        //CUCHILLO

        Prisma mango = new Prisma(0.05f, 0.05f, 0.15f);
        mango.setColor(new float[]{0.3f, 0.15f, 0.1f, 1});
        mango.move(0.9f, 1.45f, 2f);
        partes.add(mango);

        Cono hoja = new Cono(0.03f, 0.2f, 10);
        hoja.setColorPart("all", new float[]{0.75f, 0.75f, 0.75f, 1});
        hoja.move(0.9f, 1.55f, 2f);
        partes.add(hoja);

        // --- BOCA MALVADA (Cono invertido) ---
        Cono sonrisa = new Cono(0.25f, 0.15f, 12);
        sonrisa.setColorPart("all", new float[]{0.5f, 0f, 0f, 1});
        sonrisa.move(0f, 1.4f, 1.72f); // posición centrada un poco debajo de la nariz
        sonrisa.rotate(180, 0, 0); // boca hacia arriba
        partes.add(sonrisa);

// --- Puntos en las comisuras (acento visual) ---
        Sphere comisuraIzq = new Sphere(0.04f, 10, 10);
        comisuraIzq.setColor(new float[]{0.5f, 0f, 0f, 1});
        comisuraIzq.move(-0.2f, 1.42f, 1.72f);
        partes.add(comisuraIzq);

        Sphere comisuraDer = new Sphere(0.04f, 10, 10);
        comisuraDer.setColor(new float[]{0.5f, 0f, 0f, 1});
        comisuraDer.move(0.2f, 1.42f, 1.72f);
        partes.add(comisuraDer);


    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}

