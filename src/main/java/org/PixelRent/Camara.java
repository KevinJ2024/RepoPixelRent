package org.PixelRent;

public class Camara extends Dispositivo {
    private String resolucionMax;
    private boolean estabilizador;
    private static final double PRECIO_BASE_CAMARA = 12000;

    //Constructor
    public Camara(String codigo, String marca,
                  String modelo, Sede theSede, String resolucionMax, boolean estabilizador) {
        super(codigo, marca, modelo, 0, PRECIO_BASE_CAMARA, theSede);
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
