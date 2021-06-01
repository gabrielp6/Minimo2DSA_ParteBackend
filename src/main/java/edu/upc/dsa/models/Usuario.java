package edu.upc.dsa.models;

import java.util.List;

public class Usuario {

    String username;
    String password;
    String email;
    int idUsuario;
    int monedas;

    List<Objeto> listaObjetos;
    List<Partida> listaPartidas;
    List<Insignia> listaInsignias;

    public List<Insignia> getListaInsignias() {
        return listaInsignias;
    }

    public void setListaInsignias(List<Insignia> listaInsignias) {
        this.listaInsignias = listaInsignias;
    }

    public Usuario() {
    }


    public Usuario(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    public List<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(List<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }
}
