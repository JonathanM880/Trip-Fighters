package com.progavanzada.tripfighters.modelos.escenas;

import com.progavanzada.tripfighters.figuras.*;
import java.util.ArrayList;
import java.util.List;

public class ArenaLegendaria {
    private List<Figura> elementos;

    // Paleta de colores legendarios
    private final float[] COLOR_DORADO = {1.0f, 0.8f, 0.2f, 1.0f};       // Dorado brillante
    private final float[] COLOR_AZUL_CRYSTAL = {0.2f, 0.6f, 1.0f, 1.0f}; // Azul cristalino
    private final float[] COLOR_ROJO_REY = {1.0f, 0.2f, 0.2f, 1.0f};     // Rojo real
    private final float[] COLOR_VERDE_ESMERALDA = {0.2f, 0.8f, 0.4f, 1.0f}; // Verde esmeralda
    private final float[] COLOR_BLANCO = {0.9f, 0.9f, 0.9f, 1.0f};       // Blanco puro
    private final float[] COLOR_VIOLETA = {0.7f, 0.3f, 0.9f, 1.0f};      // Violeta místico
    private final float[] COLOR_GRIS_CLARO = {0.7f, 0.7f, 0.7f, 1.0f};   // Gris claro para detalles

    public ArenaLegendaria() {
        elementos = new ArrayList<>();
        construirSuelo();
        crearEntradaReal();
        agregarTorresOrnamentales();
        colocarFuentesMagicas();
        agregarBanderasReales();
        agregarEstatuasReales();
        agregarLucesFlotantes();
        añadirRunasBrillantes();
        crearEscalinataPrincipal();
        colocarTrofeosAlrededor();
    }

    // Suelo tipo mosaico brillante
    private void construirSuelo() {
        Prisma base = new Prisma(16f, 16f, 0.3f);
        base.move(0f, -1.5f, 0f);
        base.setColor(COLOR_AZUL_CRYSTAL);
        elementos.add(base);

        // Mosaico central
        for (int i = 0; i < 8; i++) {
            Prisma pieza = new Prisma(0.8f, 0.8f, 0.1f);
            pieza.move(
                    (float)(Math.cos(i * Math.PI / 4) * 1.5f),
                    -1.1f,
                    (float)(Math.sin(i * Math.PI / 4) * 1.5f)
            );
            pieza.setColor(i % 2 == 0 ? COLOR_DORADO : COLOR_BLANCO);
            elementos.add(pieza);
        }
    }

    // Entrada Real con puertas doradas
    private void crearEntradaReal() {
        Prisma puertaCentral = new Prisma(2f, 4f, 0.2f);
        puertaCentral.move(0f, 1f, -8f);
        puertaCentral.setColor(COLOR_DORADO);
        elementos.add(puertaCentral);

        for (int i = -1; i <= 1; i += 2) {
            Cilindro columna = new Cilindro(16, 0.5f, 4f);
            columna.move(i * 2f, 2f, -8f);
            columna.setColorPart("all",COLOR_DORADO);
            elementos.add(columna);

            Sphere ornamento = new Sphere(0.3f, 8, 8);
            ornamento.move(i * 2f, 4f, -8f);
            ornamento.setColor(COLOR_DORADO);
            elementos.add(ornamento);
        }

        for (int i = 0; i < 5; i++) {
            Prisma escalon = new Prisma(4f, 0.2f, 0.2f);
            escalon.move(0f, -1.5f + i * 0.5f, -8f + i * 0.5f);
            escalon.setColor(COLOR_DORADO);
            elementos.add(escalon);
        }
    }

    // Torres ornamentales en las esquinas
    private void agregarTorresOrnamentales() {
        float[][] posiciones = {
                {-7f, 0f, -7f},
                {7f, 0f, -7f},
                {-7f, 0f, 7f},
                {7f, 0f, 7f}
        };

        for (float[] pos : posiciones) {
            // Base de la torre
            Prisma base = new Prisma(1.5f, 1.5f, 0.3f);
            base.move(pos[0], pos[1] - 1.3f, pos[2]);
            base.setColor(COLOR_GRIS_CLARO);
            elementos.add(base);

            // Columna central
            Cilindro columna = new Cilindro(16, 0.4f, 4f);
            columna.move(pos[0], pos[1] + 1.5f, pos[2]);
            columna.setColorPart("all",COLOR_BLANCO);
            elementos.add(columna);

            // Corona superior
            Prisma corona = new Prisma(0.6f, 0.6f, 0.2f);
            corona.move(pos[0], pos[1] + 3.7f, pos[2]);
            corona.setColor(COLOR_DORADO);
            elementos.add(corona);
        }
    }

