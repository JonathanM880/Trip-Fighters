package com.progavanzada.tripfighters.modelos.personajesJugables;

import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;
import com.progavanzada.tripfighters.figuras.Sphere;

import java.util.ArrayList;
import java.util.List;

public class ChicoCubo {
    private List<Figura> partes;

    public ChicoCubo() {
        partes = new ArrayList<>();

        float offsetY = -0.2f;
        float offsetZ = -2f;
        float escala = 0.8f;

        // --- CABEZA ---
        Prisma cabeza = new Prisma(0.7f, 0.7f, 0.7f);
        cabeza.setColor(new float[]{1f, 0.7f, 0.75f, 1});
        cabeza.move(0f, 1.6f + offsetY, offsetZ);
        partes.add(cabeza);

        // --- OJOS ---
        crearOjoSimple(-0.2f, partes, offsetY, offsetZ, true);
        crearOjoSimple(0.2f, partes, offsetY, offsetZ, true);

        // --- MEJILLAS ---
        Sphere mejillaIzq = new Sphere(0.045f, 10, 10);
        mejillaIzq.setColor(new float[]{1f, 0.5f, 0.7f, 1});
        mejillaIzq.move(-0.3f * escala, (1.75f * escala) + offsetY, offsetZ + 0.37f);
        partes.add(mejillaIzq);

        Sphere mejillaDer = new Sphere(0.045f, 10, 10);
        mejillaDer.setColor(new float[]{1f, 0.5f, 0.7f, 1});
        mejillaDer.move(0.3f * escala, (1.75f * escala) + offsetY, offsetZ + 0.37f);
        partes.add(mejillaDer);

        // --- CUERPO ---
        Prisma cuerpo = new Prisma(0.45f * escala, 0.5f * escala, 0.7f * escala);
        cuerpo.setColor(new float[]{0.4f, 0.4f, 0.45f, 1});
        cuerpo.move(0f, (1.3f * escala) + offsetY, offsetZ);
        partes.add(cuerpo);

        // --- CORBATA ---
        Prisma corbata = new Prisma(0.1f * escala, 0.01f * escala, 0.2f * escala);
        corbata.setColor(new float[]{0.8f, 0f, 0f, 1});
        corbata.move(0f, (1.38f * escala) + offsetY, 0.2f + offsetZ);


        partes.add(corbata);

        // --- BOTONES ---
        float[] colorBoton = new float[]{1f, 1f, 1f, 1};
        float xBoton = 0f;
        float zBoton = 0.2f + offsetZ;



        float[] alturas = new float[]{
                (1.20f * escala) + offsetY,
                (1.05f * escala) + offsetY
        };

        for (float yBoton : alturas) {
            Sphere boton = new Sphere(0.025f * escala, 10, 10);
            boton.setColor(colorBoton);
            boton.move(xBoton, yBoton, zBoton);
            partes.add(boton);
        }

        // --- MANGAS ---
        Prisma mangaIzq = new Prisma(0.13f * escala, 0.13f * escala, 0.13f * escala);
        mangaIzq.setColor(new float[]{0.2f, 0.2f, 0.25f, 1});
        mangaIzq.move(-0.3f * escala, (1.4f * escala) + offsetY, offsetZ);
        mangaIzq.scale(1.5f, 1.5f, 1.5f);
        partes.add(mangaIzq);

        Prisma mangaDer = new Prisma(0.13f * escala, 0.13f * escala, 0.13f * escala);
        mangaDer.setColor(new float[]{0.2f, 0.2f, 0.25f, 1});
        mangaDer.move(0.3f * escala, (1.4f * escala) + offsetY, offsetZ);
        mangaDer.scale(1.5f, 1.5f, 1.5f);
        partes.add(mangaDer);

        // --- BRAZOS ---
        Cilindro brazoIzq = new Cilindro(6, 0.09f * escala, 0.6f * escala);
        brazoIzq.setColorPart("all", new float[]{1f, 0.7f, 0.75f, 1});
        brazoIzq.move(-0.3f * escala, (1.2f * escala) + offsetY, offsetZ);
        partes.add(brazoIzq);

        Cilindro brazoDer = new Cilindro(6, 0.09f * escala, 0.6f * escala);
        brazoDer.setColorPart("all", new float[]{1f, 0.7f, 0.75f, 1});
        brazoDer.move(0.3f * escala, (1.2f * escala) + offsetY, offsetZ);
        partes.add(brazoDer);

        // --- PIERNAS ---
        Cilindro piernaIzq = new Cilindro(6, 0.11f * escala, 0.85f * escala);
        piernaIzq.setColorPart("all", new float[]{0.2f, 0.2f, 0.25f, 1});
        piernaIzq.move(-0.13f * escala, (0.7f * escala) + offsetY, offsetZ);
        partes.add(piernaIzq);

        Cilindro piernaDer = new Cilindro(6, 0.11f * escala, 0.85f * escala);
        piernaDer.setColorPart("all", new float[]{0.2f, 0.2f, 0.25f, 1});
        piernaDer.move(0.13f * escala, (0.7f * escala) + offsetY, offsetZ);
        partes.add(piernaDer);

        // --- ZAPATOS ---
        Prisma zapatoIzq = new Prisma(0.2f * escala, 0.15f * escala, 0.2f * escala);
        zapatoIzq.setColor(new float[]{0f, 0f, 0f, 1});
        zapatoIzq.move(-0.13f * escala, (0.2f * escala) + offsetY, offsetZ);
        zapatoIzq.scale(1, 1, 2.2f);
        partes.add(zapatoIzq);

        Prisma zapatoDer = new Prisma(0.2f * escala, 0.15f * escala, 0.2f * escala);
        zapatoDer.setColor(new float[]{0f, 0f, 0f, 1});
        zapatoDer.move(0.13f * escala, (0.2f * escala) + offsetY, offsetZ);
        zapatoDer.scale(1, 1, 2.2f);
        partes.add(zapatoDer);

        // --- PELO --- (sin cambios)
        Sphere pelo1 = new Sphere(0.2f, 10, 10);
        pelo1.setColor(new float[]{0.1f, 0.1f, 0.1f, 1});
        pelo1.move(0f, 1.95f + offsetY, offsetZ - 0.15f);
        partes.add(pelo1);

        Sphere pelo2 = new Sphere(0.2f, 10, 10);
        pelo2.setColor(new float[]{0.1f, 0.1f, 0.1f, 1});
        pelo2.move(0f, 1.9f + offsetY, offsetZ - 0.1f);
        partes.add(pelo2);

        Sphere pelo3 = new Sphere(0.17f, 10, 10);
        pelo3.setColor(new float[]{0.1f, 0.1f, 0.1f, 1});
        pelo3.move(0f, 1.95f + offsetY, offsetZ - 0.05f);
        partes.add(pelo3);

        Sphere pelo4 = new Sphere(0.2f, 10, 10);
        pelo4.setColor(new float[]{0.1f, 0.1f, 0.1f, 1});
        pelo4.move(-0.15f, 1.95f + offsetY, offsetZ - 0.1f);
        partes.add(pelo4);

        Sphere pelo5 = new Sphere(0.17f, 10, 10);
        pelo5.setColor(new float[]{0.1f, 0.1f, 0.1f, 1});
        pelo5.move(0.15f, 1.99f + offsetY, offsetZ - 0.1f);
        partes.add(pelo5);

        Sphere pelo6 = new Sphere(0.18f, 10, 10);
        pelo6.setColor(new float[]{0.1f, 0.1f, 0.1f, 1});
        pelo6.move(-0.1f, 1.9f + offsetY, offsetZ - 0.05f);
        partes.add(pelo6);

        Sphere pelo7 = new Sphere(0.2f, 10, 10);
        pelo7.setColor(new float[]{0.1f, 0.1f, 0.1f, 1});
        pelo7.move(0.1f, 1.9f + offsetY, offsetZ - 0.05f);
        partes.add(pelo7);

        Sphere pelo8 = new Sphere(0.19f, 10, 10);
        pelo8.setColor(new float[]{0.1f, 0.1f, 0.1f, 1});
        pelo8.move(0f, 1.87f + offsetY, offsetZ);
        partes.add(pelo8);
    }

    private void crearOjoSimple(float x, List<Figura> partes, float offsetY, float offsetZ, boolean mirarAtras) {
        float y = 1.62f + offsetY;
        float z = mirarAtras ? offsetZ + 0.4f : offsetZ - 0.4f;

        Sphere ojo = new Sphere(0.1f, 20, 20);
        ojo.setColor(new float[]{1f, 1f, 1f, 1});
        ojo.move(x, y, z);
        partes.add(ojo);


    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}