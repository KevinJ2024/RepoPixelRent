package org.PixelRent;

import java.time.LocalDate;
import java.util.LinkedList;

public class Empresa {

    private String codigo;
    private String nombre;
    private String direccion;

    private LinkedList<Cliente> listClientes;
    private LinkedList<Operador> listOperadores;
    private LinkedList<Reserva> listReservas;
    private LinkedList<Sede> listSedes;

    //Constructor
    public Empresa(String codigo, String nombre, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;

        this.listClientes = new LinkedList<>();
        this.listOperadores = new LinkedList<>();
        this.listReservas = new LinkedList<>();
        this.listSedes = new LinkedList<>();
    }

    public boolean validarCodigoReserva(String codigoNuevo) {
        boolean validado = true;

        //Que no este vacia la lista
        if (this.listReservas != null) {
            //Ciclo para comprobar las otras reservas
            for (Reserva reserva : listReservas) {
                //Que el dispositivo actual no sea nulo
                if (reserva != null) {
                    /*Si la reserva actual a agregar no comparte codigo con
                    ninguno de la lista se valida como verdadera la validacion*/
                    if (codigoNuevo.equals(reserva.getCodigo())) {
                        validado = false;
                    }
                }
            }
        }
        return validado;
    }

    public boolean cambiarEstadoReserva(EstadoReserva estadoReserva, Reserva reserva) {
        if (reserva != null) {
            return reserva.actualizarEstado(estadoReserva, this.listReservas);
        }
        return false;
    }

    public LinkedList<Dispositivo> consultarDispositivosDisp(LocalDate fecha, Turno turno) {
        //Creacion de la lista nueva con los dispositivos disponibles
        LinkedList<Dispositivo> dispositivosDisponibles = new LinkedList<>();

        //Validaciones de datos faltantes
        if (fecha == null || turno == null || this.listSedes == null || this.listSedes.isEmpty()) {
            return dispositivosDisponibles;
        }

        /*Se crea otra lista en la que se almacenaran los codigos que ya
         esten reservados para la fecha y turno consultado
         */
        LinkedList<String> codigosOcupados = new LinkedList<>();

        if (this.listReservas != null) {
            //Ciclo sobre la lista de reservas
            for (Reserva reserva : this.listReservas) {
                //Se filtran reservas que coincidan en fecha y turno a las ingresadas
                if (reserva != null && fecha.equals(reserva.getFecha()) && turno == reserva.getTurno()) {
                    if (reserva.getListDispositivos() != null) {
                        //Se realiza ciclo sobre los dispositivos de la reserva
                        for (Dispositivo dispositivo : reserva.getListDispositivos()) {
                            if (dispositivo != null && dispositivo.getCodigo() != null) {
                                codigosOcupados.add(dispositivo.getCodigo());
                            }
                        }
                    }
                }
            }
        }

        //Se recorre todas las sedes en busca de los dispositivos
        for (Sede sede : this.listSedes) {
            //Comprobacion de la existencia de la sede y su lista de dispositivos
            if (sede != null && sede.getListDispositivos() != null) {
                //Ciclo sobre la lista de dispositivos
                for (Dispositivo dispSede : sede.getListDispositivos()) {
                    if (dispSede != null && dispSede.getCodigo() != null) {

                        //Si el dispositivo de la sede no esta en la lista de ocupados se asume como disponible
                        if (!codigosOcupados.contains(dispSede.getCodigo())) {
                            dispositivosDisponibles.add(dispSede);
                        }
                    }
                }
            }
        }

        return dispositivosDisponibles;
    }

    public Reserva consultarReservaIdCliente(String idCliente) {
        if (!idCliente.equals("") || listReservas != null) {
            for (Reserva reserva : listReservas) {
                if (reserva != null && reserva.getTheCliente().identificacion().equals(idCliente)) {
                    return reserva;
                }
            }
        }

        return null;
    }

    public Cliente consultarClienteId(String id) {
        if (listClientes != null) {
            for (Cliente cliente : listClientes) {
                if (cliente != null) {
                    if (cliente.identificacion().equals(id)) {
                        return cliente;
                    }
                }
            }
        }
        return null;
    }

    public Operador consultarOperadorId(String id) {
        if (listOperadores != null) {
            for (Operador operador : listOperadores) {
                if (operador != null) {
                    if (operador.getIdentificacion().equals(id)) {
                        return operador;
                    }
                }
            }
        }
        return null;
    }

    //Gets y Sets
    public Sede encontrarSede(String codigoSede) {
        for (Sede sede : listSedes) {
            if (sede.getCodigo().equals(codigoSede)) {
                return sede;
            }
        }
        return null;
    }

    public boolean registrarReserva(String codigo, LocalDate fecha, Turno turno, EstadoReserva estado, Cliente cliente, Operador operador) {
        for (Reserva reserva : this.listReservas) {
            if (reserva.getCodigo().equals(codigo)) {
                return false;
            }
        }

        Reserva nuevaReserva = new Reserva(codigo, fecha, turno, estado, cliente, operador);
        return this.listReservas.add(nuevaReserva);
    }

    //Gets y Sets
    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LinkedList<Cliente> getListClientes() {
        return this.listClientes;
    }

    public void setListClientes(LinkedList<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public LinkedList<Operador> getListOperadores() {
        return this.listOperadores;
    }

    public void setListOperadores(LinkedList<Operador> listOperadores) {
        this.listOperadores = listOperadores;
    }

    public LinkedList<Reserva> getListReservas() {
        return this.listReservas;
    }

    public void setListReservas(LinkedList<Reserva> listReservas) {
        this.listReservas = listReservas;
    }

    public LinkedList<Sede> getListSedes() {
        return this.listSedes;
    }

    public void setListSedes(LinkedList<Sede> listSedes) {
        this.listSedes = listSedes;
    }
}
