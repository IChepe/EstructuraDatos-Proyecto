package javaapplication6;

import javax.swing.JOptionPane;

/**
 *
 * @author josed
 */
public class JavaApplication6 {

    public static void main(String[] args) {

        //Login antes de entrar al sistema
        if (Controladores.login()) {

            //Objetos y variable
            Configuracion conf = Controladores.iniciarConfiguracion();
            ColaCajas cajas = Controladores.crearCajas(conf);
            String res;

            //Menu del sistema
            do {

                res = JOptionPane.showInputDialog("^^^^^^^^ " + conf.getNombreBanco() + " ^^^^^^^^\n"
                        + "1)Ver configuracion \n2)Atencion de clientes \n0)Salir\n\nIngrese una opcion (0-2)");

                switch (res) {

                    case "0":
                        JOptionPane.showMessageDialog(null, "Cerrando el sistema");
                        break;

                    case "1":
                        JOptionPane.showMessageDialog(null, conf);
                        break;

                    case "2":
                        Controladores.menuAtencion(cajas);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Error: opcion no valida");
                }

            } while (!res.equals("0"));

        }

    }

}
