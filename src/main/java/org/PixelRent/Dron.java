package org.PixelRent;

public class Dron extends Dispositivo{
    private int autonomia;
    private boolean bateria;

    //Constructor
    public Dron(String codigo, String marca,
                String modelo, int horas,
                double precioBase, Sede theSede,
                int autonomia, boolean bateria) {
        super(codigo, marca, modelo, horas, precioBase, theSede);
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
