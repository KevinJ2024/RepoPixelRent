package org.PixelRent;

import java.time.LocalDate;
import java.util.LinkedList;

public class Reserva {
    private String codigo;
    private LocalDate fecha;
    private Turno turno;
    private EstadoReserva estadoReserva;
    private LinkedList<Dispositivo> listDispositivos;

    //Constructor

    public Reserva(String codigo, LocalDate fecha,
                   Turno turno, EstadoReserva estadoReserva) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.turno = turno;
        this.estadoReserva = estadoReserva;
        this.listDispositivos = null;
    }

    //Gets y Sets
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public LinkedList<Dispositivo> getListDispositivos() {
        return listDispositivos;
    }

    public void setListDispositivos(LinkedList<Dispositivo> listDispositivos) {
        this.listDispositivos = listDispositivos;
    }
}
