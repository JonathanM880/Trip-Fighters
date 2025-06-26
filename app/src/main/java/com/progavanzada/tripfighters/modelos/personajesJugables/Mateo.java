package com.progavanzada.tripfighters.modelos.personajesJugables;

import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;
import com.progavanzada.tripfighters.figuras.Sphere;

import java.util.ArrayList;
import java.util.List;

public class Mateo {
    private List<Figura> partes;

    public Mateo() {
        partes = new ArrayList<>();

        float offsetY = -0.2f;
        float offsetZ = -2f;
        float escala = 0.8f;
        float[] pielMorena = new float[]{0.35f, 0.2f, 0.1f, 1f};

        // --- CABEZA ---
        Prisma cabeza = new Prisma(0.7f, 0.7f, 0.7f);
        cabeza.setColor(pielMorena);
        cabeza.move(0f, 1.6f + offsetY, offsetZ);
        partes.add(cabeza);

        // --- OJOS ---
        crearOjoSimple(-0.2f, partes, offsetY, offsetZ, true);
        crearOjoSimple(0.2f, partes, offsetY, offsetZ, true);

        // --- CUERPO ---
        Prisma cuerpo = new Prisma(0.45f * escala, 0.5f * escala, 0.7f * escala);
        cuerpo.setColor(new float[]{0.2f, 0.3f, 0.4f, 1});
        cuerpo.move(0f, (1.3f * escala) + offsetY, offsetZ);
        partes.add(cuerpo);

        // --- CAMISETA DETALLE ---
        Prisma detalle = new Prisma(0.4f * escala, 0.02f * escala, 0.12f * escala);
        detalle.setColor(new float[]{1f, 0.6f, 0f, 1});
        detalle.move(0f, (1.35f * escala) + offsetY, offsetZ + 0.25f);
        partes.add(detalle);

        // --- BRAZOS ---
        Cilindro brazoIzq = new Cilindro(6, 0.09f * escala, 0.6f * escala);
        brazoIzq.setColorPart("all", pielMorena);
        brazoIzq.move(-0.3f * escala, (1.2f * escala) + offsetY, offsetZ);
        partes.add(brazoIzq);

        Cilindro brazoDer = new Cilindro(6, 0.09f * escala, 0.6f * escala);
        brazoDer.setColorPart("all", pielMorena);
        brazoDer.move(0.3f * escala, (1.2f * escala) + offsetY, offsetZ);
        partes.add(brazoDer);

        // --- PIERNAS ---
        float[] pantalonColor = new float[]{0.1f, 0.1f, 0.1f, 1};
        Cilindro piernaIzq = new Cilindro(6, 0.11f * escala, 0.85f * escala);
        piernaIzq.setColorPart("all", pantalonColor);
        piernaIzq.move(-0.13f * escala, (0.7f * escala) + offsetY, offsetZ);
        partes.add(piernaIzq);

        Cilindro piernaDer = new Cilindro(6, 0.11f * escala, 0.85f * escala);
        piernaDer.setColorPart("all", pantalonColor);
        piernaDer.move(0.13f * escala, (0.7f * escala) + offsetY, offsetZ);
        partes.add(piernaDer);

        // --- ZAPATOS ---
        float[] colorZapatos = new float[]{0f, 0f, 0f, 1};
        Prisma zapatoIzq = new Prisma(0.2f * escala, 0.15f * escala, 0.2f * escala);
        zapatoIzq.setColor(colorZapatos);
        zapatoIzq.move(-0.13f * escala, (0.2f * escala) + offsetY, offsetZ);
        zapatoIzq.scale(1, 1, 2.2f);
        partes.add(zapatoIzq);

        Prisma zapatoDer = new Prisma(0.2f * escala, 0.15f * escala, 0.2f * escala);
        zapatoDer.setColor(colorZapatos);
        zapatoDer.move(0.13f * escala, (0.2f * escala) + offsetY, offsetZ);
        zapatoDer.scale(1, 1, 2.2f);
        partes.add(zapatoDer);

        // --- CABELLO AFRO ---
        agregarCabelloAfro(partes, offsetY, offsetZ);
    }

    private void agregarCabelloAfro(List<Figura> partes, float offsetY, float offsetZ) {
        float radioAfro = 0.5f;
        float yCentro = 2.05f + offsetY;
        float xCentro = 0f;
        float zCentro = offsetZ;

        float[] colorPelo = new float[]{0.05f, 0.05f, 0.05f, 1};

        int pasos = 3; // Menos pasos = menos esferas
        float spacing = 0.14f;

        for (int i = -pasos; i <= pasos; i++) {
            for (int j = -pasos; j <= pasos; j++) {
                for (int k = -pasos; k <= pasos; k++) {
                    float x = i * spacing;
                    float y = j * spacing;
                    float z = k * spacing;

                    float distancia = (float) Math.sqrt(x * x + y * y + z * z);
                    if (distancia <= radioAfro + 0.05f && distancia >= radioAfro - 0.15f && y + yCentro >= 1.85f + offsetY) {
                        Sphere rizo = new Sphere(0.13f, 6, 6);
                        rizo.setColor(colorPelo);
                        rizo.move(xCentro + x, yCentro + y, zCentro + z);
                        partes.add(rizo);
                    }
                }
            }
        }
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