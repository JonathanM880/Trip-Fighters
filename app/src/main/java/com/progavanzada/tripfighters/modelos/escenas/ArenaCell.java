package com.progavanzada.tripfighters.modelos.escenas;

import com.progavanzada.tripfighters.figuras.*;
import java.util.ArrayList;
import java.util.List;

public class ArenaCell {
    private List<Figura> elementos;

    // Paleta de colores naturales
    private final float[] COLOR_PLATA = {0.8f, 0.8f, 0.9f, 1.0f};     // Plata brillante
    private final float[] COLOR_TIERRA = {0.8f, 0.6f, 0.4f, 1.0f};    // Suelo arenoso
    private final float[] COLOR_HIERBA = {0.2f, 0.8f, 0.2f, 1.0f};     // Verde hierba
    private final float[] COLOR_CELESTE = {0.5f, 0.8f, 1.0f, 1.0f};    // Azul claro para el cielo
    private final float[] COLOR_PILAR = {1.0f, 1.0f, 1.0f, 1.0f};      // Blanco brillante

    public ArenaCell() {
        elementos = new ArrayList<>();
        construirPlataforma();
        agregarPilares();
        decorarConFondoNatural();
    }

    // Plataforma de combate
    private void construirPlataforma() {
        Prisma plataforma = new Prisma(16f, 16f, 0.3f);
        plataforma.move(0f, 0f, 0f);
        plataforma.setColor(COLOR_PLATA);
        elementos.add(plataforma);

        // Malla de rejilla (detalles visuales)
        for (int i = -8; i <= 8; i++) {
            for (int j = -8; j <= 8; j++) {
                Prisma rejilla = new Prisma(0.2f, 0.2f, 0.2f);
                rejilla.move(i * 1.0f, -0.1f, j * 1.0f);
                rejilla.setColor(COLOR_PLATA);
                elementos.add(rejilla);
            }
        }
    }

    // Pilares altos en las esquinas
    private void agregarPilares() {
        float[][] posiciones = {
                {-8f, 0f, -8f},
                {8f, 0f, -8f},
                {-8f, 0f, 8f},
                {8f, 0f, 8f}
        };

        for (float[] pos : posiciones) {
            Cilindro pilarBase = new Cilindro(16, 0.5f, 2f);
            pilarBase.move(pos[0], 0f, pos[2]);
            pilarBase.setColorPart("all",COLOR_PILAR);
            elementos.add(pilarBase);

            Cono pilarSuperior = new Cono(0.5f, 4f, 16);
            pilarSuperior.move(pos[0], 2f, pos[2]);
            pilarSuperior.setColorPart("all",COLOR_PILAR);
            elementos.add(pilarSuperior);
        }
    }

    // Fondo natural: montañas, cielo y suelo
    private void decorarConFondoNatural() {
        // Suelo arenoso
        Prisma suelo = new Prisma(32f, 32f, 0.1f);
        suelo.move(0f, -1.5f, 0f);
        suelo.setColor(COLOR_TIERRA);
        elementos.add(suelo);

        // Hierba alrededor
        for (int i = -16; i <= 16; i++) {
            for (int j = -16; j <= 16; j++) {
                if (Math.abs(i) > 8 || Math.abs(j) > 8) {
                    Sphere hierba = new Sphere(0.1f + (float)Math.random() * 0.1f, 8, 8);
                    hierba.move(i * 1.2f, -1.4f, j * 1.2f);
                    hierba.setColor(COLOR_HIERBA);
                    elementos.add(hierba);
                }
            }
        }

        // Montañas lejanas
        for (int i = -16; i <= 16; i += 4) {
            Prisma montaña = new Prisma(2f, 2f, 0.2f);
            montaña.move(i * 2f, 0f, -16f);
            montaña.setColor(new float[]{0.5f, 0.5f, 0.5f, 1.0f}); // Gris oscuro
            elementos.add(montaña);
        }

        // Cielo azul
        Prisma cielo = new Prisma(32f, 32f, 0.1f);
        cielo.move(0f, 16f, 0f);
        cielo.setColor(COLOR_CELESTE);
        elementos.add(cielo);
    }

    // Método para dibujar toda la escena
    public void draw(float[] mvpMatrix) {
        for (Figura figura : elementos) {
            figura.draw(mvpMatrix);
        }
    }
}