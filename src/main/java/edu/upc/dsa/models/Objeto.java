package edu.upc.dsa.models;

public class Objeto {

    String nombre;
    int coste;
    String idObjeto;
    String idUsuario;



    public Objeto() {
    }

    public Objeto(String nombre, int coste) {
        this.nombre = nombre;
        this.coste = coste;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public String getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
