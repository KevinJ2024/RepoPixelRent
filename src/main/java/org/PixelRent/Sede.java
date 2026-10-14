package org.PixelRent;

import java.util.LinkedList;

public class Sede {
    private String codigo;
    private String nombre;
    private String direccion;
    private LinkedList<Dispositivo> listDispositivos;

    //Constructor
    public Sede(String codigo, String nombre,
                String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listDispositivos = null;
    }

    

    public boolean ValidarCodigoDispositivo(){
        return false;
    }

    public boolean registrarCamara(){
        return false;
    }

    public boolean registrarDron(String codigo, String marca, String modelo, int horas, double precioBase, Sede theSede, int autonomia, boolean bateria) {
        for (Dispositivo dispositivo : this.listDispositivos) {
            if (dispositivo.getCodigo().equals(codigo)) {
                return false;
            }
        }
        
        Dron nuevoDron = new Dron(codigo, marca, modelo, horas, precioBase, theSede, autonomia, bateria);
        return this.listDispositivos.add(nuevoDron);
    }

    public boolean registrarKit(String codigo, String marca, String modelo, int horas, double precioBase, Sede theSede, int luces, boolean control) {
        for (Dispositivo dispositivo : this.listDispositivos) {
            if (dispositivo.getCodigo().equals(codigo)) {
                return false;
            }
        }
        
        Kit nuevoKit = new Kit(codigo, marca, modelo, horas, precioBase, theSede, luces, control);
        return this.listDispositivos.add(nuevoKit);
    }
    public boolean registrarCamara(String codigo, String marca, String modelo, int horas, double precioBase, Sede theSede, String resolucionMax, boolean estabilizador) {
        for (Dispositivo dispositivo : this.listDispositivos) {
            if (dispositivo.getCodigo().equals(codigo)) {
                return false;
            }
        }
        
        Camara nuevaCamara = new Camara(codigo, marca, modelo, horas, precioBase, theSede, resolucionMax, estabilizador);
        return this.listDispositivos.add(nuevaCamara);
    }


    public Dispositivo buscarDispositivo(String codigoDispositivo) {
        for (Dispositivo dispositivo : this.listDispositivos) {
            if (dispositivo.getCodigo().equals(codigoDispositivo)) {
                return dispositivo;
            }
        }
        return null;
    }
        
    
    //Gets y Sets
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LinkedList<Dispositivo> getListDispositivos() {
        return listDispositivos;
    }

    public void setListDispositivos(LinkedList<Dispositivo> listDispositivos) {
        this.listDispositivos = listDispositivos;
    }
}
