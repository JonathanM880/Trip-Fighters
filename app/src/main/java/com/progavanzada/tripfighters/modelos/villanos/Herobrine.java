package com.progavanzada.tripfighters.modelos.villanos;
import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Cono;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;
import com.progavanzada.tripfighters.figuras.Sphere;
import com.progavanzada.tripfighters.figuras.Torus;

import java.util.ArrayList;
import java.util.List;
public class Herobrine {
    private List<Figura> partes;

    public Herobrine() {
        partes = new ArrayList<>();

        // Zapatos
        Prisma zapatoIzq = new Prisma(0.3f, 0.2f, 0.1f);
        zapatoIzq.setColor(new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        zapatoIzq.move(-0.16f, 0f, 2);
        partes.add(zapatoIzq);

        Prisma zapatoDer = new Prisma(0.3f, 0.2f, 0.1f);
        zapatoDer.setColor(new float[]{0.05f, 0.05f, 0.05f, 1.0f});
        zapatoDer.move(0.16f, 0f, 2);
        partes.add(zapatoDer);

        // Piernas
        Prisma piernaIzq = new Prisma(0.2f, 0.2f, 0.7f);
        piernaIzq.setColor(new float[]{0.1f, 0.1f, 0.4f, 1.0f});
        piernaIzq.move(-0.16f, 0.41f, 2);
        partes.add(piernaIzq);

        Prisma piernaDer = new Prisma(0.2f, 0.2f, 0.7f);
        piernaDer.setColor(new float[]{0.1f, 0.1f, 0.4f, 1.0f});
        piernaDer.move(0.16f, 0.41f, 2);
        partes.add(piernaDer);

        // Cuerpo
        Prisma torso = new Prisma(0.6f, 0.3f, 0.8f);
        torso.setColor(new float[]{0.0f, 0.6f, 0.6f, 1.0f});
        torso.move(0f, 1.1f, 2);
        partes.add(torso);

        //hombros
        Prisma hombroDer = new Prisma(0.4f, 0.3f, 0.3f);
        hombroDer.setColor(new float[]{0.0f, 0.6f, 0.6f, 1.0f});
        hombroDer.move(-0.4f, 1.35f, 2);
        partes.add(hombroDer);

        Prisma hombroIzq = new Prisma(0.4f, 0.3f, 0.3f);
        hombroIzq.setColor(new float[]{0.0f, 0.6f, 0.6f, 1.0f});
        hombroIzq.move(0.4f, 1.35f, 2);
        partes.add(hombroIzq);

        // Brazos
        Prisma brazoIzq = new Prisma(0.2f, 0.2f, 0.8f);
        brazoIzq.setColor(new float[]{0.68f, 0.46f, 0.33f, 1.0f});
        brazoIzq.move(-0.46f, 1.1f, 2);
        partes.add(brazoIzq);

        Prisma brazoDer = new Prisma(0.2f, 0.2f, 0.8f);
        brazoDer.setColor(new float[]{0.68f, 0.46f, 0.33f, 1.0f});
        brazoDer.move(0.46f, 1.1f, 2);
        partes.add(brazoDer);

        // Cabeza (cara)
        Prisma cabeza = new Prisma(0.49f, 0.49f, 0.49f);
        cabeza.setColor(new float[]{0.68f, 0.46f, 0.33f, 1.0f});
        cabeza.move(0f, 1.75f, 2);
        partes.add(cabeza);

        // Ojos blancos
        Prisma ojoIzq = new Prisma(0.11f, 0.01f, 0.05f);
        ojoIzq.setColor(new float[]{1f, 1f, 1f, 1.0f});
        ojoIzq.move(-0.1f, 1.75f, 1.75f);
        partes.add(ojoIzq);

        Prisma ojoDer = new Prisma(0.11f, 0.01f, 0.05f);
        ojoDer.setColor(new float[]{1f, 1f, 1f, 1.0f});
        ojoDer.move(0.1f, 1.75f, 1.75f);
        partes.add(ojoDer);

        // Cabello: parte superior
        Prisma peloSuperior = new Prisma(0.5f, 0.5f, 0.1f);
        peloSuperior.setColor(new float[]{0.05f, 0.1f, 0.05f, 1.0f});
        peloSuperior.move(0f, 2f, 2);
        partes.add(peloSuperior);

        // Cabello: parte trasera
        Prisma peloAtras = new Prisma(0.5f, 0.1f, 0.5f);
        peloAtras.setColor(new float[]{0.05f, 0.1f, 0.05f, 1.0f});
        peloAtras.move(0f, 1.75f, 2.25f);
        partes.add(peloAtras);

        // Cabello: lados
        Prisma peloIzq = new Prisma(0.1f, 0.5f, 0.5f);
        peloIzq.setColor(new float[]{0.05f, 0.1f, 0.05f, 1.0f});
        peloIzq.move(-0.25f, 1.75f, 2);
        partes.add(peloIzq);

        Prisma peloDer = new Prisma(0.1f, 0.5f, 0.5f);
        peloDer.setColor(new float[]{0.05f, 0.1f, 0.05f, 1.0f});
        peloDer.move(0.25f, 1.75f, 2);
        partes.add(peloDer);

        // Flequillo (dos cuadros oscuros en la frente)
        Prisma flequilloIzq = new Prisma(0.1f, 0.01f, 0.1f);
        flequilloIzq.setColor(new float[]{0.05f, 0.1f, 0.05f, 1.0f});
        flequilloIzq.move(-0.2f, 1.9f, 1.75f);
        partes.add(flequilloIzq);

        Prisma flequilloDer = new Prisma(0.1f, 0.01f, 0.1f);
        flequilloDer.setColor(new float[]{0.05f, 0.1f, 0.05f, 1.0f});
        flequilloDer.move(0.2f, 1.9f, 1.75f);
        partes.add(flequilloDer);

        Prisma flequillo = new Prisma(0.5f, 0.01f, 0.04f);
        flequillo.setColor(new float[]{0.05f, 0.1f, 0.05f, 1.0f});
        flequillo.move(0f, 1.94f, 1.75f);
        partes.add(flequillo);

    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}


