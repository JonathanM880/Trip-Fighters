package com.progavanzada.tripfighters.modelos.personajesJugables;

import com.progavanzada.tripfighters.figuras.*;

import java.util.ArrayList;
import java.util.List;

public class ChicaCubo {
    private List<Figura> partes;

    public ChicaCubo() {
        partes = new ArrayList<>();

        float offsetY = -0.2f;
        float offsetZ = -2f;
        float escala = 0.8f;

        // --- CABEZA ---
        Prisma cabeza = new Prisma(0.7f, 0.7f, 0.7f);
        cabeza.setColor(new float[]{1f, 0.85f, 0.75f, 1});
        cabeza.move(0f, 1.6f + offsetY, offsetZ);
        partes.add(cabeza);

        // --- PELO---
        float radioPelo = 0.3f;
        float[] colorPelo = new float[]{0.6f, 0.2f, 0.6f, 1};

        for (float x = -0.25f; x <= 0.25f; x += 0.25f) {
            for (float z = -0.25f; z <= 0.25f; z += 0.25f) {
                Sphere mechon = new Sphere(radioPelo * 0.5f, 10, 10);
                mechon.setColor(colorPelo);
                mechon.move(x, 2.0f + offsetY, offsetZ - z);
                partes.add(mechon);
            }
        }


        // --- MOÑO ROJO  ---
        Cono moñoIzq = new Cono(0.07f, 0.15f, 16);
        moñoIzq.setColorPart("all", new float[]{1f, 0f, 0f, 1});
        moñoIzq.move(-0.3f, 2.1f + offsetY, offsetZ + 0.4f);
        moñoIzq.scale(3f, 3f, -3f);
        moñoIzq.rotate(0, 0, -90);
        partes.add(moñoIzq);

        Cono moñoDer = new Cono(0.07f, 0.15f, 16);
        moñoDer.setColorPart("all", new float[]{1f, 0f, 0f, 1});
        moñoDer.move(0.3f, 2.1f + offsetY, offsetZ + 0.4f);
        moñoDer.scale(3f, 3f, -3f);
        moñoDer.rotate(0, 0, 90);
        partes.add(moñoDer);


        // --- OJOS Y MEJILLAS
        crearOjoSimple(-0.2f, partes, offsetY, offsetZ);
        crearOjoSimple(0.2f, partes, offsetY, offsetZ);

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
        cuerpo.setColor(new float[]{1f, 0.6f, 0.8f, 1});
        cuerpo.move(0f, (1.3f * escala) + offsetY, offsetZ);
        partes.add(cuerpo);

        // --- BRAZOS ---
        Cilindro brazoIzq = new Cilindro(6, 0.09f * escala, 0.6f * escala);
        brazoIzq.setColorPart("all", new float[]{1f, 0.85f, 0.75f, 1});
        brazoIzq.move(-0.3f * escala, (1.2f * escala) + offsetY, offsetZ);
        partes.add(brazoIzq);

        Cilindro brazoDer = new Cilindro(6, 0.09f * escala, 0.6f * escala);
        brazoDer.setColorPart("all", new float[]{1f, 0.85f, 0.75f, 1});
        brazoDer.move(0.3f * escala, (1.2f * escala) + offsetY, offsetZ);
        partes.add(brazoDer);

        // --- PIERNAS ---
        Cilindro piernaIzq = new Cilindro(6, 0.11f * escala, 0.85f * escala);
        piernaIzq.setColorPart("all", new float[]{0.2f, 0.4f, 1f, 1}

        );
        piernaIzq.move(-0.13f * escala, (0.7f * escala) + offsetY, offsetZ);
        partes.add(piernaIzq);

        Cilindro piernaDer = new Cilindro(6, 0.11f * escala, 0.85f * escala);
        piernaDer.setColorPart("all", new float[]{0.2f, 0.4f, 1f, 1}

        );
        piernaDer.move(0.13f * escala, (0.7f * escala) + offsetY, offsetZ);
        partes.add(piernaDer);

        // --- ZAPATOS ---
        Prisma zapatoIzq = new Prisma(0.2f * escala, 0.15f * escala, 0.2f * escala);
        zapatoIzq.setColor(new float[]{0.2f, 0f, 0.3f, 1});
        zapatoIzq.move(-0.13f * escala, (0.2f * escala) + offsetY, offsetZ);
        zapatoIzq.scale(1, 1, 2.2f);
        partes.add(zapatoIzq);

        Prisma zapatoDer = new Prisma(0.2f * escala, 0.15f * escala, 0.2f * escala);
        zapatoDer.setColor(new float[]{0.2f, 0f, 0.3f, 1});
        zapatoDer.move(0.13f * escala, (0.2f * escala) + offsetY, offsetZ);
        zapatoDer.scale(1, 1, 2.2f);
        partes.add(zapatoDer);
    }

    private void crearOjoSimple(float x, List<Figura> partes, float offsetY, float offsetZ) {
        float y = 1.62f + offsetY;
        float z = offsetZ + 0.4f;

        Sphere ojo = new Sphere(0.1f, 20, 20);
        ojo.setColor(new float[]{1f, 1f, 1f, 1});
        ojo.move(x, y, z);
        partes.add(ojo);

        Sphere pupila = new Sphere(0.04f, 20, 20);
        pupila.setColor(new float[]{0f, 0f, 0f, 1});
        pupila.move(x, y, z + 0.015f);
        partes.add(pupila);
    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}