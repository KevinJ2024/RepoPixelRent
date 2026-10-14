package org.PixelRent;

import java.util.LinkedList;

public class Operador {
    private String identificacion;
    private String nombre;
    private String telefono;
    private String certificacion;
    private int aniosExp;

    private LinkedList<Reserva> listReservas;

    //Constructor
    public Operador(String identificacion, String nombre,
                    String telefono, String certificacion,
                    int aniosExp) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.certificacion = certificacion;
        this.aniosExp = aniosExp;
        this.listReservas = null;
    }


    //Gets y Sets
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }

    public int getAniosExp() {
        return aniosExp;
    }

    public void setAniosExp(int aniosExp) {
        this.aniosExp = aniosExp;
    }

    public LinkedList<Reserva> getListReservas() {
        return listReservas;
    }

    public void setListReservas(LinkedList<Reserva> listReservas) {
        this.listReservas = listReservas;
    }
}
