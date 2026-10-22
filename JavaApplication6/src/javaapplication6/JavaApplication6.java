package javaapplication6;

import javax.swing.JOptionPane;

/**
 *
 * @author josed
 */
public class JavaApplication6 {

    public static void main(String[] args) {

        //Objetos y variable
        Cola c1 = new Cola(1, "P");
        Cola c2 = new Cola(2, "A");
        Cola c3 = new Cola(3, "B");
        Cola c4 = new Cola(4, "B");
        String res;

        //Menu del sistema
        do {

            res = JOptionPane.showInputDialog("^^^^^^^^ ATENCION DE CLIENTES ^^^^^^^^\n"
                    + "1)Crear tiquete \n2)Mostrar cajas \n0)Salir\n\nIngrese una opcion (0-2)");

            switch (res) {

                case "0":
                    JOptionPane.showMessageDialog(null, "Cerrando el sistema");
                    break;

                case "1":
                    Controladores.crearTiquete(c1, c2, c3, c4);
                    break;

                case "2":
                    Controladores.mostrarCajas(c1, c2, c3, c4);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Error: opcion no valida");
            }

        } while (!res.equals("0"));

    }

}
