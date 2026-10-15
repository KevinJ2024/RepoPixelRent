package org.PixelRent;

public class Dron extends Dispositivo{
    private int autonomia;
    private boolean bateria;
    private static final double PRECIO_BASE_DRON = 18000;

    //Constructor
    public Dron(String codigo, String marca,
                String modelo, Sede theSede, int autonomia, boolean bateria) {
        super(codigo, marca, modelo, 0, PRECIO_BASE_DRON, theSede);
        this.autonomia = autonomia;
        this.bateria = bateria;
    }

    //Gets y Sets
    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public boolean isBateria() {
        return bateria;
    }

    public void setBateria(boolean bateria) {
        this.bateria = bateria;
    }
}