    // Fuentes mágicas centrales
    private void colocarFuentesMagicas() {
        Torus fuente = new Torus(32, 2f, 0.2f);
        fuente.move(0f, -1.2f, 0f);
        fuente.rotate(90f, 0f, 0f);
        fuente.setColor(COLOR_AZUL_CRYSTAL);
        elementos.add(fuente);

        for (int i = 0; i < 4; i++) {
            Cono aguaFluyendo = new Cono(0.5f - i * 0.1f, 1.0f - i * 0.2f, 8);
            aguaFluyendo.move(
                    (float)(Math.cos(i * Math.PI / 2) * 2f),
                    -0.5f,
                    (float)(Math.sin(i * Math.PI / 2) * 2f)
            );
            aguaFluyendo.setColorPart("all",COLOR_AZUL_CRYSTAL);
            elementos.add(aguaFluyendo);
        }
    }

    // Banderas reales en las esquinas
    private void agregarBanderasReales() {
        float[][] posiciones = {
                {-6f, 2f, -7f},
                {6f, 2f, -7f},
                {-6f, 2f, 7f},
                {6f, 2f, 7f}
        };

        for (float[] pos : posiciones) {
            Prisma banderaRoja = new Prisma(0.2f, 2f, 0.2f);
            banderaRoja.move(pos[0], pos[1], pos[2]);
            banderaRoja.setColor(COLOR_ROJO_REY);
            elementos.add(banderaRoja);

            Prisma banderaVerde = new Prisma(0.2f, 2f, 0.2f);
            banderaVerde.move(pos[0], pos[1], pos[2] + 1f);
            banderaVerde.setColor(COLOR_VERDE_ESMERALDA);
            elementos.add(banderaVerde);
        }
    }

    // Estatuas reales en las esquinas
    private void agregarEstatuasReales() {
        float[][] posiciones = {
                {-6f, -1f, -6f},
                {6f, -1f, -6f},
                {-6f, -1f, 6f},
                {6f, -1f, 6f}
        };

        for (float[] pos : posiciones) {
            Cilindro cuerpo = new Cilindro(16, 0.5f, 2f);
            cuerpo.move(pos[0], pos[1] + 1f, pos[2]);
            cuerpo.setColorPart("all",COLOR_BLANCO);
            elementos.add(cuerpo);

            Sphere cabeza = new Sphere(0.3f, 8, 8);
            cabeza.move(pos[0], pos[1] + 2.5f, pos[2]);
            cabeza.setColor(COLOR_BLANCO);
            elementos.add(cabeza);

            Cilindro corona = new Cilindro(16, 0.4f, 0.1f);
            corona.move(pos[0], pos[1] + 2.7f, pos[2]);
            corona.setColorPart("all",COLOR_DORADO);
            elementos.add(corona);
        }
    }

    // Luces flotantes místicas
    private void agregarLucesFlotantes() {
        for (int i = 0; i < 6; i++) {
            Sphere luz = new Sphere(0.1f, 8, 8);
            luz.move(
                    (float)(Math.cos(i * Math.PI / 3) * 3f),
                    1f,
                    (float)(Math.sin(i * Math.PI / 3) * 3f)
            );
            luz.setColor(COLOR_VIOLETA);
            elementos.add(luz);
        }
    }

    // Runas brillantes en columnas
    private void añadirRunasBrillantes() {
        float[][] posiciones = {
                {-5f, 0f, -5f},
                {5f, 0f, -5f},
                {-5f, 0f, 5f},
                {5f, 0f, 5f}
        };

        for (float[] pos : posiciones) {
            for (int i = 0; i < 3; i++) {
                Sphere runa = new Sphere(0.1f, 8, 8);
                runa.move(pos[0], pos[1] + 1.5f + i * 0.5f, pos[2]);
                runa.setColor(COLOR_VIOLETA);
                elementos.add(runa);
            }
        }
    }

    // Escalinata principal con detalles dorados
    private void crearEscalinataPrincipal() {
        for (int i = 0; i < 6; i++) {
            Prisma escalon = new Prisma(6f, 0.2f, 0.2f);
            escalon.move(0f, -1.5f + i * 0.3f, -8f + i * 0.3f);
            escalon.setColor(COLOR_DORADO);
            elementos.add(escalon);
        }
    }

    // Trofeos y esculturas alrededor de la arena
    private void colocarTrofeosAlrededor() {
        for (int i = 0; i < 12; i++) {
            float angulo = i * (float) Math.PI / 6;
            float x = (float) (Math.cos(angulo) * 6.5f);
            float z = (float) (Math.sin(angulo) * 6.5f);

            // Base del trofeo
            Prisma base = new Prisma(0.4f, 0.4f, 0.2f);
            base.move(x, -1.3f, z);
            base.setColor(COLOR_GRIS_CLARO);
            elementos.add(base);

            // Copa del trofeo
            Cono copa = new Cono(0.2f, 0.5f, 8);
            copa.move(x, -0.9f, z);
            copa.setColorPart("all",COLOR_DORADO);
            elementos.add(copa);

            // Joya superior
            Sphere joya = new Sphere(0.1f, 8, 8);
            joya.move(x, -0.4f, z);
            joya.setColor(COLOR_AZUL_CRYSTAL);
            elementos.add(joya);
        }
    }

    // Método para dibujar toda la escena
    public void draw(float[] mvpMatrix) {
        for (Figura figura : elementos) {
            figura.draw(mvpMatrix);
        }
    }
}