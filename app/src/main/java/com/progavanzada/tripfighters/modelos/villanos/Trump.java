package com.progavanzada.tripfighters.modelos.villanos;
import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Cono;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;
import com.progavanzada.tripfighters.figuras.Sphere;
import com.progavanzada.tripfighters.figuras.Torus;

import java.util.ArrayList;
import java.util.List;

public class Trump {
    private List<Figura> partes;

    public Trump() {
        partes = new ArrayList<>();

        // Zapatos
        Prisma zapatoIzq = new Prisma(0.25f, 0.25f, 0.1f);
        zapatoIzq.setColor(new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        zapatoIzq.move(-0.15f, 0f, 1.95f);
        partes.add(zapatoIzq);

        Prisma zapatoDer = new Prisma(0.25f, 0.25f, 0.1f);
        zapatoDer.setColor(new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        zapatoDer.move(0.15f, 0f, 1.95f);
        partes.add(zapatoDer);

        // Piernas
        Prisma piernaIzq = new Prisma(0.25f, 0.15f, 0.8f);
        piernaIzq.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        piernaIzq.move(-0.15f, 0.45f, 2);
        partes.add(piernaIzq);

        Prisma piernaDer = new Prisma(0.25f, 0.15f, 0.8f);
        piernaDer.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        piernaDer.move(0.15f, 0.45f, 2);
        partes.add(piernaDer);

        // Cintura
        Prisma cintura = new Prisma(0.5f, 0.2f, 0.23f);
        cintura.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        cintura.move(0f, .95f, 2);
        partes.add(cintura);

        // Torso
        Prisma torso = new Prisma(0.6f, 0.25f, 0.7f);
        torso.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        torso.move(0f, 1.4f, 2);
        partes.add(torso);

        // Camisa blanca
        Prisma camisa = new Prisma(0.4f, 0.2f, 0.7f);
        camisa.setColor(new float[]{1f, 1f, 1f, 1.0f});
        camisa.move(0f, 1.4f, 1.95f);
        partes.add(camisa);

        // Corbata roja
        Prisma corbata = new Prisma(0.08f, 0.01f, 0.5f);
        corbata.setColor(new float[]{0.8f, 0f, 0f, 1.0f});
        corbata.move(0f, 1.5f, 1.8f);
        partes.add(corbata);

        // Brazo izquierdo en la cintura
        Prisma brazoIzq = new Prisma(0.15f, 0.15f, 0.6f);
        brazoIzq.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        brazoIzq.move(-0.45f, 1.5f, 2);
        partes.add(brazoIzq);

        // Brazo derecho levantado
        Prisma brazoDer = new Prisma(0.15f, 0.15f, 0.6f);
        brazoDer.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        brazoDer.move(0.45f, 1.9f, 2);
        partes.add(brazoDer);

        // Mano izquierda
        Sphere manoIzq = new Sphere(0.08f, 10, 10);
        manoIzq.setColor(new float[]{1f, 0.85f, 0.7f, 1.0f});
        manoIzq.move(-0.45f, 1.2f, 2);
        partes.add(manoIzq);

        // Bandera más grande y al frente de la mano izquierda
        Prisma palo = new Prisma(0.02f, 0.02f, 0.35f);
        palo.setColor(new float[]{0.3f, 0.3f, 0.3f, 1.0f});
        palo.move(-0.45f, 1.3f, 1.85f);
        partes.add(palo);

        // Posiciones base
        float banderaX = -0.6f;
        float banderaY = 1.55f;
        float banderaZ = 1.85f;
        float altoFranja = 0.025f;
        float anchoBandera = 0.35f;

        // 7 franjas horizontales (empezando con rojo)
        for (int i = 0; i < 7; i++) {
            Prisma franja = new Prisma(anchoBandera, 0.005f, altoFranja);
            boolean esRoja = i % 2 == 0;
            franja.setColor(esRoja ? new float[]{0.8f, 0.1f, 0.1f, 1.0f}
                    : new float[]{1f, 1f, 1f, 1.0f});
            franja.move(banderaX, banderaY - i * altoFranja, banderaZ);
            partes.add(franja);
        }

        // Cuadro azul en la parte superior derecha
        float cuadroAncho = 0.14f;
        float cuadroAlto = altoFranja * 4;  // 4 franjas de altura
        Prisma cuadroAzul = new Prisma(cuadroAncho, 0.005f, cuadroAlto);
        cuadroAzul.setColor(new float[]{0.1f, 0.1f, 0.6f, 1.0f});
        cuadroAzul.move(
                banderaX + anchoBandera / 2 - cuadroAncho / 2,
                banderaY - cuadroAlto / 2 + altoFranja / 2,
                banderaZ - 0.01f
        );
        partes.add(cuadroAzul);

        // Estrellas en una cuadrícula de 6 columnas × 5 filas (sobre el nuevo cuadro azul)
        for (int col = 0; col < 6; col++) {
            for (int row = 0; row < 5; row++) {
                Sphere estrella = new Sphere(0.005f, 8, 8);
                estrella.setColor(new float[]{1f, 1f, 1f, 1.0f});

                float offsetX = banderaX + anchoBandera / 2 - cuadroAncho + 0.015f + col * 0.018f;
                float offsetY = banderaY - 0.015f - row * 0.018f;

                estrella.move(offsetX, offsetY, banderaZ - 0.015f);
                partes.add(estrella);
            }
        }

        // Mano derecha con dedo
        Sphere manoDer = new Sphere(0.08f, 10, 10);
        manoDer.setColor(new float[]{1f, 0.85f, 0.7f, 1.0f});
        manoDer.move(0.45f, 2.2f, 2);
        partes.add(manoDer);

        // Dedo apuntando
        Prisma dedo = new Prisma(0.02f, 0.02f, 0.2f);
        dedo.setColor(new float[]{1f, 0.85f, 0.7f, 1.0f});
        dedo.move(0.45f, 2.35f, 2);
        partes.add(dedo);

        // Cuello
        Cilindro cuello = new Cilindro(20, 0.08f, 0.1f);
        cuello.setColorPart("all", new float[]{1f, 0.85f, 0.7f, 1.0f});
        cuello.move(0f, 1.8f, 2);
        partes.add(cuello);

        // Cabeza grande
        Sphere cabeza = new Sphere(0.3f, 20, 20);
        cabeza.setColor(new float[]{1f, 0.85f, 0.7f, 1.0f});
        cabeza.move(0f, 2.1f, 2);
        partes.add(cabeza);

        // Cabello rubio
        Sphere cabello = new Sphere(0.32f, 20, 20);
        cabello.setColor(new float[]{1f, 0.9f, 0.3f, 1.0f});
        cabello.move(0f, 2.2f, 2);
        partes.add(cabello);

        // Ojos
        Sphere ojoIzq = new Sphere(0.05f, 10, 10);
        ojoIzq.setColor(new float[]{0.2f, 0.2f, 0.2f, 1.0f});
        ojoIzq.move(-0.08f, 2.03f, 1.75f);
        partes.add(ojoIzq);

        Sphere ojoDer = new Sphere(0.05f, 10, 10);
        ojoDer.setColor(new float[]{0.2f, 0.2f, 0.2f, 1.0f});
        ojoDer.move(0.08f, 2.03f, 1.75f);
        partes.add(ojoDer);

        // Boca abierta
        Prisma boca = new Prisma(0.15f, 0.01f, 0.08f);
        boca.setColor(new float[]{0.6f, 0.1f, 0.1f, 1.0f});
        boca.move(0f, 1.93f, 1.75f);
        partes.add(boca);
    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}