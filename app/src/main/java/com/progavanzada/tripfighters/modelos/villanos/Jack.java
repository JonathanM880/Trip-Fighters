package com.progavanzada.tripfighters.modelos.villanos;

import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Cono;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;
import com.progavanzada.tripfighters.figuras.Sphere;
import java.util.ArrayList;
import java.util.List;

public class Jack {
    private List<Figura> partes;

    public Jack() {
        partes = new ArrayList<>();

        // Pies
        Cilindro pieIzq = new Cilindro(20, 0.15f, 0.1f);
        pieIzq.setColorPart("all", new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        pieIzq.move(-0.25f, 0f, 2);
        partes.add(pieIzq);

        Cilindro pieDer = new Cilindro(20, 0.15f, 0.1f);
        pieDer.setColorPart("all", new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        pieDer.move(0.25f, 0f, 2);
        partes.add(pieDer);

        // Piernas largas
        Cilindro piernaIzq = new Cilindro(20, 0.06f, 1.3f);
        piernaIzq.setColorPart("all", new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        piernaIzq.move(-0.25f, 0.75f, 2);
        partes.add(piernaIzq);

        Cilindro piernaDer = new Cilindro(20, 0.06f, 1.3f);
        piernaDer.setColorPart("all", new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        piernaDer.move(0.25f, 0.75f, 2);
        partes.add(piernaDer);

        // Coattails
        Prisma cola1 = new Prisma(0.15f, 0.05f, 0.6f);
        cola1.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        cola1.move(-0.15f, 1.1f, 2.1f);
        partes.add(cola1);

        Prisma cola2 = new Prisma(0.15f, 0.05f, 0.6f);
        cola2.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        cola2.move(0.15f, 1.1f, 2.1f);
        partes.add(cola2);

        // Torso
        Prisma torso = new Prisma(0.35f, 0.2f, 1.0f);
        torso.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        torso.move(0, 1.8f, 2);
        partes.add(torso);

        // Cuello
        Cilindro cuello = new Cilindro(20, 0.04f, 0.2f);
        cuello.setColorPart("all", new float[]{0.9f, 0.9f, 0.9f, 1.0f});
        cuello.move(0, 2.4f, 2);
        partes.add(cuello);

        // Cabeza
        Sphere cabeza = new Sphere(0.35f, 30, 30);
        cabeza.setColor(new float[]{0.95f, 0.95f, 0.95f, 1.0f});
        cabeza.move(0, 2.7f, 2);
        partes.add(cabeza);

        // Ojos
        Sphere ojoIzq = new Sphere(0.1f, 20, 20);
        ojoIzq.setColor(new float[]{0f, 0f, 0f, 1.0f});
        ojoIzq.move(-0.12f, 2.77f, 1.7f);
        partes.add(ojoIzq);

        Sphere ojoDer = new Sphere(0.1f, 20, 20);
        ojoDer.setColor(new float[]{0f, 0f, 0f, 1.0f});
        ojoDer.move(0.12f, 2.77f, 1.7f);
        partes.add(ojoDer);

        // Nariz (dos pequeños agujeros)
        Sphere narizIzq = new Sphere(0.015f, 10, 10);
        narizIzq.setColor(new float[]{0f, 0f, 0f, 1.0f});
        narizIzq.move(-0.03f, 2.72f, 1.65f);
        partes.add(narizIzq);

        Sphere narizDer = new Sphere(0.015f, 10, 10);
        narizDer.setColor(new float[]{0f, 0f, 0f, 1.0f});
        narizDer.move(0.03f, 2.72f, 1.65f);
        partes.add(narizDer);

        // Alas del murciélago (más puntiagudas)
        Prisma alaIzq = new Prisma(0.2f, 0.02f, 0.05f);
        alaIzq.setColor(new float[]{0f, 0f, 0f, 1.0f});
        alaIzq.move(-0.2f, 2.15f, 1.85f);
        alaIzq.rotate(0, 0, -30);
        partes.add(alaIzq);

        Prisma alaDer = new Prisma(0.2f, 0.02f, 0.05f);
        alaDer.setColor(new float[]{0f, 0f, 0f, 1.0f});
        alaDer.move(0.2f, 2.15f, 1.85f);
        alaDer.rotate(0, 0, 30);
        partes.add(alaDer);

        // Cabeza del murciélago
        Sphere cabezaMurcielago = new Sphere(0.04f, 10, 10);
        cabezaMurcielago.setColor(new float[]{0f, 0f, 0f, 1.0f});
        cabezaMurcielago.move(0f, 2.15f, 1.85f);
        partes.add(cabezaMurcielago);

        // Orejas puntiagudas
        Cono orejaIzq = new Cono(0.03f, 0.02f, 10);
        orejaIzq.setColorPart("all", new float[]{0f, 0f, 0f, 1.0f});
        orejaIzq.move(-0.015f, 2.18f, 1.85f);
        partes.add(orejaIzq);

        Cono orejaDer = new Cono(0.03f, 0.02f, 10);
        orejaDer.setColorPart("all", new float[]{0f, 0f, 0f, 1.0f});
        orejaDer.move(0.015f, 2.18f, 1.85f);
        partes.add(orejaDer);

        // HOMBROS
        Prisma hombroIzq = new Prisma(0.12f, 0.12f, 0.12f);
        hombroIzq.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        hombroIzq.move(-0.35f, 2.3f, 2); // al nivel del torso, entre brazo y cuerpo
        partes.add(hombroIzq);

        Prisma hombroDer = new Prisma(0.12f, 0.12f, 0.12f);
        hombroDer.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        hombroDer.move(0.35f, 2.3f, 2);
        partes.add(hombroDer);

        // Brazos
        Cilindro brazoIzq = new Cilindro(20, 0.045f, 1.0f);
        brazoIzq.setColorPart("all", new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        brazoIzq.move(-0.5f, 2.0f, 2);
        partes.add(brazoIzq);

        Cilindro brazoDer = new Cilindro(20, 0.045f, 1.0f);
        brazoDer.setColorPart("all", new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        brazoDer.move(0.5f, 2.0f, 2);
        partes.add(brazoDer);

        // Manos (palma + dedos como prismas más separados)
        Prisma palmaIzq = new Prisma(0.1f, 0.05f, 0.05f);
        palmaIzq.setColor(new float[]{0.95f, 0.95f, 0.95f, 1.0f});
        palmaIzq.move(-0.5f, 1.5f, 2);
        partes.add(palmaIzq);

        Prisma palmaDer = new Prisma(0.1f, 0.05f, 0.05f);
        palmaDer.setColor(new float[]{0.95f, 0.95f, 0.95f, 1.0f});
        palmaDer.move(0.5f, 1.5f, 2);
        partes.add(palmaDer);

        for (int i = -2; i <= 2; i++) {
            float offset = i * 0.035f; // más separación
            Prisma dedoIzq = new Prisma(0.015f, 0.015f, 0.3f);
            dedoIzq.setColor(new float[]{0.95f, 0.95f, 0.95f, 1.0f});
            dedoIzq.move(-0.5f + offset, 1.45f, 2.05f);
            partes.add(dedoIzq);

            Prisma dedoDer = new Prisma(0.015f, 0.015f, 0.3f);
            dedoDer.setColor(new float[]{0.95f, 0.95f, 0.95f, 1.0f});
            dedoDer.move(0.5f + offset, 1.45f, 2.05f);
            partes.add(dedoDer);
        }

        // Boca cosida con forma curva (sonrisa hacia arriba)
// Línea base curva (gruesa)
        for (int i = -4; i <= 4; i++) {
            float x = i * 0.07f;
            float y = 2.45f + (float)(Math.pow(x, 2) * 1.8f);
            Prisma segmento = new Prisma(0.07f, 0.015f, 0.015f); // más anchos y profundos
            segmento.setColor(new float[]{0f, 0f, 0f, 1.0f});
            segmento.move(x, y, 1.78f);
            partes.add(segmento);
        }

// Costuras verticales (gruesas y más altas)
        for (int i = -4; i <= 4; i++) {
            float x = i * 0.07f;
            float y = 2.45f + (float)(Math.pow(x, 2) * 1.8f);
            Prisma costura = new Prisma(0.01f, 0.01f, 0.12f); // más gruesas
            costura.setColor(new float[]{0f, 0f, 0f, 1.0f});
            costura.move(x, y + 0.01f, 1.78f);
            partes.add(costura);
        }

    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}




