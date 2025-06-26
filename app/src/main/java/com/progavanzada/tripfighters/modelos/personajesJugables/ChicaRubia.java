package com.progavanzada.tripfighters.modelos.personajesJugables;

import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;
import com.progavanzada.tripfighters.figuras.Sphere;

import java.util.ArrayList;
import java.util.List;

public class ChicaRubia {
    private List<Figura> partes;

    public ChicaRubia() {
        partes = new ArrayList<>();

        float offsetY = -0.2f;
        float offsetZ = -2f;
        float escala = 0.8f;

        // --- CABEZA ---
        Prisma cabeza = new Prisma(0.7f, 0.7f, 0.7f);
        cabeza.setColor(new float[]{1f, 0.85f, 0.75f, 1});
        cabeza.move(0f, 1.6f + offsetY, offsetZ);
        partes.add(cabeza);

        // --- OJOS ---
        crearOjoSimple(-0.2f, partes, offsetY, offsetZ, true);
        crearOjoSimple(0.2f, partes, offsetY, offsetZ, true);

        // --- MEJILLAS ---
        Sphere mejillaIzq = new Sphere(0.045f, 10, 10);
        mejillaIzq.setColor(new float[]{1f, 0.6f, 0.7f, 1});
        mejillaIzq.move(-0.3f * escala, (1.75f * escala) + offsetY, offsetZ + 0.37f);
        partes.add(mejillaIzq);

        Sphere mejillaDer = new Sphere(0.045f, 10, 10);
        mejillaDer.setColor(new float[]{1f, 0.6f, 0.7f, 1});
        mejillaDer.move(0.3f * escala, (1.75f * escala) + offsetY, offsetZ + 0.37f);
        partes.add(mejillaDer);

        // --- CUERPO ---
        Prisma cuerpo = new Prisma(0.45f * escala, 0.5f * escala, 0.7f * escala);
        cuerpo.setColor(new float[]{0.6f, 0.8f, 1f, 1});
        cuerpo.move(0f, (1.3f * escala) + offsetY, offsetZ);
        partes.add(cuerpo);

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
        mangaIzq.setColor(new float[]{0.6f, 0.8f, 1f, 1});
        mangaIzq.move(-0.3f * escala, (1.4f * escala) + offsetY, offsetZ);
        mangaIzq.scale(1.5f, 1.5f, 1.5f);
        partes.add(mangaIzq);

        Prisma mangaDer = new Prisma(0.13f * escala, 0.13f * escala, 0.13f * escala);
        mangaDer.setColor(new float[]{0.6f, 0.8f, 1f, 1});
        mangaDer.move(0.3f * escala, (1.4f * escala) + offsetY, offsetZ);
        mangaDer.scale(1.5f, 1.5f, 1.5f);
        partes.add(mangaDer);

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
        piernaIzq.setColorPart("all", new float[]{1f, 0.2f, 0.6f, 1}
        );
        piernaIzq.move(-0.13f * escala, (0.7f * escala) + offsetY, offsetZ);
        partes.add(piernaIzq);

        Cilindro piernaDer = new Cilindro(6, 0.11f * escala, 0.85f * escala);
        piernaDer.setColorPart("all", new float[]{1f, 0.2f, 0.6f, 1}
        );
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

        // --- PELO
        agregarCabelloFrondoso(partes, offsetY, offsetZ);
    }

    private void agregarCabelloFrondoso(List<Figura> partes, float offsetY, float offsetZ) {
        float[] rubio = new float[]{1f, 0.9f, 0.4f, 1};
        float yBase = 1.6f + offsetY;
        float zBase = offsetZ;

        for (float x = -0.3f; x <= 0.3f; x += 0.15f) {
            for (float z = -0.3f; z <= 0.3f; z += 0.15f) {
                float y = 0.42f;
                partes.add(crearEsferaCabello(x, yBase + y, zBase + z, 0.16f, rubio));
            }
        }

        float[] xLados = new float[]{-0.4f, -0.35f, 0.35f, 0.4f};
        float[] yLados = new float[]{0.25f, 0.05f, -0.15f, -0.35f, -0.55f};

        for (float x : xLados) {
            for (float y : yLados) {
                float z = zBase + 0.05f;
                float radio = 0.18f;


                if (y <= -0.35f) {
                    radio = 0.16f;
                }

                partes.add(crearEsferaCabello(x, yBase + y + 0.3f, z, radio, rubio));
            }
        }



        // --- Cabello
        float[] xNuca = new float[]{-0.3f, -0.15f, 0f, 0.15f, 0.3f};
        float[] yNuca = new float[]{0.1f, -0.1f, -0.3f, -0.5f, -0.7f, -0.9f};

        for (float x : xNuca) {
            for (float y : yNuca) {
                float z = zBase - 0.25f - (0.05f * Math.abs(x));
                float radio = 0.16f;

                if (y <= -0.7f) {
                    radio = 0.14f;
                } else if (y <= -0.5f) {
                    radio = 0.15f;
                }

                partes.add(crearEsferaCabello(x, yBase + y + 0.3f, z, radio, rubio));
            }
        }



        float[][] esquinas = new float[][] {
                {-0.35f, yBase + 0.25f, zBase - 0.2f},
                {0.35f, yBase + 0.25f, zBase - 0.2f},
                {-0.35f, yBase + 0.0f, zBase - 0.2f},
                {0.35f, yBase + 0.0f, zBase - 0.2f}
        };
        for (float[] pos : esquinas) {
            partes.add(crearEsferaCabello(pos[0], pos[1], pos[2], 0.15f, rubio));
        }
    }



    private Sphere crearEsferaCabello(float x, float y, float z, float radio, float[] color) {
        Sphere pelo = new Sphere(radio, 10, 10);
        pelo.setColor(color);
        pelo.move(x, y, z);
        return pelo;
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