package org.PixelRent;

import javax.swing.JOptionPane;

public class Main {
    static Empresa PixelRent = new Empresa("PixelRent", "16283", "calle 19 norte numero 21-34");

    public static void main(String[] args) {
        boolean bandera = true;
        do {
            int dato = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "MENU DE PixelRent" +
                    "\n1. " +
                    "\n2. " +
                    "\n3. " +
                    "\n0. salir del sistema"));

            switch (dato) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    bandera=false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opcion no valida");

            }
        } while (bandera);
    }


}
