package edu.upc.dsa;

import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.GameManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;


public class GameManagerTest {

    private GameManager gm = null;

    @Before
    public void setUp(){
        this.gm = GameManagerImpl.getInstance();
        Usuario u1 = new Usuario("toni11","hola","toni11@hotmail.com");
        Usuario u2 = new Usuario("juan6","quetal","juan6@gmail.com");
        Usuario u3 = new Usuario("miguel18","adios","miguel18@outlook.es");

        gm.registrar("toni11", "hola","toni11@hotmail.com");
        gm.registrar("juan6", "quetal","juan6@gmail.com");
        gm.registrar("miguel18", "adios","miguel18@outlook.es");

    }

    @Test
    public void registrar() {
        Usuario u4 = new Usuario("carla21","bien","carla21@gmail.com");
        gm.registrar("carla21", "bien","carla21@gmail.com");
        assertEquals(4, gm.usuariosSize());
    }

    @Test
    public void logIn(){
        Boolean logIn1 = gm.logIn("toni11", "hola");
        Boolean logIn2 = gm.logIn("toni11", "quetal");
        assertEquals(true, logIn1);
        assertEquals(false,logIn2);
    }

    @Test
    public void getSortedUserList(){
        List<Usuario> listaUsuarios = gm.getSortedUsersList();
        assertEquals(3, listaUsuarios.size());
        assertEquals("toni11@hotmail.com", listaUsuarios.get(2).getEmail());
        assertEquals("juan6", listaUsuarios.get(0).getUsername());
    }

    @After
    public void tearDown(){
        GameManagerImpl.getInstance().delete();
    }
}
