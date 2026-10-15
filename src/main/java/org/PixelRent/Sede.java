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

    public boolean registrarDron(String codigo, String marca, String modelo, Sede theSede, int autonomia, boolean bateria) {
        if (validarCodigoDispositivo(codigo)){
            for (Dispositivo dispositivo : this.listDispositivos) {
                if (dispositivo.getCodigo().equals(codigo)) {
                    return false;
                }
            }

            Dron nuevoDron = new Dron(codigo, marca, modelo, theSede, autonomia, bateria);
            return this.listDispositivos.add(nuevoDron);
        }else{
            return false;
        }
    }

    public boolean registrarKit(String codigo, String marca, String modelo, Sede theSede, int luces, boolean control) {
        if(validarCodigoDispositivo(codigo)){
            for (Dispositivo dispositivo : this.listDispositivos) {
                if (dispositivo.getCodigo().equals(codigo)) {
                    return false;
                }
            }

            Kit nuevoKit = new Kit(codigo, marca, modelo, theSede, luces, control);
            return this.listDispositivos.add(nuevoKit);
        }else{
            return false;
        }
    }

    public boolean registrarCamara(String codigo, String marca, String modelo, Sede theSede, String resolucionMax, boolean estabilizador) {
        if (validarCodigoDispositivo(codigo)){
            for (Dispositivo dispositivo : this.listDispositivos) {
                if (dispositivo.getCodigo().equals(codigo)) {
                    return false;
                }
            }

            Camara nuevaCamara = new Camara(codigo, marca, modelo, theSede, resolucionMax, estabilizador);
            return this.listDispositivos.add(nuevaCamara);
        }else{
            return false;
        }
    }

//    public Dispositivo buscarDispositivo(String codigoDispositivo) {
//        for (Dispositivo dispositivo : this.listDispositivos) {
//            if (dispositivo.getCodigo().equals(codigoDispositivo)) {
//                return dispositivo;
//            }
//        }
//        return null;
//    }

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
