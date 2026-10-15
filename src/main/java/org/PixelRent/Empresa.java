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

    public boolean validarCodigoReserva(String codigoNuevo){
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

    public void consultarDispositivosDisp(LocalDate fecha, Turno turno){

    }

    public Reserva consultarReservaIdCliente(String idCliente){


        return null;
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
