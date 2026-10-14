package org.PixelRent;

public class Kit extends Dispositivo{
    private int luces;
    private boolean control;
    private static final double PRECIO_BASE_KIT = 10000;

    //Constructor
    public Kit(String codigo, String marca,
               String modelo, int horas,
               Sede theSede, int luces, boolean control) {
        super(codigo, marca, modelo, horas, PRECIO_BASE_KIT, theSede);
        this.luces = luces;
        this.control = control;
    }

    //Gets y Sets
    public int getLuces() {
        return luces;
    }

    public void setLuces(int luces) {
        this.luces = luces;
    }

    public boolean isControl() {
        return control;
    }

    public void setControl(boolean control) {
        this.control = control;
    }
}
