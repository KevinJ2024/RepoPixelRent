package org.PixelRent;

import java.util.LinkedList;

public record Cliente(String identificacion, String nombre,
                      String telefono, String correo, LinkedList<Reserva> listReservas) {
}
