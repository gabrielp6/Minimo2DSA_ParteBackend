package edu.upc.dsa.services;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Usuario;

import io.swagger.annotations.*;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;


@Api(value = "/user", description = "no")
@Path("/user")

public class UserService {

    private final GameManagerImpl gm;

    public UserService() {
        this.gm = GameManagerImpl.getInstance();
        if (gm.usuariosSize() == 0) {
            gm.registrar("toni11", "hola", "toni11@hotmail.com");
            gm.registrar("juan6", "quetal", "juan6@gmail.com");
            gm.registrar("miguel18", "adios", "miguel18@outlook.es");
        }
    }



    @GET // Obtener lista de usuarios registrados ordenados alfabeticamente
    @ApiOperation(value = "Lista de usuarios", notes = "Lista de usuarios ordenados alfabeticamente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Usuario.class ,responseContainer = "List"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/listaUsuarios")
    public Response orderLista() {
        List<Usuario> usersList = this.gm.getSortedUsersList();
        GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(usersList) {};
        return Response.status(201).entity(entity).build();
    }


    @DELETE //Borrar usuario
    @ApiOperation(value = "Borrar Usuario", notes = "No")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @Path("/borrarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrarUsuario(Usuario user) {

        int usuario = this.gm.borrarUsuario(user.getUsername());
        if(usuario == 0) return Response.status(404).build();
        return Response.status(201).build();
    }


    @GET //obtener un usuario
    @ApiOperation(value = "obtener usuario", notes = "No")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("username") String username) {
        Usuario u = this.gm.getUser(username);
        if (u == null) return Response.status(404).build();
        else  return Response.status(201).entity(u).build();
    }
}
