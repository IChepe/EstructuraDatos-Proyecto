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

    //Login: dos usuarios, maximo 3 intentos
    public static boolean login() {

        int intentos = 0;

        while (intentos < 3) {

            String usuario = JOptionPane.showInputDialog("^^^^^^^^ LOGIN ^^^^^^^^\nIngrese el usuario");
            String clave = JOptionPane.showInputDialog("Ingrese la contraseña");

            if (usuario.equals("admin") && clave.equals("1234")) {
                return true;
            } else if (usuario.equals("cajero") && clave.equals("5678")) {
                return true;
            }

            intentos += 1;
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos\nIntentos restantes: " + (3 - intentos));
        }

        JOptionPane.showMessageDialog(null, "Demasiados intentos, cerrando el sistema");
        return false;
    }

    //Modulo 0: si ya existe prod.txt lo carga, si no pide la configuracion
    public static Configuracion iniciarConfiguracion() {

        Configuracion conf = new Configuracion();

        if (conf.existe()) {
            conf.cargar();
        } else {
            conf.configurar();
        }

        return conf;
    }

    //Crea una cola por cada caja segun la configuracion
    public static ColaCajas crearCajas(Configuracion conf) {

        ColaCajas cajas = new ColaCajas();
        int i = 1;

        while (i <= conf.getCantCajas()) {
            cajas.agregar(new Cola(i, conf.tipoCaja(i)));
            i += 1;
        }

        return cajas;
    }

    //Menu de Atencion de Clientes
    public static void menuAtencion(ColaCajas cajas) {

        String res;

        do {

            res = JOptionPane.showInputDialog("^^^^^^^^ ATENCION DE CLIENTES ^^^^^^^^\n"
                    + "1)Crear tiquete \n2)Mostrar cajas \n0)Volver\n\nIngrese una opcion (0-2)");

            switch (res) {

                case "0":
                    JOptionPane.showMessageDialog(null, "Regresando al menu principal");
                    break;

                case "1":
                    crearTiquete(cajas);
                    break;

                case "2":
                    JOptionPane.showMessageDialog(null, cajas);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Error: opcion no valida");
            }

        } while (!res.equals("0"));

    }

    //Modulo 1.1: Creacion de tiquetes
    public static void crearTiquete(ColaCajas cajas) {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente"));

        if (cajas.existeId(id)) {
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

            Cola c = cajas.buscarCola(tipo);
            c.agregar(new Tiquete(nombre, id, edad, tramite, tipo));
            c.mostrarTurno();
        }
    }

}
