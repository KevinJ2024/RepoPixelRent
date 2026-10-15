package org.PixelRent;

public abstract class Dispositivo {
    protected String codigo;
    protected String marca;
    protected String modelo;
    protected EstadoEquipo estadoEquipo;
    protected int horas;
    protected double precioBase;

    protected Sede theSede;

    //Constructor
    public Dispositivo(String codigo, String marca,
                       String modelo, int horas,
                       double precioBase, Sede theSede) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.estadoEquipo = EstadoEquipo.DISPONIBLE;
        this.horas = horas;
        this.precioBase = precioBase;
        this.theSede = theSede;
    }

    public void sumarHoras(int horasNuevas){
        this.horas += horasNuevas;
    }

    //Gets y Sets
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public EstadoEquipo getEstadoEquipo() {
        return estadoEquipo;
    }

    public void setEstadoEquipo(EstadoEquipo estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Sede getTheSede() {
        return theSede;
    }

    public void setTheSede(Sede theSede) {
        this.theSede = theSede;
    }
}
