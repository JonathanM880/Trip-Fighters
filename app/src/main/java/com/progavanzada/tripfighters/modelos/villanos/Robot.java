package com.progavanzada.tripfighters.modelos.villanos;

import com.progavanzada.tripfighters.figuras.Cilindro;
import com.progavanzada.tripfighters.figuras.Cono;
import com.progavanzada.tripfighters.figuras.Figura;
import com.progavanzada.tripfighters.figuras.Sphere;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private List<Figura> partes;
    public Robot() {

        //Modela el personaje en (0f en x) y (2f en z)
        // el centro de tu personaje

        partes = new ArrayList<>();

        // eje x
        Sphere sp = new Sphere(.3f,30,30);
        sp.move(0,0,0);
        //partes.add(sp);

        // pies
        Cilindro pieIzq = new Cilindro(4,.42f,.5f);
        pieIzq.setColorPart("all", new float[] {.15f,.15f,.15f,1.0f});
        pieIzq.move(-.5f, .25f, 2);
        pieIzq.rotate(0,45,0);
        partes.add(pieIzq);

        Cilindro pieDer = new Cilindro(4,.42f,.5f);
        pieDer.setColorPart("all", new float[] {.15f,.15f,.15f,1.0f});
        pieDer.move(.5f, .25f, 2);
        pieDer.rotate(0,45,0);
        partes.add(pieDer);

        //piernas
        Cilindro piernaIzq = new Cilindro(4,.25f,1f);
        piernaIzq.setColorPart("all", new float[] {0.2f,.2f,.2f,1.0f});
        piernaIzq.move(-.5f, 1f, 2);
        piernaIzq.rotate(0,45,0);
        partes.add(piernaIzq);

        Cilindro piernaDer = new Cilindro(4,.25f,1f);
        piernaDer.setColorPart("all", new float[] {0.2f,.2f,.2f,1.0f});
        piernaDer.move(.5f, 1f, 2);
        piernaDer.rotate(0,45,0);
        partes.add(piernaDer);

        //pelvis
        Cono pelvis = new Cono(1f,.5f,4);
        pelvis.setColorPart("all", new float[]{0,0,0,1.0f});
        pelvis.move(0,1.6f,2);
        pelvis.rotate(0,0,180);
        pelvis.rotate(0,45,0);
        partes.add(pelvis);

        //cuerpo
        Cilindro cBajo = new Cilindro(4, 1f, .5f);
        cBajo.setColorPart("all",new float[] {.1f,.1f,.2f,1.0f});
        cBajo.move(0, 1.85f,2);
        cBajo.rotate(0,45,0);
        partes.add(cBajo);

        Cilindro cAlto = new Cilindro(4, 1.1f, .6f);
        cAlto.setColorPart("all",new float[] {0.4f,.4f,.4f,1.0f});
        cAlto.move(0, 2.4f,2);
        cAlto.rotate(0,45,0);
        partes.add(cAlto);

        //cabeza
        Cilindro cabeza = new Cilindro(4, .7f, .6f);
        cabeza.setColorPart("all",new float[] {0.05f,0.05f,.05f,1.0f});
        cabeza.move(0, 3f,2);
        cabeza.rotate(0,45,0);
        partes.add(cabeza);

        //hombros
        Cilindro hombroIzq = new Cilindro(4, .4f, .4f);
        hombroIzq.setColorPart("all",new float[] {.1f,.1f,.1f,1.0f});
        hombroIzq.move(1f, 2.7f,2);
        hombroIzq.rotate(0,45,0);
        partes.add(hombroIzq);

        Cilindro hombroDer = new Cilindro(4, .4f, .4f);
        hombroDer.setColorPart("all",new float[] {.1f,.1f,.1f,1.0f});
        hombroDer.move(-1f, 2.7f,2);
        hombroDer.rotate(0,45,0);
        partes.add(hombroDer);

        //brazos
        Cilindro brazoIzq = new Cilindro(4,.25f,1f);
        brazoIzq.setColorPart("all", new float[] {0.25f,0.25f,.25f,1.0f});
        brazoIzq.move(-1.1f, 2f, 2);
        brazoIzq.rotate(0,45,0);
        partes.add(brazoIzq);

        Cilindro brazoDer = new Cilindro(4,.25f,1f);
        brazoDer.setColorPart("all", new float[] {0.25f,0.25f,.25f,1.0f});
        brazoDer.move(1.1f, 2f, 2);
        brazoDer.rotate(0,45,0);
        partes.add(brazoDer);

        //manos
        Cono manoIzq = new Cono(.25f,.25f,4);
        manoIzq.setColorPart("all", new float[]{0.5f,.5f,.5f,1.0f});
        manoIzq.move(1.1f,1.5f,2);
        manoIzq.rotate(0,0,180);
        manoIzq.rotate(0,45,0);
        partes.add(manoIzq);

        Cono manoDer = new Cono(.25f,.25f,4);
        manoDer.setColorPart("all", new float[]{0.5f,.5f,.5f,1.0f});
        manoDer.move(-1.1f,1.5f,2);
        manoDer.rotate(0,0,180);
        manoDer.rotate(0,45,0);
        partes.add(manoDer);

        //ojos
        Sphere ojoIzq = new Sphere(.2f,30,30);
        ojoIzq.setColor(new float[]{1,0,0,1.0f});
        ojoIzq.move(-.2f,3.05f,1.65f);
        partes.add(ojoIzq);

        Sphere ojoDer = new Sphere(.2f,30,30);
        ojoDer.setColor(new float[]{1,0,0,1.0f});
        ojoDer.move(.2f,3.05f,1.65f);
        partes.add(ojoDer);
    }

    public void draw(float[] mvpMatrix) {
        for (Figura f : partes) {
            f.draw(mvpMatrix);
        }
    }
}
