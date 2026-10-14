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

    public boolean ValidarCodigoDispositivo(String nuevoCodigo) {
        boolean validado = false;

        //Que no este vacia la lista
        if (this.listDispositivos != null) {
            //Ciclo para comprobar los otros dispositivos
            for (Dispositivo dispositivo : listDispositivos) {
                //Que el dispositivo actual no sea nulo
                if (dispositivo != null) {
                    /*Si el dispositivo actual a agregar no comparte codigo con
                    ninguno de la lista se valida como verdadera la validacion*/
                    if (!nuevoCodigo.equals(dispositivo.getCodigo())) {
                        validado = true;
                    }
                }
            }
        }

        return validado;
    }

    public boolean registrarCamara() {
        return false;
    }

    public boolean registrarDron() {
        return false;
    }

    public boolean registrarKit() {
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
