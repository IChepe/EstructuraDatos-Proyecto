package javaapplication6;

import javax.swing.JOptionPane;

public class Controladores {

    //Menu de tipo de tiquete
    public static String menuTipo() {

        String tipo = "";

        do {

            String res = JOptionPane.showInputDialog("^^^^^^^^ TIPO DE TIQUETE ^^^^^^^^\n"
                    + "1)P - Preferencial \n2)A - Un solo tramite \n3)B - Dos o mas tramites\n\nIngrese una opcion (1-3)");

            switch (res) {

                case "1":
                    tipo = "P";
                    break;

                case "2":
                    tipo = "A";
                    break;

                case "3":
                    tipo = "B";
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Error: opcion no valida");
            }

        } while (tipo.equals(""));

        return tipo;
    }

    //Menu de un solo tramite (tipo P y A)
    public static String menuTramite() {

        String tramite = "";

        do {

            String res = JOptionPane.showInputDialog("^^^^^^^^ TRAMITE ^^^^^^^^\n"
                    + "1)Depositos \n2)Retiros \n3)Cambio de Divisas\n\nIngrese una opcion (1-3)");

            switch (res) {

                case "1":
                    tramite = "Depositos";
                    break;

                case "2":
                    tramite = "Retiros";
                    break;

                case "3":
                    tramite = "Cambio de Divisas";
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Error: opcion no valida");
            }

        } while (tramite.equals(""));

        return tramite;
    }

    //Menu de dos o mas tramites (tipo B)
    public static String menuVariosTramites() {

        String tramite = "";

        do {

            String res = JOptionPane.showInputDialog("^^^^^^^^ TRAMITES ^^^^^^^^\n"
                    + "1)Depositos y Retiros \n2)Depositos y Cambio de Divisas \n3)Retiros y Cambio de Divisas"
                    + "\n4)Depositos, Retiros y Cambio de Divisas\n\nIngrese una opcion (1-4)");

            switch (res) {

                case "1":
                    tramite = "Depositos y Retiros";
                    break;

                case "2":
                    tramite = "Depositos y Cambio de Divisas";
                    break;

                case "3":
                    tramite = "Retiros y Cambio de Divisas";
                    break;

                case "4":
                    tramite = "Depositos, Retiros y Cambio de Divisas";
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Error: opcion no valida");
            }

        } while (tramite.equals(""));

        return tramite;
    }

    //Escoge la cola segun el tipo y el tamaño
    public static Cola escogerCola(String tipo, Cola c1, Cola c2, Cola c3, Cola c4) {

        if (tipo.equals("P")) {
            return c1;
        } else if (tipo.equals("A")) {
            return c2;
        } else if (c3.tamano() <= c4.tamano()) {
            return c3;
        } else {
            return c4;
        }
    }

    //Revisa si el ID ya existe en alguna caja
    public static boolean existeId(int id, Cola c1, Cola c2, Cola c3, Cola c4) {

        if (c1.existe(id)) {
            return true;
        } else if (c2.existe(id)) {
            return true;
        } else if (c3.existe(id)) {
            return true;
        } else if (c4.existe(id)) {
            return true;
        }
        return false;
    }

    //Modulo 1.1: Creacion de tiquetes
    public static void crearTiquete(Cola c1, Cola c2, Cola c3, Cola c4) {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente"));

        if (existeId(id, c1, c2, c3, c4)) {
            JOptionPane.showMessageDialog(null, "Error: ese ID ya tiene un tiquete");
        } else {

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del cliente"));
            String tipo = menuTipo();

            String tramite;
            if (tipo.equals("B")) {
                tramite = menuVariosTramites();
            } else {
                tramite = menuTramite();
            }

            Cola c = escogerCola(tipo, c1, c2, c3, c4);
            c.agregar(new Tiquete(nombre, id, edad, tramite, tipo));
            c.mostrarTurno();
        }
    }

    //Muestra todas las cajas
    public static void mostrarCajas(Cola c1, Cola c2, Cola c3, Cola c4) {
        JOptionPane.showMessageDialog(null, c1 + "\n" + c2 + "\n" + c3 + "\n" + c4);
    }

}
