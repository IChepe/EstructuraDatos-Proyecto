package javaapplication6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

//Modulo 0: Configuracion (se guarda en prod.txt)
public class Configuracion {

    private String archivo = "prod.txt";
    private String nombreBanco;
    private int cantCajas;

    public String getNombreBanco() {
        return nombreBanco;
    }

    public int getCantCajas() {
        return cantCajas;
    }

    //Revisa si el programa ya fue configurado antes
    public boolean existe() {
        File f = new File(archivo);
        return f.exists();
    }

    //Solo se ejecuta la primera vez: pide los datos y los guarda
    public void configurar() {
        nombreBanco = JOptionPane.showInputDialog("^^^^^^^^ CONFIGURACION ^^^^^^^^\nIngrese el nombre del banco");
        cantCajas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de cajas (minimo 3)"));
        while (cantCajas < 3) {
            cantCajas = Integer.parseInt(JOptionPane.showInputDialog("Error: deben ser minimo 3 cajas\nIngrese la cantidad de cajas"));
        }
        guardar();
    }

    //Escribe la configuracion en prod.txt
    public void guardar() {
        try {
            FileWriter fw = new FileWriter(archivo);
            fw.write(nombreBanco + "\n");
            fw.write(cantCajas + "\n");
            int i = 1;
            while (i <= cantCajas) {
                fw.write("Caja " + i + ": " + tipoCaja(i) + "\n");
                i += 1;
            }
            fw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar " + archivo);
        }
    }

    //Lee la configuracion de prod.txt (linea 1: banco, linea 2: cantidad de cajas)
    public void cargar() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            nombreBanco = br.readLine();
            cantCajas = Integer.parseInt(br.readLine());
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer " + archivo);
        }
    }

    //Caja 1 preferencial, caja 2 rapida, las demas normales
    public String tipoCaja(int numCaja) {
        if (numCaja == 1) {
            return "P";
        } else if (numCaja == 2) {
            return "A";
        } else {
            return "B";
        }
    }

    @Override
    public String toString() {
        String r = "Banco: " + nombreBanco + "\nCantidad de cajas: " + cantCajas + "\n";
        int i = 1;
        while (i <= cantCajas) {
            r += "Caja " + i + ": " + tipoCaja(i) + "\n";
            i += 1;
        }
        return r;
    }

}
