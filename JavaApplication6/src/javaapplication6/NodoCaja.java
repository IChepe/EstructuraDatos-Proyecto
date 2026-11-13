package javaapplication6;

public class NodoCaja {

    private Cola dato;
    private NodoCaja siguiente;

    public NodoCaja(Cola dato) {
        this.dato = dato;
    }

    public Cola getDato() {
        return dato;
    }

    public void setDato(Cola dato) {
        this.dato = dato;
    }

    public NodoCaja getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCaja siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "NodoCaja{" + "dato=" + dato + '}';
    }

}
