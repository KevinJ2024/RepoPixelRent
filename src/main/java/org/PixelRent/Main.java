package org.PixelRent;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.LinkedList;

public class Main {
    static Empresa pixelRent = new Empresa("PixelRent", "16283", "calle 19 norte numero 21-34");

    public static void main(String[] args) {
        boolean bandera = true;
        do {
            int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "MENU DE PixelRent" +
                    "\n1.Registrar dispositivo" +
                    "\n2.Registrar cliente" +
                    "\n3.Registrar operador" +
                    "\n4.Registrar sede" +
                    "\n5.Registrar reserva" +
                    "\n6.Menu Consultas" +
                    "\n7.Actualizar estado de una reserva" +
                    "\n8.Agregar dispositivo a reserva" +
                    "\n0. salir del sistema"));

            switch (dato) {
                case 1:
                    registrarDispositivo();
                    break;
                case 2:
                    registrarCliente();
                    break;
                case 3:
                    registrarOperador();
                    break;
                case 4:
                    registrarSede();
                    break;
                case 5:
                    registrarReserva();
                    break;
                case 6:
                    menuConsultar();
                    break;
                case 7:
                    actualizarEstadoReserva();
                    break;
                case 8:
                    agregarDispositivoReserva();
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
            int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Escoja el dispositivo a registrar\n" +
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

    public static void menuConsultar() {
        boolean bandera = true;

        do {
            int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu de consulta\n" +
                    "1. Consultar Reservas confirmadas por cliente\n" +
                    "2. Consultar Reservas por codigo\n" +
                    "3. Consultar Dispositivos Disponibles\n" +
                    "0. Salir"));

            switch (dato) {
                case 1:
                    consultarReservaId();
                    break;
                case 2:
                    consultarReservaCodigo();
                    break;
                case 3:
                    consultarDispositivosDisp();
                    break;
                case 0:
                    bandera = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opcion no valida");
            }
        } while (bandera);
    }

    //Metodos de registro
   public static void registrarDron() {
    String codigo = JOptionPane.showInputDialog("Ingrese el código del Dron:");
    if (pixelRent.consultarDispositivoCodigo(codigo) != null) {
        JOptionPane.showMessageDialog(null, "Error: Ya existe un dispositivo con ese código en la empresa.");
        return;
    }

    String codigoSede = JOptionPane.showInputDialog("Ingrese el código de la Sede para el Dron:");
    Sede theSede = pixelRent.encontrarSede(codigoSede);
    if (theSede == null) {
        JOptionPane.showMessageDialog(null, "Error: La sede ingresada no existe. Regístrela primero.");
        return;
    }

    String marca = JOptionPane.showInputDialog("Ingrese la marca:");
    String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
    int autonomia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la autonomía de vuelo (en minutos):"));
    String opcionBateria = JOptionPane.showInputDialog(null, "¿Cuenta con batería adicional? (si/no)");
    boolean bateria = opcionBateria.equalsIgnoreCase("si");

    boolean verificacion = theSede.registrarDron(codigo, marca, modelo, theSede, autonomia, bateria);
    if (verificacion) {
        JOptionPane.showMessageDialog(null, "Registro exitoso");
    } else {
        JOptionPane.showMessageDialog(null, "No se hizo el registro");
    }
}

public static void registrarCamara() {
    String codigo = JOptionPane.showInputDialog("Ingrese el código de la Cámara:");
    if (pixelRent.consultarDispositivoCodigo(codigo) != null) {
        JOptionPane.showMessageDialog(null, "Error: Ya existe un dispositivo con ese código en la empresa.");
        return;
    }

    String codigoSede = JOptionPane.showInputDialog("Ingrese el código de la Sede para la cámara:");
    Sede theSede = pixelRent.encontrarSede(codigoSede);
    if (theSede == null) {
        JOptionPane.showMessageDialog(null, "Error: La sede ingresada no existe. Regístrela primero.");
        return;
    }

    String marca = JOptionPane.showInputDialog("Ingrese la marca:");
    String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
    String resolucionMax = JOptionPane.showInputDialog("Ingrese la resolución máxima (Ej: 4K, 1080p):");
    String opcionEstabilizador = JOptionPane.showInputDialog(null, "¿Cuenta con estabilizador? (si/no)");
    boolean estabilizador = opcionEstabilizador.equalsIgnoreCase("si");

    boolean verificacion = theSede.registrarCamara(codigo, marca, modelo, theSede, resolucionMax, estabilizador);
    if (verificacion) {
        JOptionPane.showMessageDialog(null, "Registro exitoso");
    } else {
        JOptionPane.showMessageDialog(null, "No se hizo el registro");
    }
}

