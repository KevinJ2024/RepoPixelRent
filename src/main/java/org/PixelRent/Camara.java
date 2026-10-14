package org.PixelRent;

public class Camara extends Dispositivo {
    private String resolucionMax;
    private boolean estabilizador;

    //Constructor
    public Camara(String codigo, String marca,
                  String modelo, int horas,
                  double precioBase, Sede theSede,
                  String resolucionMax, boolean estabilizador) {
        super(codigo, marca, modelo, horas, precioBase, theSede);
        this.resolucionMax = resolucionMax;
        this.estabilizador = estabilizador;
    }


    //Gets y Sets
    public String getResolucionMax() {
        return resolucionMax;
    }

    public void setResolucionMax(String resolucionMax) {
        this.resolucionMax = resolucionMax;
    }

    public boolean isEstabilizador() {
        return estabilizador;
    }

    public void setEstabilizador(boolean estabilizador) {
        this.estabilizador = estabilizador;
    }
}
