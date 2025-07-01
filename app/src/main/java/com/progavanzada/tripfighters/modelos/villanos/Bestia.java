package com.progavanzada.tripfighters.modelos.villanos;

import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Cono;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;
import com.progavanzada.tripfighters.figuras.Sphere;
import com.progavanzada.tripfighters.figuras.Torus;

import java.util.ArrayList;
import java.util.List;


public class Bestia {
    private List<Figura> partes;

    public Bestia() {
        partes = new ArrayList<>();

        // Pies grandes con garras
        Cilindro pieIzq = new Cilindro(20, 0.35f, 0.15f);
        pieIzq.setColorPart("all", new float[]{0.9f, 0.8f, 0.6f, 1.0f});
        pieIzq.move(-0.4f, 0f, 2);
        partes.add(pieIzq);

        Cilindro pieDer = new Cilindro(20, 0.35f, 0.15f);
        pieDer.setColorPart("all", new float[]{0.9f, 0.8f, 0.6f, 1.0f});
        pieDer.move(0.4f, 0f, 2);
        partes.add(pieDer);

        // Piernas con pelaje
        Cilindro piernaIzq = new Cilindro(20, 0.28f, 1f);
        piernaIzq.setColorPart("all", new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        piernaIzq.move(-0.4f, 0.55f, 2);
        partes.add(piernaIzq);

        Cilindro piernaDer = new Cilindro(20, 0.28f, 1f);
        piernaDer.setColorPart("all", new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        piernaDer.move(0.4f, 0.55f, 2);
        partes.add(piernaDer);

        // Cintura
        Prisma cintura = new Prisma(1f, 0.5f, 0.35f);
        cintura.setColor(new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        cintura.move(0f, 1.1f, 2);
        partes.add(cintura);

        // Torso musculoso con pectorales y abdominales
        Prisma pectorales = new Prisma(1f, 0.5f, 0.5f);
        pectorales.setColor(new float[]{0.9f, 0.8f, 0.6f, 1.0f});
        pectorales.move(0f, 1.53f, 2);
        partes.add(pectorales);

        Prisma pectoralesA = new Prisma(1f, 0.01f, 0.51f);
        pectoralesA.setColor(new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        pectoralesA.move(0f, 1.53f, 2.25f);
        partes.add(pectoralesA);

        Prisma pectorales1 = new Prisma(.15f, 0.5f, 0.25f);
        pectorales1.setColor(new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        pectorales1.move(.4f, 2.2f, 2);
        partes.add(pectorales1);

        Prisma pectorales1L = new Prisma(.01f, 0.15f, 0.51f);
        pectorales1L.setColor(new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        pectorales1L.move(.35f, 2f, 2.19f);
        partes.add(pectorales1L);

        Prisma pectorales2 = new Prisma(.15f, 0.5f, 0.25f);
        pectorales2.setColor(new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        pectorales2.move(-.4f, 2.2f, 2);
        partes.add(pectorales2);

        Prisma pectorales2L = new Prisma(.01f, 0.15f, 0.51f);
        pectorales2L.setColor(new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        pectorales2L.move(-.35f, 2f, 2.19f);
        partes.add(pectorales2L);

        Prisma abdomen = new Prisma(0.7f, 0.5f, 0.55f);
        abdomen.setColor(new float[]{0.9f, 0.8f, 0.6f, 1.0f});
        abdomen.move(0f, 2f, 2f);
        partes.add(abdomen);

        Prisma pectoralesLI = new Prisma(.01f, 0.15f, 0.52f);
        pectoralesLI.setColor(new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        pectoralesLI.move(0.51f, 1.53f, 2.19f);
        partes.add(pectoralesLI);

        Prisma pectoralesLD = new Prisma(.01f, 0.15f, 0.52f);
        pectoralesLD.setColor(new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        pectoralesLD.move(-0.51f, 1.53f, 2.19f);
        partes.add(pectoralesLD);
        
        Prisma abdomenA = new Prisma(0.7f, 0.01f, 0.55f);
        abdomenA.setColor(new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        abdomenA.move(0f, 2f, 2.25f);
        partes.add(abdomenA);

        Prisma cuelloP = new Prisma(1f, 0.5f, 0.3f);
        cuelloP.setColor(new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        cuelloP.move(0f, 2.425f, 2);
        partes.add(cuelloP);

        // Hombros con pelaje
        Cilindro hombroIzq = new Cilindro(20, 0.3f, 0.2f);
        hombroIzq.setColorPart("all", new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        hombroIzq.move(-0.78f, 2.3f, 2);
        partes.add(hombroIzq);

        Cilindro hombroDer = new Cilindro(20, 0.3f, 0.2f);
        hombroDer.setColorPart("all", new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        hombroDer.move(0.78f, 2.3f, 2);
        partes.add(hombroDer);

        // Brazos largos con pelaje
        Cilindro brazoIzq = new Cilindro(20, 0.18f, 1.0f);
        brazoIzq.setColorPart("all", new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        brazoIzq.move(-0.78f, 1.7f, 2);
        partes.add(brazoIzq);

        Cilindro brazoDer = new Cilindro(20, 0.18f, 1.0f);
        brazoDer.setColorPart("all", new float[]{0.3f, 0.15f, 0.05f, 1.0f});
        brazoDer.move(0.78f, 2.6f, 1.5f);
        brazoDer.rotate(-65,0,0);
        partes.add(brazoDer);

        // Manos con garras
        Prisma palmaIzq = new Prisma(0.34f, 0.1f, 0.17f);
        palmaIzq.setColor(new float[]{0.9f, 0.8f, 0.6f, 1.0f});
        palmaIzq.move(-0.78f, 1.2f, 2);
        partes.add(palmaIzq);

        Prisma palmaDer = new Prisma(0.34f, 0.1f, 0.17f);
        palmaDer.setColor(new float[]{0.9f, 0.8f, 0.6f, 1.0f});
        palmaDer.move(0.78f, 2.8f, 1);
        palmaDer.rotate(-65,0,0);
        partes.add(palmaDer);

        // Piedra
        Sphere piedra = new Sphere(0.2f, 10, 10);
        piedra.setColor(new float[]{0.3f, 0.3f, 0.3f, 1.0f});
        piedra.move(0.78f, 2.65f, .8f); // En la mano
        partes.add(piedra);

        for (int i = -2; i <= 2; i++) {
            float offset = i * 0.07f;
            Prisma garraIzq = new Prisma(0.035f, 0.03f, 0.5f);
            garraIzq.setColor(new float[]{0.9f, 0.8f, 0.6f, 1.0f});
            garraIzq.move(-0.78f + offset, 1.15f, 2f);
            partes.add(garraIzq);

            Prisma garraDer = new Prisma(0.035f, 0.03f, 0.5f);
            garraDer.setColor(new float[]{0.9f, 0.8f, 0.6f, 1.0f});
            garraDer.move(0.78f + offset, 2.8f, 1f);
            garraDer.rotate(-65,0,0);
            partes.add(garraDer);
        }

        // Cabeza con cara y pelaje
        Prisma pelajeCabeza = new Prisma(0.8f, 0.7f, 0.75f);
        pelajeCabeza.setColor(new float[]{0.3f, 0.2f, 0.1f, 1.0f});
        pelajeCabeza.move(0f, 2.85f, 2f);
        partes.add(pelajeCabeza);

        Sphere cara = new Sphere(0.4f, 20, 20);
        cara.setColor(new float[]{0.9f, 0.8f, 0.6f, 1.0f});
        cara.move(0f, 2.85f, 1.9f);
        partes.add(cara);

        // Ojos
        Sphere ojoIzq = new Sphere(0.08f, 10, 10);
        ojoIzq.setColor(new float[]{.9f, 0.2f, 0.2f, 1.0f}); // más brillo rojo
        ojoIzq.move(-0.1f, 2.97f, 1.59f);
        partes.add(ojoIzq);

        Sphere ojoDer = new Sphere(0.08f, 10, 10);
        ojoDer.setColor(new float[]{.9f, 0.2f, 0.2f, 1.0f});
        ojoDer.move(0.1f, 2.97f, 1.59f);
        partes.add(ojoDer);


        // Oreja izquierda
        Prisma orejaIzq = new Prisma(0.14f, 0.13f, 0.25f);
        orejaIzq.setColor(new float[]{0.9f, 0.8f, 0.6f, 1.0f});
        orejaIzq.move(-0.4f, 2.85f, 1.95f);
        orejaIzq.rotate(0,0,45);
        partes.add(orejaIzq);

        // Oreja derecha
        Prisma orejaDer = new Prisma(0.14f, 0.13f, 0.25f);
        orejaDer.setColor(new float[]{0.9f, 0.8f, 0.6f, 1.0f});
        orejaDer.move(0.4f, 2.85f, 1.95f);
        orejaDer.rotate(0,0,315);
        partes.add(orejaDer);

        // --- Agujeros de la nariz (esferas negras)
        Sphere narizIzq = new Sphere(0.025f, 10, 10);
        narizIzq.setColor(new float[]{0f, 0f, 0f, 1});
        narizIzq.move(-0.035f, 2.9f, 1.52f); // ligeramente sobre la boca
        partes.add(narizIzq);

        Sphere narizDer = new Sphere(0.025f, 10, 10);
        narizDer.setColor(new float[]{0f, 0f, 0f, 1});
        narizDer.move(0.035f, 2.9f, 1.52f);
        partes.add(narizDer);


        // --- BOCA MALVADA (Cono invertido, adaptado y más pequeño)
        Cono sonrisa = new Cono(0.23f, 0.1f, 12);
        sonrisa.setColorPart("all", new float[]{0.05f, 0.05f, 0.05f, 1}); // negro
        sonrisa.move(0f, 2.68f, 1.6f); // centrado verticalmente en la cara
        sonrisa.rotate(180, 0, 0);
        partes.add(sonrisa);

// --- Comisuras negras más pequeñas y ajustadas
        Sphere comisuraIzq = new Sphere(0.06f, 10, 10);
        comisuraIzq.setColor(new float[]{0.05f, 0.05f, 0.05f, 1});
        comisuraIzq.move(-0.17f, 2.72f, 1.6f); // más cerca del cono
        partes.add(comisuraIzq);

        Sphere comisuraDer = new Sphere(0.06f, 10, 10);
        comisuraDer.setColor(new float[]{0.05f, 0.05f, 0.05f, 1});
        comisuraDer.move(0.17f, 2.72f, 1.6f);
        partes.add(comisuraDer);



    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}