package javaapplication6;

public class Tiquete {

    private String nombre;
    private int id;
    private int edad;
    private String tramite;
    private String tipo;

    public Tiquete(String nombre, int id, int edad, String tramite, String tipo) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.tramite = tramite;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tiquete{" + "nombre=" + nombre + ", id=" + id + ", edad=" + edad
                + ", tramite=" + tramite + ", tipo=" + tipo + '}';
    }

}
