package org.PixelRent;

import java.time.LocalDate;
import java.util.LinkedList;

public class Reserva {
    private String codigo;
    private final LocalDate fecha;
    private final Turno turno;
    private EstadoReserva estadoReserva;
    private LinkedList<Dispositivo> listDispositivos;
    private LinkedList<Integer> listHorasUsados;

    private Operador theOperador;
    private Cliente theCliente;

    //Constructor

    public Reserva(String codigo, LocalDate fecha,
                   Turno turno, EstadoReserva estadoReserva,
                   Cliente theCliente, Operador theOperador) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.turno = turno;
        this.estadoReserva = estadoReserva;
        this.listDispositivos = new LinkedList<Dispositivo>();
        this.listHorasUsados = new LinkedList<Integer>();
        this.theCliente = theCliente;
        this.theOperador = theOperador;
    }

    public boolean validarOperador() {
        boolean validado = false;
        //Comprobar que la lista no sea nula
        if (listDispositivos != null) {
            boolean tieneDron = false;
            //Ciclo para saber si algun dispositivo es un dron
            for (Dispositivo dispositivo : listDispositivos) {
                if (dispositivo instanceof Dron) {
                    tieneDron = true;
                }
            }
            //Validacion de si al tener un dron tambien el operador asociado esta capacitado
            if (tieneDron) {
                if (theOperador.getCertificacion().equals("Dron")) {
                    validado = true;
                }
            } else {
                validado = true;
            }
        }
        return validado;
    }

    public void contadorTiempo(String codigoDispositivo, int horasUsadas) {
        // Si ambas listas existen se sigue el proceso
        if (listDispositivos != null && listHorasUsados != null) {

            int index = 0; //index para tener en consideracion la posicion actual del elemento del ciclo

            for (Dispositivo dispositivo : listDispositivos) {
                //Se valida que exista el dispositivo actual a considerar
                if (dispositivo != null) {
                    //Se halla el dispositivo a considerar
                    if (dispositivo.getCodigo().equals(codigoDispositivo)) {
                        //Si se hallo el elemento se añade en la misma posicion en el que se encontro
                        listHorasUsados.set(index, horasUsadas);
                        break; //Se rompe el ciclo porque ya se asigno la hora al dispositivo
                    }
                }
                index++;
            }
        }
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

    public Turno getTurno() {
        return turno;
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
