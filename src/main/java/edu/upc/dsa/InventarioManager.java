package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface InventarioManager {

    public boolean Comprar(Objeto o);
    public List<Objeto> mostrarObjetosUsuario(Usuario usuario);
    public List<Objeto> mostrarTodosObjetos();

}
