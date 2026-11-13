package javaapplication6;

//Cola que guarda las cajas del banco (cada caja es una Cola de tiquetes)
public class ColaCajas {

    private NodoCaja prim, ult;

    public boolean vacia() {
        return prim == null;
    }

    //Encolar una caja
    public void agregar(Cola c) {
        NodoCaja nuevo = new NodoCaja(c);
        if (vacia()) {
            prim = ult = nuevo;
        } else {
            ult.setSiguiente(nuevo);
            ult = nuevo;
        }
    }

    //Busca la caja del tipo indicado que tenga menos personas
    public Cola buscarCola(String tipo) {
        Cola menor = null;
        NodoCaja aux = prim;
        while (aux != null) {
            if (aux.getDato().getTipo().equals(tipo)) {
                if (menor == null) {
                    menor = aux.getDato();
                } else if (aux.getDato().tamano() < menor.tamano()) {
                    menor = aux.getDato();
                }
            }
            aux = aux.getSiguiente();
        }
        return menor;
    }

    //Revisa si el ID ya tiene tiquete en alguna caja
    public boolean existeId(int id) {
        NodoCaja aux = prim;
        while (aux != null) {
            if (aux.getDato().existe(id)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String toString() {
        String r = "";
        NodoCaja aux = prim;
        while (aux != null) {
            r += aux.getDato() + "\n";
            aux = aux.getSiguiente();
        }
        return r;
    }

}
