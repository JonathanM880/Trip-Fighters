package com.progavanzada.tripfighters.modelos.escenas;

import com.progavanzada.tripfighters.figuras.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDeOro {
    private List<Figura> componentes;
    private final float[] ORO_PURO = {1.0f, 0.85f, 0.1f, 1.0f};
    private final float[] ORO_ROSADO = {1.0f, 0.75f, 0.4f, 1.0f};
    private final float[] RUBI = {0.9f, 0.1f, 0.2f, 1.0f};
    private final float[] ESMERALDA = {0.1f, 0.8f, 0.3f, 1.0f};
    private final float[] ZAFIRO = {0.2f, 0.3f, 0.9f, 1.0f};
    // Reemplaza tus antiguos colores con estos:
    private final float[] ORO_LUJO = {0.95f, 0.75f, 0.3f, 1.0f};    // Dorado principal (cálido y vibrante)
    private final float[] ORO_SATIN = {0.98f, 0.89f, 0.5f, 1.0f};   // Dorado claro (brillo satinado)
    private final float[] ORO_OXIDO = {0.8f, 0.6f, 0.2f, 1.0f};     // Dorado oscuro (efecto vintage)
    private final float[] ORO_ESPECULAR = {1.0f, 0.92f, 0.55f, 1.0f}; // Para reflejos

    public SalaDeOro() {
        componentes = new ArrayList<>();
        construirBase();
        construirColumnatas();
        construirTesoroCentral();
        construirEsculturasEpicas();
        construirDetallesFinales();
    }

    private void construirBase() {
        // Plataforma principal con escalones concéntricos
        for (int i = 0; i < 3; i++) {
            Prisma escalon = new Prisma(10f - i*2, 10f - i*2, 0.2f);
            escalon.move(0f, -1f + i*0.2f, 0f);
            escalon.setColor(i % 2 == 0 ? ORO_PURO : ORO_ROSADO);
            componentes.add(escalon);
        }

        // Patrón de mosaico en el piso principal
        for (int x = -4; x <= 4; x++) {
            for (int z = -4; z <= 4; z++) {
                if ((x + z) % 2 == 0) {
                    Prisma loseta = new Prisma(0.3f, 0.3f, 0.05f);
                    loseta.move(x*0.5f, -0.4f, z*0.5f);
                    loseta.setColor(new float[]{
                            0.9f + (float)Math.random()*0.1f,
                            0.7f + (float)Math.random()*0.2f,
                            0.1f + (float)Math.random()*0.1f,
                            1f
                    });
                    componentes.add(loseta);
                }
            }
        }
    }

    private void construirColumnatas() {
        // Columnas exteriores monumentales
        for (int i = 0; i < 8; i++) {
            double angle = Math.PI * i / 4;
            float x = (float) (5 * Math.cos(angle));
            float z = (float) (5 * Math.sin(angle));

            // Columna principal
            Cilindro columna = new Cilindro(24, 0.3f, 3f);
            columna.move(x, 0.5f, z);
            columna.setColorPart("all",ORO_PURO);
            componentes.add(columna);

            // Base decorada
            Torus base = new Torus(24, 0.4f, 0.1f);
            base.move(x, -0.8f, z);
            base.setColor(ORO_ROSADO);
            componentes.add(base);

            // Capitel elaborado
            Cono capitelSuperior = new Cono(0.5f, 0.4f, 24);
            capitelSuperior.move(x, 2.2f, z);
            capitelSuperior.setColorPart("all",ORO_ROSADO);
            componentes.add(capitelSuperior);

            Sphere ornamentacion = new Sphere(0.2f, 16, 16);
            ornamentacion.move(x, 2.6f, z);
            ornamentacion.setColor(RUBI);
            componentes.add(ornamentacion);
        }
    }

    private void construirTesoroCentral() {
        // Montaña de oro
        for (int i = 0; i < 50; i++) {
            Sphere moneda = new Sphere(0.15f + (float)Math.random()*0.1f, 8, 8);
            moneda.move(
                    (float)(Math.random() * 2 - 1),
                    -0.3f + (float)Math.random() * 0.8f,
                    (float)(Math.random() * 2 - 1)
            );
            moneda.setColor(ORO_PURO);
            componentes.add(moneda);
        }

        // Cofre del tesoro
        Prisma cofreBase = new Prisma(1.5f, 1f, 0.8f);
        cofreBase.move(0f, 0f, 0f);
        cofreBase.setColor(ORO_ROSADO);
        componentes.add(cofreBase);

        Prisma cofreTapa = new Prisma(1.5f, 1f, 0.1f);
        cofreTapa.move(0f, 0.5f, 0f);
        cofreTapa.setColor(ORO_PURO);
        componentes.add(cofreTapa);

        // Joyas en el cofre
        for (int i = 0; i < 10; i++) {
            Sphere joya = new Sphere(0.1f + (float)Math.random()*0.05f, 12, 12);
            joya.move(
                    (float)(Math.random()*0.8 - 0.4),
                    0.6f,
                    (float)(Math.random()*0.4 - 0.2)
            );
            joya.setColor(i % 3 == 0 ? RUBI : i % 3 == 1 ? ESMERALDA : ZAFIRO);
            componentes.add(joya);
        }
    }

    private void construirEsculturasEpicas() {
        // Escultura de dragón dorado (simplificada)
        // Cabeza del dragón (originalmente con rotate(ángulo, ejeX, ejeY, ejeZ))
        Cono cabeza = new Cono(0.3f, 0.5f, 16);
        cabeza.move(-2f, 0.8f, -2f);
// cabeza.rotate(45f, 0f, 1f, 0f); // Versión anterior
        cabeza.rotate(0f, 45f, 0f); // Versión para tu sistema (solo rotación en Y)
        cabeza.setColorPart("all", ORO_PURO);
        componentes.add(cabeza);

        Torus cuerpo = new Torus(24, 0.8f, 0.1f);
        cuerpo.move(-2f, 0.3f, -2f);
        cuerpo.setColor(ORO_ROSADO);
        componentes.add(cuerpo);

        // Alas del dragón (prismas delgados)
        for (int i = 0; i < 2; i++) {
            Prisma ala = new Prisma(0.1f, 1.5f, 0.01f); // Ala más grande
            ala.move(-2f + (i*0.3f), 0.5f, -2f); // Mayor separación

            // Rotación combinada (X + Y):
            if (i == 0) { // Ala izquierda
                ala.rotate(
                        30f,    // 30° en X (inclinación hacia arriba)
                        20f,    // 20° en Y (abierta hacia el lado)
                        0f      // Sin rotación en Z
                );
            } else { // Ala derecha
                ala.rotate(
                        -30f,   // -30° en X (inclinación hacia abajo)
                        -20f,   // -20° en Y (abierta hacia el otro lado)
                        0f
                );
            }

            ala.setColor(ORO_ROSADO); // Color diferente para destacar
            componentes.add(ala);
        }

        // Escultura de diosa
        Sphere cabezaDiosa = new Sphere(0.25f, 24, 24);
        cabezaDiosa.move(2f, 0.9f, 2f);
        cabezaDiosa.setColor(ORO_PURO);
        componentes.add(cabezaDiosa);

        Cilindro cuerpoDiosa = new Cilindro(24, 0.15f, 0.6f);
        cuerpoDiosa.move(2f, 0.3f, 2f);
        cuerpoDiosa.setColorPart("all", ORO_ROSADO);
        componentes.add(cuerpoDiosa);

        // Brazos
        for (int i = 0; i < 2; i++) {
            Cilindro brazo = new Cilindro(12, 0.07f, 0.4f);
            brazo.move(2f + (i == 0 ? -0.2f : 0.2f), 0.5f, 2f);
            brazo.rotate(0f, 0f, i == 0 ? -45f : 45f);
            brazo.setColorPart("all", ORO_PURO);
            componentes.add(brazo);
        }
    }

    private void construirDetallesFinales() {
        // Lámparas flotantes
        for (int i = 0; i < 4; i++) {
            double angle = Math.PI/2 * i;
            float x = (float) (3 * Math.cos(angle));
            float z = (float) (3 * Math.sin(angle));

            Sphere lampara = new Sphere(0.3f, 16, 16);
            lampara.move(x, 1.8f, z);
            lampara.setColor(new float[]{1f, 1f, 0.7f, 1f});
            componentes.add(lampara);

            // Cadenas de oro
            for (int j = 0; j < 5; j++) {
                Torus eslabon = new Torus(16, 0.04f, 0.018f); // Más detalle (16 segmentos)
                eslabon.move(x, 1.8f - j*0.22f, z);

                // Rotación entrelazada
                eslabon.rotate(90f, 0f, (j % 2 == 0) ? 90f : 0f);

                // Color degradado (más oscuro hacia abajo)
                float intensidad = 1.0f - j * 0.1f;
                float[] color = {
                        ORO_LUJO[0] * intensidad,
                        ORO_LUJO[1] * intensidad,
                        ORO_LUJO[2] * intensidad,
                        1.0f
                };
                eslabon.setColor(color);

                componentes.add(eslabon);
                if (j == 0 || j == 3) { // Eslabones superiores e inferiores
                    Sphere reflejo = new Sphere(0.015f, 8, 8);
                    reflejo.move(x + 0.03f, 1.8f - j*0.22f, z + 0.03f);
                    reflejo.setColor(ORO_ESPECULAR);
                    componentes.add(reflejo);
                }
            }

        }

        // Joyas en las columnas
        for (int i = 0; i < 8; i++) {
            double angle = Math.PI * i / 4;
            float x = (float) (4.5 * Math.cos(angle));
            float z = (float) (4.5 * Math.sin(angle));

            Sphere joya = new Sphere(0.15f, 24, 24);
            joya.move(x, 1f, z);
            joya.setColor(i % 4 == 0 ? RUBI : i % 4 == 1 ? ESMERALDA : i % 4 == 2 ? ZAFIRO : ORO_PURO);
            componentes.add(joya);
        }
    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : componentes) {
            f.draw(mvpMatrix);
        }
    }
}