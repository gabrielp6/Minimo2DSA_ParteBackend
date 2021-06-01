package edu.upc.dsa;

import edu.upc.dsa.models.Insignia;
import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface GameManager {

    public void registrar(String username, String contraseña, String email);

    public boolean logIn (String username, String password);

    public Usuario getUser(String username);

    List<Usuario> getSortedUsersList();

    public int borrarUsuario(String username);

    List<Insignia> getAllInsignias();

    //Funciones para testear:
    public int usuariosSize();

}
