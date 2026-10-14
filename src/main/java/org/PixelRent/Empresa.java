package org.PixelRent;

import java.util.LinkedList;

public class Empresa {

    private String codigo;
    private String nombre;
    private String direccion;
    
    private LinkedList<Cliente> listClientes;
    private LinkedList<Operador> listOperadores;
    private LinkedList<Reserva> listReservas;
    private LinkedList<Sede> listSedes;

    public Empresa(String codigo, String nombre, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        
        this.listClientes = new LinkedList<>();
        this.listOperadores = new LinkedList<>();
        this.listReservas = new LinkedList<>();
        this.listSedes = new LinkedList<>();
    }

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
