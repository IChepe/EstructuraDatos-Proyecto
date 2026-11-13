package javaapplication6;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Tiquete {

    private String nombre;
    private int id;
    private int edad;
    private String horaCreacion;
    private String horaAtencion;
    private String tramite;
    private String tipo;

    public Tiquete(String nombre, int id, int edad, String tramite, String tipo) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.tramite = tramite;
        this.tipo = tipo;
        //Hora de creacion: la obtiene del sistema con formato hora:minutos:segundos
        this.horaCreacion = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        //Hora de atencion: por defecto -1 hasta que sea atendido
        this.horaAtencion = "-1";
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

    public String getHoraCreacion() {
        return horaCreacion;
    }

    public String getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(String horaAtencion) {
        this.horaAtencion = horaAtencion;
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
                + ", horaCreacion=" + horaCreacion + ", horaAtencion=" + horaAtencion
                + ", tramite=" + tramite + ", tipo=" + tipo + '}';
    }

}
