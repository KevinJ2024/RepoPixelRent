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

    public double calcularTotal() {
        double total = 0.0;
        //Comprobar que existe la listas
        if (listDispositivos != null && listHorasUsados != null) {
            //se recorre la lista de dispositivos con un for normal para tener los index
            for (int i = 0; i < listDispositivos.size(); i++) {
                //Se obtiene el dispositivo actual del ciclo
                Dispositivo dispositivo = listDispositivos.get(i);

                if (dispositivo != null) {
                    //Se obtienen las horas del dispositivo ubicado en la misma posicion en la otra lista de horas
                    int horas = listHorasUsados.get(i);

                    //Se calcula el precio base con las horas
                    double precioHoras = dispositivo.getPrecioBase() * horas;

                    //Se adiciona el adicional en caso de poseer
                    total += precioHoras + obtenerValorAdicional(dispositivo);
                }
            }
        }
        return total;
    }

    private double obtenerValorAdicional(Dispositivo dispositivo) {
        double adicional = 0.0;
        if (dispositivo instanceof Dron) {
            if (((Dron) dispositivo).isBateria()) {
                adicional += 20000;
            }
        } else if (dispositivo instanceof Camara) {
            if (((Camara) dispositivo).isEstabilizador()) {
                adicional += 15000;
            }
        } else if (dispositivo instanceof Kit) {
            if (((Kit) dispositivo).isControl()) {
                adicional += 12000;
            }
        }

        return adicional;
    }

    public boolean agregarDispositivo(Dispositivo dispositivoNuevo) {
        boolean sePuedeAgregar = true;
        boolean agregado = false;

        if (listDispositivos != null) {
            for (Dispositivo dispositivo : listDispositivos) {
                if (dispositivo.getCodigo().equals(dispositivoNuevo.getCodigo())) {
                    sePuedeAgregar = false;
                }
            }

            if (sePuedeAgregar) {
                listDispositivos.add(dispositivoNuevo);
                agregado = true;
            }
        }
        return agregado;
    }

    public boolean actualizarEstado(EstadoReserva estadoNuevo, LinkedList<Reserva> reservasExistentes) {
        boolean actualizado = false;

        if (estadoNuevo == EstadoReserva.CONFIRMADA && (estadoReserva != EstadoReserva.CANCELADA && estadoReserva != EstadoReserva.FINALIZADA)) {
            // Se valida el operador Y que no existan colisiones de fecha, turno y dispositivo
            if (validarOperador() && validarFechaDispositivos(reservasExistentes)) {
                this.setEstadoReserva(estadoNuevo);
                actualizado = true; // Se marca como actualizado exitosamente
            }
        } else {
            //Para otros estados se cambia sin validaciones
            this.setEstadoReserva(estadoNuevo);
            actualizado = true;
        }

        return actualizado;
    }

    private boolean validarFechaDispositivos(LinkedList<Reserva> reservasExistentes) {
        //Validar lista de dispositivos de la reserva actual
        if (this.listDispositivos == null || this.listDispositivos.isEmpty()) {
            return false;
        }

        //Se recorren todos los dispositivos de la reserva actual
        for (Dispositivo dispNuevo : this.listDispositivos) {
            if (dispNuevo == null) continue;

            //Recorremos las demás reservas de la lista
            for (Reserva reservaExistente : reservasExistentes) {
                //Evitamos comparar con nulos o con esta misma reserva
                if (reservaExistente == null || reservaExistente == this) continue;

                //Si coinciden la fecha y el turno de la reserva actual con la existente
                if (this.fecha != null && this.fecha.equals(reservaExistente.getFecha())
                        && this.turno == reservaExistente.getTurno()) {

                    if (reservaExistente.getListDispositivos() == null) continue;

                    //Comparamos los dispositivos
                    for (Dispositivo dispExistente : reservaExistente.getListDispositivos()) {
                        if (dispExistente != null && dispNuevo.getCodigo().equals(dispExistente.getCodigo())) {
                            //Coinciden fechas y turnos
                            return false;
                        }
                    }
                }
            }
        }
        return true;
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

    public LinkedList<Integer> getListHorasUsados() {
        return listHorasUsados;
    }

    public void setListHorasUsados(LinkedList<Integer> listHorasUsados) {
        this.listHorasUsados = listHorasUsados;
    }

    public Operador getTheOperador() {
        return theOperador;
    }

    public void setTheOperador(Operador theOperador) {
        this.theOperador = theOperador;
    }

    public Cliente getTheCliente() {
        return theCliente;
    }

    public void setTheCliente(Cliente theCliente) {
        this.theCliente = theCliente;
    }

    public void setListDispositivos(LinkedList<Dispositivo> listDispositivos) {
        this.listDispositivos = listDispositivos;
    }
}
