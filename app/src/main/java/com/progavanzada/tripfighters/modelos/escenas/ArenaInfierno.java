package com.progavanzada.tripfighters.modelos.escenas;

import com.progavanzada.tripfighters.figuras.*;
import java.util.ArrayList;
import java.util.List;

public class ArenaInfierno {
    private List<Figura> elementos;

    // Paleta de colores infernales
    private final float[] COLOR_PARED = {0.15f, 0.15f, 0.15f, 1.0f};     // Negro carbón
    private final float[] COLOR_FUEGO = {1.0f, 0.4f, 0.0f, 1.0f};        // Naranja ardiente
    private final float[] COLOR_LAVA = {0.9f, 0.6f, 0.2f, 1.0f};         // Lava brillante
    private final float[] COLOR_CADENA = {0.2f, 0.2f, 0.2f, 1.0f};       // Gris oscuro metálico
    private final float[] COLOR_CRANEO = {0.8f, 0.8f, 0.8f, 1.0f};       // Blanco hueso

    public ArenaInfierno() {
        elementos = new ArrayList<>();
        construirBase();
        construirMuros();
        crearColumnasDiabolicas();
        colocarFososDeLava();
        agregarAntorchas();
        decorarConCadenas();
    }

    // Base principal de la arena
    private void construirBase() {
        Prisma base = new Prisma(12f, 12f, 0.5f);
        base.move(0f, -1.5f, 0f);
        base.setColor(COLOR_PARED);
        elementos.add(base);
    }

    // Muros alrededor de la arena
    private void construirMuros() {
        float largo = 12f;
        float ancho = 0.5f;
        float alto = 4f;

        for (int i = 0; i < 4; i++) {
            Prisma muro = new Prisma(i % 2 == 0 ? largo : ancho,
                    i % 2 == 0 ? ancho : largo,
                    alto);
            muro.move(
                    i == 0 ? 0f : i == 1 ? 0f : i == 2 ? -largo / 2 + ancho / 2 : largo / 2 - ancho / 2,
                    alto / 2 - 1.5f,
                    i == 0 ? -largo / 2 + ancho / 2 : i == 1 ? largo / 2 - ancho / 2 : 0f
            );
            muro.setColor(COLOR_PARED);
            elementos.add(muro);
        }
    }

    // Columnas con caras demoníacas
    private void crearColumnasDiabolicas() {
        float radio = 0.6f;
        float altura = 5f;

        // Posiciones en esquinas
        float[][] posiciones = {
                {-5f, 0f, -5f},
                {5f, 0f, -5f},
                {-5f, 0f, 5f},
                {5f, 0f, 5f}
        };

        for (float[] pos : posiciones) {
            Cilindro columna = new Cilindro(16, radio, altura);
            columna.move(pos[0], pos[1] + altura / 2 - 1.5f, pos[2]);
            columna.setColorPart("all",COLOR_PARED);
            elementos.add(columna);

            // Ojo izquierdo
            Sphere ojoIzq = new Sphere(0.15f, 8, 8);
            ojoIzq.move(pos[0] - 0.2f, pos[1] + altura - 1.5f, pos[2] + 0.4f);
            ojoIzq.setColor(COLOR_FUEGO);
            elementos.add(ojoIzq);

            // Ojo derecho
            Sphere ojoDer = new Sphere(0.15f, 8, 8);
            ojoDer.move(pos[0] + 0.2f, pos[1] + altura - 1.5f, pos[2] + 0.4f);
            ojoDer.setColor(COLOR_FUEGO);
            elementos.add(ojoDer);

            // Boca abierta
            Prisma boca = new Prisma(0.8f, 0.3f, 0.4f);
            boca.move(pos[0], pos[1] + altura - 2.5f, pos[2] + 0.5f);
            boca.setColor(COLOR_FUEGO);
            elementos.add(boca);
        }
    }

    // Fosos de lava alrededor del centro
    private void colocarFososDeLava() {
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                if (i == j) continue; // evitar esquina central

                Torus zanja = new Torus(32, 3f, 0.4f);
                zanja.move(i * 4f, -1.3f, j * 4f);
                zanja.rotate(90f, 0f, 0f);
                zanja.setColor(COLOR_LAVA);
                elementos.add(zanja);

                // Rocas flotantes
                for (int k = 0; k < 6; k++) {
                    Sphere roca = new Sphere(0.2f + (float)Math.random() * 0.1f, 6, 6);
                    roca.move(
                            i * 4f + (float)(Math.cos(k * Math.PI / 3) * 2.5f),
                            -1.1f,
                            j * 4f + (float)(Math.sin(k * Math.PI / 3) * 0.7f)
                    );
                    roca.setColor(COLOR_PARED);
                    elementos.add(roca);
                }
            }
        }
    }

    // Antorchas infernales en las esquinas
    private void agregarAntorchas() {
        float[][] posiciones = {
                {-5.5f, -1f, -5.5f},
                {5.5f, -1f, -5.5f},
                {-5.5f, -1f, 5.5f},
                {5.5f, -1f, 5.5f}
        };

        for (float[] pos : posiciones) {
            // Base de la antorcha
            Cilindro base = new Cilindro(8, 0.2f, 1f);
            base.move(pos[0], pos[1] + 0.5f, pos[2]);
            base.setColorPart("all",COLOR_CADENA);
            elementos.add(base);

            // Fuego
            for (int i = 0; i < 3; i++) {
                Cono llama = new Cono(0.3f - i * 0.05f, 0.7f - i * 0.2f, 6);
                llama.move(pos[0], pos[1] + 1.2f + i * 0.2f, pos[2]);
                llama.setColorPart("all",new float[]{1f, 0.5f + i * 0.1f, 0.1f, 0.8f});
                elementos.add(llama);
            }
        }
    }

    // Cadenas colgando de los muros con cráneos
    private void decorarConCadenas() {
        for (int x = -4; x <= 4; x++) {
            if (x == 0) continue;

            // Cadena vertical
            for (int i = 0; i < 6; i++) {
                Torus eslabon = new Torus(8, 0.08f, 0.04f);
                eslabon.move(x * 1.2f, 2f - i * 0.25f, -6.2f);
                eslabon.rotate(90f, 0f, 0f);
                eslabon.setColor(COLOR_CADENA);
                elementos.add(eslabon);
            }

            // Cráneo final
            Sphere craneo = new Sphere(0.25f, 8, 8);
            craneo.move(x * 1.2f, 0.4f, -6.2f);
            craneo.setColor(COLOR_CRANEO);
            elementos.add(craneo);
        }
    }

    // Método para dibujar toda la escena
    public void draw(float[] mvpMatrix) {
        for (Figura figura : elementos) {
            figura.draw(mvpMatrix);
        }
    }
}