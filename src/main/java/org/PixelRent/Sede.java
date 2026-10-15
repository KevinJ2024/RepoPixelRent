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
        this.listDispositivos = new LinkedList<Dispositivo>();
    }

    public boolean validarCodigoDispositivo(String nuevoCodigo) {
        if (nuevoCodigo == null || nuevoCodigo.trim().isEmpty()) {
            return false;
        }
        if (this.listDispositivos != null) {
            for (Dispositivo dispositivo : this.listDispositivos) {
                if (dispositivo != null && nuevoCodigo.equals(dispositivo.getCodigo())) {
                    return false; // Ya existe un dispositivo con ese código
                }
            }
        }
        return true; // Si la lista está vacía o no encontró repetidos, es válido
    }

    public boolean registrarDron(String codigo, String marca, String modelo, Sede theSede, int autonomia, boolean bateria) {
        if (validarCodigoDispositivo(codigo)) {
            Dron nuevoDron = new Dron(codigo, marca, modelo, theSede, autonomia, bateria);
            return this.listDispositivos.add(nuevoDron);
        }
        return false;
    }

    public boolean registrarKit(String codigo, String marca, String modelo, Sede theSede, int luces, boolean control) {
        if (validarCodigoDispositivo(codigo)) {
            Kit nuevoKit = new Kit(codigo, marca, modelo, theSede, luces, control);
            return this.listDispositivos.add(nuevoKit);
        }
        return false;
    }

    public boolean registrarCamara(String codigo, String marca, String modelo, Sede theSede, String resolucionMax, boolean estabilizador) {
        if (validarCodigoDispositivo(codigo)) {
            Camara nuevaCamara = new Camara(codigo, marca, modelo, theSede, resolucionMax, estabilizador);
            return this.listDispositivos.add(nuevaCamara);
        }
        return false;
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
