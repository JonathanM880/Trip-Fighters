package com.progavanzada.tripfighters.modelos.villanos;
import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Cono;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;
import com.progavanzada.tripfighters.figuras.Sphere;
import com.progavanzada.tripfighters.figuras.Torus;

import java.util.ArrayList;
import java.util.List;
public class Kira {
    private List<Figura> partes;

    public Kira() {
        partes = new ArrayList<>();

        // Zapatos
        Prisma zapatoIzq = new Prisma(0.25f, 0.25f, 0.1f);
        zapatoIzq.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        zapatoIzq.move(-0.15f, 0f, 1.95f);
        partes.add(zapatoIzq);

        Prisma zapatoDer = new Prisma(0.25f, 0.25f, 0.1f);
        zapatoDer.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        zapatoDer.move(0.15f, 0f, 1.95f);
        partes.add(zapatoDer);

        // Piernas
        Prisma piernaIzq = new Prisma(0.25f, 0.15f, 0.9f);
        piernaIzq.setColor(new float[]{0.85f, 0.75f, 0.6f, 1.0f});
        piernaIzq.move(-0.15f, 0.5f, 2);
        partes.add(piernaIzq);

        Prisma piernaDer = new Prisma(0.25f, 0.15f, 0.9f);
        piernaDer.setColor(new float[]{0.85f, 0.75f, 0.6f, 1.0f});
        piernaDer.move(0.15f, 0.5f, 2);
        partes.add(piernaDer);

        // Cintura
        Prisma cintura = new Prisma(0.5f, 0.2f, 0.2f);
        cintura.setColor(new float[]{0.85f, 0.75f, 0.6f, 1.0f});
        cintura.move(0f, 1.05f, 2);
        partes.add(cintura);

        // Correa delantera
        Prisma correa = new Prisma(0.5f, 0.02f, 0.07f);
        correa.setColor(new float[]{0.2f, 0.1f, 0.05f, 1.0f});
        correa.move(0f, 1.1f, 1.9f);
        partes.add(correa);

        // Correa lateral izquierda
        Prisma correaIzq = new Prisma(0.02f, 0.2f, 0.07f);
        correaIzq.setColor(new float[]{0.2f, 0.1f, 0.05f, 1.0f});
        correaIzq.move(-0.26f, 1.1f, 2);
        partes.add(correaIzq);

        // Correa lateral derecha
        Prisma correaDer = new Prisma(0.02f, 0.2f, 0.07f);
        correaDer.setColor(new float[]{0.2f, 0.1f, 0.05f, 1.0f});
        correaDer.move(0.26f, 1.1f, 2);
        partes.add(correaDer);

        // Correa trasera
        Prisma correaBack = new Prisma(0.5f, 0.02f, 0.07f);
        correaBack.setColor(new float[]{0.2f, 0.1f, 0.05f, 1.0f});
        correaBack.move(0f, 1.1f, 2.1f);
        partes.add(correaBack);

        // Torso
        Prisma torso = new Prisma(0.6f, 0.25f, 0.7f);
        torso.setColor(new float[]{0.85f, 0.75f, 0.6f, 1.0f});
        torso.move(0f, 1.5f, 2);
        partes.add(torso);

        // Camisa blanca debajo del saco
        Prisma camisa = new Prisma(0.4f, 0.2f, 0.7f);
        camisa.setColor(new float[]{1f, 1f, 1f, 1.0f});
        camisa.move(0f, 1.5f, 1.97f);
        partes.add(camisa);

        // Nudo de la corbata
        Sphere nudoCorbata = new Sphere(0.07f, 10, 10);
        nudoCorbata.setColor(new float[]{0.6f, 0f, 0f, 1.0f});
        nudoCorbata.move(0f, 1.8f, 1.89f);
        partes.add(nudoCorbata);

        // Prisma de la corbata (ajustado)
        Prisma corbata = new Prisma(0.08f, 0.01f, 0.5f);
        corbata.setColor(new float[]{0.6f, 0f, 0f, 1.0f});
        corbata.move(0f, 1.53f, 1.87f);
        partes.add(corbata);

        // Brazos
        Prisma brazoIzq = new Prisma(0.15f, 0.15f, 0.7f);
        brazoIzq.setColor(new float[]{0.85f, 0.75f, 0.6f, 1.0f});
        brazoIzq.move(-0.4f, 1.51f, 2);
        partes.add(brazoIzq);

        Prisma brazoDer = new Prisma(0.15f, 0.15f, 0.7f);
        brazoDer.setColor(new float[]{0.85f, 0.75f, 0.6f, 1.0f});
        brazoDer.move(0.4f, 1.51f, 2);
        partes.add(brazoDer);

        // Manos
        Sphere manoIzq = new Sphere(0.08f, 10, 10);
        manoIzq.setColor(new float[]{1f, 0.9f, 0.8f, 1.0f});
        manoIzq.move(-0.4f, 1.1f, 2);
        partes.add(manoIzq);

        Sphere manoDer = new Sphere(0.08f, 10, 10);
        manoDer.setColor(new float[]{1f, 0.9f, 0.8f, 1.0f});
        manoDer.move(0.4f, 1.1f, 2);
        partes.add(manoDer);

        // Libreta negra más grande
        Prisma libro = new Prisma(0.3f, 0.02f, 0.4f);
        libro.setColor(new float[]{0f, 0f, 0f, 1.0f});
        libro.move(-0.55f, 1.05f, 1.9f);
        libro.rotate(0,0,45);
        partes.add(libro);

        // Cruz blanca en el libro
        Prisma cruzVertical = new Prisma(0.04f, 0.005f, 0.2f);
        cruzVertical.setColor(new float[]{1f, 1f, 1f, 1.0f});
        cruzVertical.move(-0.55f, 1.05f, 1.89f);
        cruzVertical.rotate(0,0,45);
        partes.add(cruzVertical);

        Prisma cruzHorizontal = new Prisma(0.15f, 0.005f, 0.04f);
        cruzHorizontal.setColor(new float[]{1f, 1f, 1f, 1.0f});
        cruzHorizontal.move(-0.55f, 1.05f, 1.89f);
        cruzHorizontal.rotate(0,0,45);
        partes.add(cruzHorizontal);

        // Cuello
        Cilindro cuello = new Cilindro(20, 0.08f, 0.1f);
        cuello.setColorPart("all", new float[]{1f, 0.9f, 0.8f, 1.0f});
        cuello.move(0f, 1.9f, 2);
        partes.add(cuello);

        // Cabeza
        Sphere cabeza = new Sphere(0.25f, 20, 20);
        cabeza.setColor(new float[]{1f, 0.9f, 0.8f, 1.0f});
        cabeza.move(0f, 2.2f, 2);
        partes.add(cabeza);

        // Ojos rojos
        Prisma ojoIzq = new Prisma(0.1f, 0.01f, 0.1f);
        ojoIzq.setColor(new float[]{1f, 0f, 0f, 1.0f});
        ojoIzq.move(-0.07f, 2.15f, 1.78f);
        partes.add(ojoIzq);

        Prisma ojoDer = new Prisma(0.1f, 0.01f, 0.1f);
        ojoDer.setColor(new float[]{1f, 0f, 0f, 1.0f});
        ojoDer.move(0.07f, 2.15f, 1.78f);
        partes.add(ojoDer);

        // Sonrisa siniestra
        Prisma sonrisa = new Prisma(0.15f, 0.01f, 0.02f);
        sonrisa.setColor(new float[]{0f, 0f, 0f, 1.0f});
        sonrisa.move(0f, 2f, 1.86f);
        partes.add(sonrisa);

        // Cabello
        Sphere cabello = new Sphere(0.27f, 20, 20);
        cabello.setColor(new float[]{0.6f, 0.4f, 0.2f, 1.0f});
        cabello.move(0f, 2.3f, 2);
        partes.add(cabello);
    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}

