package com.progavanzada.tripfighters.modelos.escenas;

import com.progavanzada.tripfighters.figuras.*;
import java.util.ArrayList;
import java.util.List;

public class ArenaLuchaInfernal {
    private List<Figura> elementos;

    // Paleta de colores infernales mejorada
    private final float[] NEGRO_CARBON = {0.08f, 0.06f, 0.07f, 1.0f};
    private final float[] ROJO_PROFUNDO = {0.7f, 0.15f, 0.1f, 1.0f};
    private final float[] LAVA_ARDIENTE = {0.95f, 0.4f, 0.1f, 0.9f};
    private final float[] ORO_MALDITO = {0.8f, 0.6f, 0.2f, 1.0f};
    private final float[] HUESO_ANTIGUO = {0.75f, 0.7f, 0.6f, 1.0f};

    public ArenaLuchaInfernal() {
        elementos = new ArrayList<>();
        construirArena();
        agregarElementosEstrategicos();
    }

    private void construirArena() {
        // Suelo principal con textura de grietas
        Prisma suelo = new Prisma(20f, 20f, 0.5f);
        suelo.move(0f, -2f, 0f);
        suelo.setColor(NEGRO_CARBON);
        elementos.add(suelo);

        // Patrón de grietas luminosas (visibles desde la cámara alta)
        for (int i = 0; i < 72; i++) {
            double angulo = Math.toRadians(i * 5);
            float longitud = 5f + (float)Math.random() * 5f;

            Prisma grieta = new Prisma(longitud, 0.15f, 0.1f);
            grieta.move(
                    (float)(Math.cos(angulo) * longitud/2),
                    -1.9f,
                    (float)(Math.sin(angulo) * longitud/2)
            );
            grieta.rotate(0f, (float)Math.toDegrees(angulo), 0f);
            grieta.setColor(LAVA_ARDIENTE);
            elementos.add(grieta);
        }

        // Muro perimetral con detalles góticos
        float alturaMuro = 4f;
        for (int i = 0; i < 4; i++) {
            Prisma muro = new Prisma(i % 2 == 0 ? 20f : 1f,
                    i % 2 == 0 ? 1f : 20f,
                    alturaMuro);
            muro.move(
                    i % 2 == 0 ? 0 : i == 1 ? 9.5f : -9.5f,
                    alturaMuro/2 - 2f,
                    i % 2 != 0 ? 0 : i == 0 ? 9.5f : -9.5f
            );
            muro.setColor(ROJO_PROFUNDO);
            elementos.add(muro);

            // Almenas
            if (i % 2 == 0) {
                for (int j = -9; j <= 9; j += 2) {
                    Prisma almena = new Prisma(0.8f, 0.8f, 0.5f);
                    almena.move(j, alturaMuro - 1.5f, i == 0 ? 9.5f : -9.5f);
                    almena.setColor(HUESO_ANTIGUO);
                    elementos.add(almena);
                }
            }
        }
    }

    private void agregarElementosEstrategicos() {
        // Columnas rituales en las esquinas (visibles desde lejos)
        float[][] posicionesEsquinas = {
                {-8f, 0f, -8f}, {8f, 0f, -8f},
                {-8f, 0f, 8f}, {8f, 0f, 8f}
        };

        for (float[] pos : posicionesEsquinas) {
            // Columna principal
            Cilindro columna = new Cilindro(16, 0.6f, 6f);
            columna.move(pos[0], 1f, pos[1]);
            columna.setColorPart("all",ORO_MALDITO);
            elementos.add(columna);

            // Anillos de sacrificio
            for (int i = 0; i < 3; i++) {
                Torus anillo = new Torus(16, 0.8f, 0.1f);
                anillo.move(pos[0], 0.5f + i * 2f, pos[1]);
                anillo.setColor(ROJO_PROFUNDO);
                elementos.add(anillo);
            }

            // Cráneos en la base
            for (int i = 0; i < 4; i++) {
                Sphere craneo = new Sphere(0.3f, 8, 8);
                craneo.move(
                        pos[0] + (float)Math.cos(i * Math.PI/2) * 1.2f,
                        0f,
                        pos[1] + (float)Math.sin(i * Math.PI/2) * 1.2f
                );
                craneo.setColor(HUESO_ANTIGUO);
                elementos.add(craneo);
            }
        }

        // Foso de lava central (para contraste visual)
        Torus fosoLava = new Torus(64, 5f, 1f);
        fosoLava.move(0f, -1.5f, 0f);
        fosoLava.rotate(90f, 0f, 0f);
        fosoLava.setColor(LAVA_ARDIENTE);
        elementos.add(fosoLava);

        // Puentes de hueso sobre la lava
        for (int i = 0; i < 4; i++) {
            Prisma puente = new Prisma(6f, 1f, 0.2f);
            puente.move(
                    (float)(Math.cos(i * Math.PI/2) * 3f),
                    -1.3f,
                    (float)(Math.sin(i * Math.PI/2) * 3f)
            );
            puente.rotate(0f, i * 90f, 0f);
            puente.setColor(HUESO_ANTIGUO);
            elementos.add(puente);
        }
    }

    public void draw(float[] mvpMatrix) {


        for (Figura figura : elementos) {
            figura.draw(mvpMatrix);
        }
    }
}