package javaapplication6;

public class Nodo {

    private Tiquete dato;
    // Atributo que permite que la estructura funcione como cola (enlace al siguiente)
    private Nodo siguiente;

    public Nodo(Tiquete dato) {
        this.dato = dato;
    }

    public Tiquete getDato() {
        return dato;
    }

    public void setDato(Tiquete dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + '}';
    }

}
