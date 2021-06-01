package edu.upc.dsa;

import edu.upc.dsa.models.Insignia;
import edu.upc.dsa.models.Usuario;

import java.util.*;
import java.util.logging.Logger;


public class GameManagerImpl implements GameManager {

    public HashMap<String, Usuario> listaUsuariosHM;
    public List<Usuario> listaUsuarios;
    public List<Insignia> listaInsignias;

    private static GameManagerImpl implementation;
    static final Logger logger = Logger.getLogger(GameManagerImpl.class.getName());

    public static GameManagerImpl getInstance() {
        if (implementation == null) {
            implementation = new GameManagerImpl();
        }

        return implementation;
    }

    public static void delete() {
        implementation = null;
        logger.info("Instancia game manager borrada");

    }

    public GameManagerImpl() {
        this.listaUsuariosHM = new HashMap<>();
        this.listaUsuarios = new LinkedList<>();
        this.listaInsignias = new LinkedList<>();
    }

    @Override
    public void registrar(String username, String contraseña, String email) {
        Usuario usuario = new Usuario(username, contraseña, email);

        listaUsuariosHM.put(username, usuario);

        int idAsignado = listaUsuariosHM.size();
        usuario.setIdUsuario(idAsignado);

        logger.info("Usuario añadido:" + username);
    }

    @Override
    public boolean logIn(String username, String password) {
        Usuario user = listaUsuariosHM.get(username);
        try {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        } catch (NullPointerException nullPointerException) {
            return false;
        }
        return false;
    }

    @Override
    public int usuariosSize() {
        return listaUsuariosHM.size();
    }

    @Override
    public Usuario getUser(String username) {
        for (Usuario usuario : this.listaUsuarios) {
            String nombre = usuario.getUsername();
            if (username.equals(nombre)) {
                logger.info("Usuario " + username + " encontrado");
                return usuario;
            }
        }
        logger.info("Usuario " + username + " no existe");
        return null;
    }

    @Override
    public List<Usuario> getSortedUsersList() {
        List<Usuario> _userList = new ArrayList<>(this.listaUsuariosHM.values());
        if (!listaUsuariosHM.isEmpty()) {
            Collections.sort(_userList, new Comparator<Usuario>() {
                @Override
                public int compare(Usuario o1, Usuario o2) {
                    return o1.getUsername().compareTo(o2.getUsername());
                }
            });
        }
        return _userList;
    }

    @Override
    public int borrarUsuario(String username) {
        int encontrado = 0;

        for (Usuario usuario : this.listaUsuarios) {
            if (usuario.getUsername().equals(username))
                encontrado = 1;
        }
        
        return encontrado;
    }

    @Override
    public List<Insignia> getAllInsignias() {
        return listaInsignias;
    }

}
