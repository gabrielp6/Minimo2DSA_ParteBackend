package edu.upc.dsa.models;

public class Enemigo {

    public String nombre;
    public int vida;
    public int daño;

    public Enemigo() {
    }

    public Enemigo(String nombre, int vida, int daño) {
        this.nombre = nombre;
        this.vida = vida;
        this.daño = daño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }
}
