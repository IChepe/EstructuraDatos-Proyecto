package javaapplication6;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

//Base de datos de reportes (se guarda en reportes.txt)
//Cada vez que un tiquete pasa a ser atendido se agrega una linea al final del archivo
public class Reportes {

    private static String archivo = "reportes.txt";

    //Guarda el tiquete atendido y la caja que lo atendio (true = agrega sin borrar lo anterior)
    public static void guardar(int numCaja, Tiquete t) {
        try {
            FileWriter fw = new FileWriter(archivo, true);
            fw.write("Caja " + numCaja + " | " + t.getId() + " | " + t.getNombre() + " | "
                    + t.getEdad() + " | " + t.getTipo() + " | " + t.getTramite() + " | "
                    + t.getHoraCreacion() + " | " + t.getHoraAtencion() + "\n");
            fw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar " + archivo);
        }
    }

}
