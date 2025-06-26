package com.progavanzada.tripfighters.modelos.personajesJugables;

import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;
import com.progavanzada.tripfighters.figuras.Sphere;

import java.util.ArrayList;
import java.util.List;

public class ChicoGamer {
    private List<Figura> partes;

    public ChicoGamer() {
        partes = new ArrayList<>();

        float offsetY = -0.2f;
        float offsetZ = -2f;
        float escala = 0.8f;

        // --- CABEZA ---
        Prisma cabeza = new Prisma(0.7f, 0.7f, 0.7f);
        cabeza.setColor(new float[]{1f, 0.8f, 0.85f, 1});
        cabeza.move(0f, 1.6f + offsetY, offsetZ);
        partes.add(cabeza);

        // --- OJOS ---
        crearOjoSimple(-0.2f, partes, offsetY, offsetZ, true);
        crearOjoSimple(0.2f, partes, offsetY, offsetZ, true);

        // --- CUERPO ---
        Prisma cuerpo = new Prisma(0.45f * escala, 0.5f * escala, 0.7f * escala);
        cuerpo.setColor(new float[]{0.1f, 0.1f, 0.1f, 1});
        cuerpo.move(0f, (1.3f * escala) + offsetY, offsetZ);
        partes.add(cuerpo);

        // --- CAMISETA ---
        Prisma camiseta = new Prisma(0.45f * escala, 0.5f * escala, 0.05f * escala);
        camiseta.setColor(new float[]{0f, 0.2f, 0.4f, 1});
        camiseta.move(0f, (escala) + offsetY, offsetZ);
        partes.add(camiseta);

        // Detalle
        Prisma detalleNeon = new Prisma(0.45f * escala, 0.02f * escala, 0.1f * escala);
        detalleNeon.setColor(new float[]{0f, 1f, 0f, 1});
        detalleNeon.move(0f, (escala) + offsetY +0.15f, offsetZ + 0.2f);
        partes.add(detalleNeon);

        Prisma detalleNeon2 = new Prisma(0.45f * escala, 0.02f * escala, 0.1f * escala);
        detalleNeon2.setColor(new float[]{0f, 1f, 0f, 1});
        detalleNeon2.move(0f, (escala) + offsetY +0.15f, offsetZ - 0.2f);
        partes.add(detalleNeon2);


        // --- BRAZOS (sin mangas largas) ---
        Cilindro brazoIzq = new Cilindro(6, 0.09f * escala, 0.6f * escala);
        brazoIzq.setColorPart("all", new float[]{1f, 0.8f, 0.85f, 1});
        brazoIzq.move(-0.3f * escala, (1.2f * escala) + offsetY, offsetZ);
        partes.add(brazoIzq);

        Cilindro brazoDer = new Cilindro(6, 0.09f * escala, 0.6f * escala);
        brazoDer.setColorPart("all", new float[]{1f, 0.8f, 0.85f, 1});
        brazoDer.move(0.3f * escala, (1.2f * escala) + offsetY, offsetZ);
        partes.add(brazoDer);

        // --- PIERNAS ---
        Cilindro piernaIzq = new Cilindro(6, 0.11f * escala, 0.85f * escala);
        piernaIzq.setColorPart("all", new float[]{0.1f, 0.1f, 0.1f, 1});
        piernaIzq.move(-0.13f * escala, (0.7f * escala) + offsetY, offsetZ);
        partes.add(piernaIzq);

        Cilindro piernaDer = new Cilindro(6, 0.11f * escala, 0.85f * escala);
        piernaDer.setColorPart("all", new float[]{0.1f, 0.1f, 0.1f, 1});
        piernaDer.move(0.13f * escala, (0.7f * escala) + offsetY, offsetZ);
        partes.add(piernaDer);

        // --- ZAPATOS ---
        Prisma zapatoIzq = new Prisma(0.2f * escala, 0.15f * escala, 0.2f * escala);
        zapatoIzq.setColor(new float[]{0.1f, 0.1f, 0.1f, 1});
        zapatoIzq.move(-0.13f * escala, (0.2f * escala) + offsetY, offsetZ);
        zapatoIzq.scale(1, 1, 2.2f);
        partes.add(zapatoIzq);

        Prisma zapatoDer = new Prisma(0.2f * escala, 0.15f * escala, 0.2f * escala);
        zapatoDer.setColor(new float[]{0.1f, 0.1f, 0.1f, 1});
        zapatoDer.move(0.13f * escala, (0.2f * escala) + offsetY, offsetZ);
        zapatoDer.scale(1, 1, 2.2f);
        partes.add(zapatoDer);

        // --- AUDÍFONOS ---
        Cilindro audifonoIzq = new Cilindro(12, 0.15f, 0.25f);
        audifonoIzq.setColorPart("all", new float[]{0f, 0f, 0f, 1});
        audifonoIzq.move(-0.35f, 1.8f + offsetY, offsetZ);
        partes.add(audifonoIzq);

        Cilindro audifonoDer = new Cilindro(12, 0.15f, 0.25f);
        audifonoDer.setColorPart("all", new float[]{0f, 0f, 0f, 1});
        audifonoDer.move(0.35f, 1.8f + offsetY, offsetZ);
        partes.add(audifonoDer);

        Prisma barraAudifonos = new Prisma(1.2f, 0.03f, 0.03f);
        barraAudifonos.setColor(new float[]{0f, 0f, 0f, 1});

        barraAudifonos.move(0f, 2.0f + offsetY, offsetZ);
        barraAudifonos.scale(0.75f,1.3f,1.3f);
        partes.add(barraAudifonos);
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