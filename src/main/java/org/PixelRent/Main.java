package org.PixelRent;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.LinkedList;

public class Main {
    static Empresa pixelRent = new Empresa("PixelRent", "16283", "calle 19 norte numero 21-34");
    static Sede sedePrincipal = new Sede("PixelRent", "16283", "calle 19 norte numero 21-34");

    public static void main(String[] args) {
        boolean bandera = true;
        do {
            int dato = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "MENU DE PixelRent" +
                            "\n1.Registrar dispositivo" +
                            "\n2. " +
                            "\n3. " +
                            "\n0. salir del sistema"));

            switch (dato) {
                case 1:
                    registrarDispositivo();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    bandera = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opcion no valida");

            }
        } while (bandera);
    }

    public static void registrarDispositivo() {
        boolean bandera = true;

        do {
            int dato = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Escoja el dispositivo a registrar\n" +
                            "1. Registrar dron\n" +
                            "2. Registrar camara\n" +
                            "3. Registrar kit\n" +
                            "0. Salir"));

            switch (dato) {
                case 1:
                    registrarDron();
                    break;
                case 2:
                    registrarCamara();
                    break;
                case 3:
                    registrarKit();
                    break;
                case 0:
                    bandera = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opcion no valida");
            }
        } while (bandera);
    }

    public static void registrarDron() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del Dron:");
        String marca = JOptionPane.showInputDialog("Ingrese la marca:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
        String codigoSede = JOptionPane.showInputDialog("Ingrese el código de la sede para el Dron:");
        Sede theSede = pixelRent.encontrarSede(codigoSede);
        int autonomia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la autonomía de vuelo (en minutos):"));
        String opcionBateria = JOptionPane.showInputDialog(null, "¿Cuenta con batería adicional?\nsi\nno");
        boolean bateria;
        if (opcionBateria.equals("si")) {
            bateria = true;
        } else {
            bateria = false;
        }

        boolean verificacion = sedePrincipal.registrarDron(codigo, marca, modelo, theSede, autonomia, bateria);
        if (verificacion) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } else {
            JOptionPane.showMessageDialog(null, "No se hizo el registro");
        }
    }


    public static void registrarCamara() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código de la Cámara:");
        String marca = JOptionPane.showInputDialog("Ingrese la marca:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
        String codigoSede = JOptionPane.showInputDialog("Ingrese el código de la Sede para la cámara:");
        Sede theSede = pixelRent.encontrarSede(codigoSede);

        String resolucionMax = JOptionPane.showInputDialog("Ingrese la resolución máxima (Ej: 4K, 1080p):");
        String opcionEstabilizador = JOptionPane.showInputDialog(null, "¿Cuenta con estabilizador (si/no)?");

        boolean estabilizador;
        if (opcionEstabilizador.equalsIgnoreCase("si")) {
            estabilizador = true;
        } else {
            estabilizador = false;
        }

        boolean verificacion = sedePrincipal.registrarCamara(codigo, marca, modelo, theSede, resolucionMax, estabilizador);

        if (verificacion) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } else {
            JOptionPane.showMessageDialog(null, "No se hizo el registro");
        }
    }


    public static void registrarKit() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del Kit:");
        String marca = JOptionPane.showInputDialog("Ingrese la marca:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
        String codigoSede = JOptionPane.showInputDialog("Ingrese el código de la Sede para el Kit:");
        Sede theSede = pixelRent.encontrarSede(codigoSede);

        int luces = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de luces:"));
        String opcionControl = JOptionPane.showInputDialog(null, "¿Cuenta con control inalámbrico (si/no)?");
        boolean control;

        if (opcionControl.equals("si")) {
            control = true;
        } else {
            control = false;
        }

        boolean verificacion = sedePrincipal.registrarKit(codigo, marca, modelo, theSede, luces, control);

        if (verificacion) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } else {
            JOptionPane.showMessageDialog(null, "No se hizo el registro");
        }
    }


    public static void registrarReserva() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código de la reserva:");

        String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha (Ej: 2026-10-14):");
        LocalDate fecha = LocalDate.parse(fechaStr);

        String turnoStr = JOptionPane.showInputDialog("Ingrese el turno (MAÑANA, TARDE, NOCHE):");
        Turno turno = Turno.valueOf(turnoStr.toUpperCase());

        String estadoStr = JOptionPane.showInputDialog("Ingrese el estado (PENDIENTE, ACTIVA, etc):");
        EstadoReserva estado = EstadoReserva.valueOf(estadoStr.toUpperCase());

        String idCliente = JOptionPane.showInputDialog("Ingrese el ID del cliente");
        Cliente cliente = pixelRent.consultarClienteId(idCliente);

        String idOperador = JOptionPane.showInputDialog("Ingrese el ID del operador");
        Operador operador = pixelRent.consultarOperadorId(idOperador);

        boolean verificacion = pixelRent.registrarReserva(codigo, fecha, turno, estado, cliente, operador);

        if (verificacion) {
            JOptionPane.showMessageDialog(null, "¡Reserva guardada con éxito!");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la reserva.");
        }
    }


}
