package org.PixelRent;

import java.util.LinkedList;

public class Operador {
    private String identificacion;
    private String nombre;
    private String telefono;
    private String correo;

    private LinkedList<Reserva> listReservas;

    //Constructor
    public Operador(String identificacion, String nombre,
                    String telefono, String correo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LinkedList<Reserva> getListReservas() {
        return listReservas;
    }

    public void setListReservas(LinkedList<Reserva> listReservas) {
        this.listReservas = listReservas;
    }
}