public static void registrarKit() {
    String codigo = JOptionPane.showInputDialog("Ingrese el código del Kit:");
    if (pixelRent.consultarDispositivoCodigo(codigo) != null) {
        JOptionPane.showMessageDialog(null, "Error: Ya existe un dispositivo con ese código en la empresa.");
        return;
    }

    String codigoSede = JOptionPane.showInputDialog("Ingrese el código de la Sede para el Kit:");
    Sede theSede = pixelRent.encontrarSede(codigoSede);
    if (theSede == null) {
        JOptionPane.showMessageDialog(null, "Error: La sede ingresada no existe. Regístrela primero.");
        return;
    }

    String marca = JOptionPane.showInputDialog("Ingrese la marca:");
    String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
    int luces = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de luces:"));
    String opcionControl = JOptionPane.showInputDialog(null, "¿Cuenta con control inalámbrico? (si/no)");
    boolean control = opcionControl.equalsIgnoreCase("si");

    boolean verificacion = theSede.registrarKit(codigo, marca, modelo, theSede, luces, control);
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

    public static void registrarSede() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código de la sede:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la sede:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección de la sede:");

        Sede nuevaSede = new Sede(codigo, nombre, direccion);

        boolean verificacion = pixelRent.registrarSede(nuevaSede);

        if (verificacion) {
            JOptionPane.showMessageDialog(null, "¡Sede registrada con éxito!");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la sede.");
        }
    }

    public static void registrarOperador() {
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del operador:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del operador:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del operador:");
        String certificacion = JOptionPane.showInputDialog("Ingrese la certificación del operador:");
        int aniosExp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los años de experiencia:"));

        Operador nuevoOperador = new Operador(identificacion, nombre, telefono, certificacion, aniosExp);

        boolean verificacion = pixelRent.registrarOperador(nuevoOperador);

        if (verificacion) {
            JOptionPane.showMessageDialog(null, "¡Operador registrado con éxito!");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el operador.");
        }
    }

    public static void registrarCliente() {
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del cliente:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del cliente:");
        String correo = JOptionPane.showInputDialog("Ingrese el correo del cliente:");

        boolean verificacion = pixelRent.registrarCliente(identificacion, nombre, telefono, correo);

        if (verificacion) {
            JOptionPane.showMessageDialog(null, "¡Cliente registrado con éxito!");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente.");
        }
    }

    //Metodos de consulta
    public static void consultarReservaId() {
        String dato = JOptionPane.showInputDialog("Ingrese el id del cliente para consultar las reservas confirmadas");
        LinkedList<Reserva> listaConsultada = pixelRent.consultarReservaIdCliente(dato);
        String mensaje = "Codigos de reservas confirmadas: \n";
        if (listaConsultada != null) {
            for (Reserva reserva : listaConsultada) {
                mensaje += reserva.getCodigo();
            }
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static void consultarReservaCodigo() {
        String dato = JOptionPane.showInputDialog("Ingrese el codigo de la reserva");
        Reserva reservaConsultada = pixelRent.consultarReservaCodigo(dato);

        if (reservaConsultada != null) {
            double costoTotal = reservaConsultada.calcularTotal();
            JOptionPane.showMessageDialog(null, "Reserva Encontrada" +
                    "\n Codigo: " + reservaConsultada.getCodigo() +
                    "\n Fecha: " + reservaConsultada.getFecha() +
                    "\n Turno: " + reservaConsultada.getTurno() +
                    "\n Estado: " + reservaConsultada.getEstadoReserva() +
                    "\n CostoTotal: " + costoTotal);
        }
    }

    public static void consultarDispositivosDisp() {
        String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha (Ej: 2026-10-14):");
        LocalDate fecha = LocalDate.parse(fechaStr);

        String turnoStr = JOptionPane.showInputDialog("Ingrese el turno (MAÑANA, TARDE, NOCHE):");
        Turno turno = Turno.valueOf(turnoStr.toUpperCase());

        LinkedList<Dispositivo> listaConsultada = pixelRent.consultarDispositivosDisp(fecha, turno);
        String mensajeFinal = "Los dispositivos encontrados Fueron: \n";

        if (listaConsultada != null) {
            String camaras = "Camaras: \n";
            String drones = "Drones: \n";
            String kits = "Kits: \n";
            for (Dispositivo dispositivo : listaConsultada) {
                if (dispositivo instanceof Camara) {
                    camaras += dispositivo.getCodigo() + "\n";
                } else if (dispositivo instanceof Dron) {
                    drones += dispositivo.getCodigo();
                } else {
                    kits += dispositivo.getCodigo();
                }
            }
            mensajeFinal += camaras + drones + kits;

            JOptionPane.showMessageDialog(null, mensajeFinal);
        }
    }

    //Metodos de cambios
    public static void actualizarEstadoReserva() {
        String codigoReserva = JOptionPane.showInputDialog("Ingrese el codigo de la reserva a actualizar el estado");
        Reserva reserva = pixelRent.consultarReservaCodigo(codigoReserva);
        String estadoStr = JOptionPane.showInputDialog("Ingrese el nuevo estado (PENDIENTE, ACTIVA, etc):");
        EstadoReserva nuevoEstado = EstadoReserva.valueOf(estadoStr.toUpperCase());

        boolean res = pixelRent.cambiarEstadoReserva(nuevoEstado, reserva);

        if (res) {
            JOptionPane.showMessageDialog(null, "¡Estado de reserva cambiado con exito!");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo cambiar el estado de la reserva.");
        }
    }

    public static void agregarDispositivoReserva() {
        String codigoReserva = JOptionPane.showInputDialog("Ingrese el codigo de la reserva a añadir el dispositivo");
        Reserva reserva = pixelRent.consultarReservaCodigo(codigoReserva);

        String codigoDispositivo = JOptionPane.showInputDialog("Ingrese el codigo del dispositivo a agregar");
        Dispositivo dispositivo = pixelRent.consultarDispositivoCodigo(codigoDispositivo);

        boolean res = reserva.agregarDispositivo(dispositivo);

        if (res) {
            JOptionPane.showMessageDialog(null, "¡Dispositivo agregado exitosamente!");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el dispositivo.");
        }
    }
}






