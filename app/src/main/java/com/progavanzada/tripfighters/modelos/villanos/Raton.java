package com.progavanzada.tripfighters.modelos.villanos;
import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Cono;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;
import com.progavanzada.tripfighters.figuras.Sphere;
import com.progavanzada.tripfighters.figuras.Torus;

import java.util.ArrayList;
import java.util.List;

public class Raton {
    private List<Figura> partes;

    public Raton() {
        partes = new ArrayList<>();

        // Zapatos amarillos
        Prisma zapatoIzq = new Prisma(0.3f, 0.4f, 0.1f);
        zapatoIzq.setColor(new float[]{1.0f, 0.85f, 0.1f, 1.0f});
        zapatoIzq.move(-0.2f, 0f, 1.9f);
        partes.add(zapatoIzq);

        Prisma zapatoDer = new Prisma(0.3f, 0.4f, 0.1f);
        zapatoDer.setColor(new float[]{1.0f, 0.85f, 0.1f, 1.0f});
        zapatoDer.move(0.2f, 0f, 1.9f);
        partes.add(zapatoDer);

        // Piernas negras
        Prisma piernaIzq = new Prisma(0.15f, 0.15f, 0.55f);
        piernaIzq.setColor(new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        piernaIzq.move(-0.2f, 0.32f, 2);
        partes.add(piernaIzq);

        Prisma piernaDer = new Prisma(0.15f, 0.15f, 0.55f);
        piernaDer.setColor(new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        piernaDer.move(0.2f, 0.32f, 2);
        partes.add(piernaDer);

        // Pantalones rojos
        Prisma pantalon = new Prisma(0.6f, 0.3f, 0.3f);
        pantalon.setColor(new float[]{0.8f, 0.1f, 0.1f, 1.0f});
        pantalon.move(0f, 0.75f, 2);
        partes.add(pantalon);

        // Botones blancos
        Sphere boton1 = new Sphere(0.05f, 10, 10);
        boton1.setColor(new float[]{1f, 1f, 1f, 1.0f});
        boton1.move(-0.1f, 0.75f, 1.85f);
        partes.add(boton1);

        Sphere boton2 = new Sphere(0.05f, 10, 10);
        boton2.setColor(new float[]{1f, 1f, 1f, 1.0f});
        boton2.move(0.1f, 0.75f, 1.85f);
        partes.add(boton2);

        // Cuerpo negro
        Prisma torso = new Prisma(0.5f, 0.3f, 0.6f);
        torso.setColor(new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        torso.move(0f, 1.2f, 2);
        partes.add(torso);

        // Brazos
        Prisma brazoIzq = new Prisma(0.15f, 0.15f, 0.5f);
        brazoIzq.setColor(new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        brazoIzq.move(-0.4f, 1.2f, 2);
        partes.add(brazoIzq);

        Prisma brazoDer = new Prisma(0.15f, 0.15f, 0.5f);
        brazoDer.setColor(new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        brazoDer.move(0.4f, 1.2f, 2);
        partes.add(brazoDer);

        // HOMBROS
        Prisma hombroIzq = new Prisma(0.15f, 0.15f, 0.15f);
        hombroIzq.setColor(new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        hombroIzq.move(-0.275f, 1.4f, 2); // entre torso y brazo izquierdo
        partes.add(hombroIzq);

        Prisma hombroDer = new Prisma(0.15f, 0.15f, 0.15f);
        hombroDer.setColor(new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        hombroDer.move(0.275f, 1.4f, 2); // entre torso y brazo derecho
        partes.add(hombroDer);

        // Guantes blancos
        Sphere guanteIzq = new Sphere(0.12f, 10, 10);
        guanteIzq.setColor(new float[]{1f, 1f, 1f, 1.0f});
        guanteIzq.move(-0.4f, 0.95f, 2);
        partes.add(guanteIzq);

        Sphere guanteDer = new Sphere(0.12f, 10, 10);
        guanteDer.setColor(new float[]{1f, 1f, 1f, 1.0f});
        guanteDer.move(0.4f, 0.95f, 2);
        partes.add(guanteDer);

        // Cabeza (color piel)
        Sphere cabeza = new Sphere(0.3f, 20, 20);
        cabeza.setColor(new float[]{1f, 0.85f, 0.7f, 1.0f});
        cabeza.move(0f, 1.8f, 2);
        partes.add(cabeza);

        // Orejas negras
        Sphere orejaIzq = new Sphere(0.15f, 10, 10);
        orejaIzq.setColor(new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        orejaIzq.move(-0.25f, 2.1f, 2);
        partes.add(orejaIzq);

        Sphere orejaDer = new Sphere(0.15f, 10, 10);
        orejaDer.setColor(new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        orejaDer.move(0.25f, 2.1f, 2);
        partes.add(orejaDer);

        // Ojos diabólicos
        Prisma ojoIzq = new Prisma(0.12f, 0.01f, 0.12f);
        ojoIzq.setColor(new float[]{.5f, 0f, 0f, 1f});
        ojoIzq.move(-0.09f, 1.85f, 1.725f);
        partes.add(ojoIzq);

        Prisma ojoDer = new Prisma(0.12f, 0.01f, 0.12f);
        ojoDer.setColor(new float[]{.5f, 0f, 0f, 1f});
        ojoDer.move(0.09f, 1.85f, 1.725f);
        partes.add(ojoDer);

        // --- BOCA MALVADA (Cono invertido)
        Cono sonrisa = new Cono(0.25f, 0.15f, 12);
        sonrisa.setColorPart("all", new float[]{0.5f, 0f, 0f, 1});
        sonrisa.move(0f, 1.63f, 1.88f);
        sonrisa.rotate(180, 0, 0);
        partes.add(sonrisa);

        // --- Puntos en las comisuras
        Sphere comisuraIzq = new Sphere(0.04f, 10, 10);
        comisuraIzq.setColor(new float[]{0.5f, 0f, 0f, 1});
        comisuraIzq.move(-0.2f, 1.65f, 1.78f); // ajustado a la forma de la cabeza
        partes.add(comisuraIzq);

        Sphere comisuraDer = new Sphere(0.04f, 10, 10);
        comisuraDer.setColor(new float[]{0.5f, 0f, 0f, 1});
        comisuraDer.move(0.2f, 1.65f, 1.78f);
        partes.add(comisuraDer);

    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}
