package com.progavanzada.tripfighters.modelos.villanos;

import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Cono;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Prisma;
import com.progavanzada.tripfighters.figuras.Sphere;
import com.progavanzada.tripfighters.figuras.Torus;

import java.util.ArrayList;
import java.util.List;
public class Cleopatra {
    private List<Figura> partes;

    public Cleopatra() {
        partes = new ArrayList<>();

        // Zapatos blancos
        Prisma zapatoIzq = new Prisma(0.25f, 0.15f, 0.05f);
        zapatoIzq.setColor(new float[]{1f, 1f, 1f, 1.0f});
        zapatoIzq.move(-0.15f, 0f, 2);
        partes.add(zapatoIzq);

        Prisma zapatoDer = new Prisma(0.25f, 0.15f, 0.05f);
        zapatoDer.setColor(new float[]{1f, 1f, 1f, 1.0f});
        zapatoDer.move(0.15f, 0f, 2);
        partes.add(zapatoDer);

        // Piernas
        Prisma piernaIzq = new Prisma(0.17f, 0.15f, 0.8f);
        piernaIzq.setColor(new float[]{1f, 0.9f, 0.8f, 1.0f});
        piernaIzq.move(-0.15f, 0.4f, 2);
        partes.add(piernaIzq);

        Prisma piernaDer = new Prisma(0.17f, 0.15f, 0.8f);
        piernaDer.setColor(new float[]{1f, 0.9f, 0.8f, 1.0f});
        piernaDer.move(0.15f, 0.4f, 2);
        partes.add(piernaDer);

        // Vestido blanco
        Prisma vestido1 = new Prisma(0.6f, 0.25f, .5f);
        vestido1.setColor(new float[]{1f, 1f, 1f, 1.0f});
        vestido1.move(0f, 1f, 2);
        partes.add(vestido1);

        Prisma vestido2 = new Prisma(0.43f, 0.25f, .7f);
        vestido2.setColor(new float[]{1f, 1f, 1f, 1.0f});
        vestido2.move(0f, 1.55f, 2);
        partes.add(vestido2);

        Prisma vestido3 = new Prisma(0.56f, 0.25f, .25f);
        vestido3.setColor(new float[]{.95f, .95f, .95f, 1.0f});
        vestido3.move(0f, 1.86f, 2f);
        partes.add(vestido3);

        // Cinturón dorado
        Torus cinturon = new Torus(30, 0.25f, 0.05f);
        cinturon.setColor(new float[]{0.9f, 0.8f, 0.2f, 1.0f});
        cinturon.move(0f, 1.3f, 2f);
        cinturon.rotate(90,0,0);
        partes.add(cinturon);

        // Pieza colgante del cinturón
        Prisma colgante = new Prisma(0.1f, 0.01f, 0.3f);
        colgante.setColor(new float[]{0.9f, 0.8f, 0.2f, 1.0f});
        colgante.move(0f, 1.15f, 1.81f);
        partes.add(colgante);

        // Collar dorado
        Torus collar = new Torus(30, 0.1f, 0.03f);
        collar.setColor(new float[]{0.9f, 0.8f, 0.2f, 1.0f});
        collar.move(0f, 2f, 2);
        collar.rotate(90,0,0);
        partes.add(collar);

        // Brazaletes
        Torus brazaleteDer1 = new Torus(20, 0.1f, 0.03f);
        brazaleteDer1.setColor(new float[]{0.9f, 0.8f, 0.2f, 1.0f});
        brazaleteDer1.move(.45f, 1.55f, 2);
        brazaleteDer1.rotate(90,0,0);
        partes.add(brazaleteDer1);

        Torus brazaleteDer2 = new Torus(20, 0.1f, 0.03f);
        brazaleteDer2.setColor(new float[]{0.9f, 0.8f, 0.2f, 1.0f});
        brazaleteDer2.move(0.45f, 1.48f, 2);
        brazaleteDer2.rotate(90,0,0);
        partes.add(brazaleteDer2);

        Torus brazaleteDer3 = new Torus(20, 0.1f, 0.03f);
        brazaleteDer3.setColor(new float[]{0.9f, 0.8f, 0.2f, 1.0f});
        brazaleteDer3.move(0.45f, 1.41f, 2);
        brazaleteDer3.rotate(90,0,0);
        partes.add(brazaleteDer3);

        Torus brazaleteDer = new Torus(20, 0.1f, 0.03f);
        brazaleteDer.setColor(new float[]{0.9f, 0.8f, 0.2f, 1.0f});
        brazaleteDer.move(-0.45f, 1.8f, 2);
        brazaleteDer.rotate(90,0,0);
        partes.add(brazaleteDer);

        // Brazos
        Prisma brazoIzq = new Prisma(0.13f, 0.15f, 0.7f);
        brazoIzq.setColor(new float[]{1f, 0.9f, 0.8f, 1.0f});
        brazoIzq.move(-0.45f, 1.6f, 2);
        partes.add(brazoIzq);

        Prisma brazoDer = new Prisma(0.13f, 0.15f, 0.7f);
        brazoDer.setColor(new float[]{1f, 0.9f, 0.8f, 1.0f});
        brazoDer.move(0.45f, 1.6f, 2);
        partes.add(brazoDer);

        // Manos
        Sphere manoIzq = new Sphere(0.08f, 10, 10);
        manoIzq.setColor(new float[]{1f, 0.9f, 0.8f, 1.0f});
        manoIzq.move(-0.45f, 1.2f, 2);
        partes.add(manoIzq);

        Sphere manoDer = new Sphere(0.08f, 10, 10);
        manoDer.setColor(new float[]{1f, 0.9f, 0.8f, 1.0f});
        manoDer.move(0.45f, 1.2f, 2);
        partes.add(manoDer);

        // Bastón con ankh
        Cilindro baston = new Cilindro(20, 0.03f, 1f);
        baston.setColorPart("all", new float[]{0.9f, 0.8f, 0.2f, 1.0f});
        baston.move(-0.65f, 1.4f, 1.9f);
        baston.rotate(0,0,25);
        partes.add(baston);

        Torus ankh = new Torus(20, 0.1f, 0.025f);
        ankh.setColor(new float[]{0.9f, 0.8f, 0.2f, 1.0f});
        ankh.move(-0.88f, 1.89f, 1.9f);
        ankh.rotate(0,0,25);
        partes.add(ankh);

        // Cuello
        Cilindro cuello = new Cilindro(20, 0.08f, 0.15f);
        cuello.setColorPart("all", new float[]{1f, 0.9f, 0.8f, 1.0f});
        cuello.move(0f, 2.05f, 2f);
        partes.add(cuello);

        // Cabeza
        Sphere cabeza = new Sphere(0.25f, 20, 20);
        cabeza.setColor(new float[]{1f, 0.9f, 0.8f, 1.0f});
        cabeza.move(0f, 2.32f, 2.1f);
        partes.add(cabeza);

        // Cabello
        Prisma cabello = new Prisma(0.55f, 0.5f, 0.55f);
        cabello.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        cabello.move(0f, 2.35f, 2.2f);
        partes.add(cabello);

        // Flequillo
        Prisma flequillo = new Prisma(0.5f, 0.1f, 0.2f);
        flequillo.setColor(new float[]{0.1f, 0.1f, 0.1f, 1.0f});
        flequillo.move(0f, 2.5f, 1.93f);
        partes.add(flequillo);

        // Ojos verdes
        Sphere ojoIzq = new Sphere(0.05f, 10, 10);
        ojoIzq.setColor(new float[]{0f, 0.6f, 0.2f, 1.0f});
        ojoIzq.move(-0.08f, 2.3f, 1.89f);
        partes.add(ojoIzq);

        Sphere ojoDer = new Sphere(0.05f, 10, 10);
        ojoDer.setColor(new float[]{0f, 0.6f, 0.2f, 1.0f});
        ojoDer.move(0.08f, 2.3f, 1.89f);
        partes.add(ojoDer);

        // Cejas
        Prisma cejaIzq = new Prisma(0.1f, 0.01f, 0.01f);
        cejaIzq.setColor(new float[]{0f, 0f, 0f, 1.0f});
        cejaIzq.move(-0.08f, 2.35f, 1.89f);
        partes.add(cejaIzq);

        Prisma cejaDer = new Prisma(0.1f, 0.01f, 0.01f);
        cejaDer.setColor(new float[]{0f, 0f, 0f, 1.0f});
        cejaDer.move(0.08f, 2.35f, 1.89f);
        partes.add(cejaDer);

        // Corona con cobra
        Prisma baseCorona = new Prisma(0.5f, 0.05f, 0.05f);
        baseCorona.setColor(new float[]{0.9f, 0.8f, 0.2f, 1.0f});
        baseCorona.move(0f, 2.48f, 1.89f);
        baseCorona.rotate(90,0,0);
        partes.add(baseCorona);

        Cono cobra = new Cono(0.05f, 0.15f, 10);
        cobra.setColorPart("all", new float[]{0.9f, 0.8f, 0.2f, 1.0f});
        cobra.move(0f, 2.48f, 1.88f);
        partes.add(cobra);

        // Boca
        Prisma labioSuperior = new Prisma(0.12f, 0.02f, 0.01f);
        labioSuperior.setColor(new float[]{0.8f, 0.1f, 0.1f, 1.0f}); // Rojo intenso
        labioSuperior.move(0f, 2.22f, 1.88f);
        labioSuperior.rotate(10f, 0, 0); // Ligera inclinación
        partes.add(labioSuperior);

        Prisma labioInferior = new Prisma(0.12f, 0.02f, 0.01f);
        labioInferior.setColor(new float[]{0.6f, 0.05f, 0.05f, 1.0f}); // Más oscuro
        labioInferior.move(0f, 2.20f, 1.88f);
        labioInferior.rotate(-10f, 0, 0);
        partes.add(labioInferior);

        // Pestañas azules (izquierda)
        Prisma pestanaIzq = new Prisma(0.06f, 0.005f, 0.008f);
        pestanaIzq.setColor(new float[]{0.1f, 0.3f, 0.9f, 1.0f}); // Azul
        pestanaIzq.move(-0.08f, 2.36f, 1.85f);
        pestanaIzq.rotate(0, 0, 25f); // Inclinada
        partes.add(pestanaIzq);

        // Pestañas azules (derecha)
        Prisma pestanaDer = new Prisma(0.06f, 0.005f, 0.008f);
        pestanaDer.setColor(new float[]{0.1f, 0.3f, 0.9f, 1.0f});
        pestanaDer.move(0.08f, 2.36f, 1.85f);
        pestanaDer.rotate(0, 0, -25f);
        partes.add(pestanaDer);

        // Hombro izquierdo
        Prisma hombroIzq = new Prisma(0.13f, 0.1f, 0.1f);
        hombroIzq.setColor(new float[]{1f, 0.9f, 0.8f, 1.0f}); // Color piel
        hombroIzq.move(-0.32f, 1.9f, 2f); // Posición entre vestido y brazo
        partes.add(hombroIzq);

        // Hombro derecho
        Prisma hombroDer = new Prisma(0.13f, 0.1f, 0.1f);
        hombroDer.setColor(new float[]{1f, 0.9f, 0.8f, 1.0f});
        hombroDer.move(0.32f, 1.9f, 2f);
        partes.add(hombroDer);

    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}
