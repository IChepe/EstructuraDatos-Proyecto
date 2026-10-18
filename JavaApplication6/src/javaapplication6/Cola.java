package javaapplication6;

import javax.swing.JOptionPane;

public class Cola {

    private Nodo prim, ult;
    // Datos de la caja que atiende esta cola
    private int numCaja;
    private String tipo; // P: preferencial, A: un solo tramite, B: dos o mas tramites

    public Cola(int numCaja, String tipo) {
        this.numCaja = numCaja;
        this.tipo = tipo;
    }

    public int getNumCaja() {
        return numCaja;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean vacia() {
        return prim == null;
    }

    //Encolar
    public void agregar(Tiquete t) {
        Nodo nuevo = new Nodo(t);
        if (vacia()) {
            prim = ult = nuevo;
        } else {
            ult.setSiguiente(nuevo);
            ult = nuevo;
        }
    }

    //Tamaño de la cola: recorre y cuenta los nodos
    public int tamano() {
        int cont = 0;
        Nodo aux = prim;
        while (aux != null) {
            cont += 1;
            aux = aux.getSiguiente();
        }
        return cont;
    }

    //Turno: muestra la caja y cuantas personas tiene adelante el ultimo que entro
    public void mostrarTurno() {
        int adelante = tamano() - 1;
        String r = "Tiquete creado:\n" + ult.getDato() + "\n\n"
                + "Debe ser atendido en la caja " + numCaja + "\n";
        if (adelante == 0) {
            r += "No tiene a nadie adelante y la caja esta libre: ya es su turno de atencion";
        } else {
            r += "Personas por delante de usted: " + adelante;
        }
        JOptionPane.showMessageDialog(null, r);
    }

    //existe
    public boolean existe(int id) {
        Nodo aux = prim;
        while (aux != null) {
            if (aux.getDato().getId() == id) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String toString() {
        String r = "Caja " + numCaja + " (" + tipo + "): \n";
        Nodo aux = prim;
        while (aux != null) {
            r += aux + "\n";
            aux = aux.getSiguiente();
        }
        return r;
    }

}
