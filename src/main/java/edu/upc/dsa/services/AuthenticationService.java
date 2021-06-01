package edu.upc.dsa.services;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Usuario;

import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Api(value = "/auth", description = "no")
@Path("/auth")

public class AuthenticationService {

    private final GameManagerImpl gm;

    public AuthenticationService() {
        this.gm = GameManagerImpl.getInstance();
        if (gm.usuariosSize() == 0) {
            gm.registrar("toni11", "hola", "toni11@hotmail.com");
            gm.registrar("juan6", "quetal", "juan6@gmail.com");
            gm.registrar("miguel18", "adios", "miguel18@outlook.es");
        }
    }


    @POST
    @ApiOperation(value = "añadimos usuario a la lista", notes = "No notes")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/registrarUsuario")///addUsuario/{username}/{contraseña}/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(Usuario usuario) {

        if (usuario.getUsername()==null || usuario.getEmail()==null || usuario.getPassword()==null)  return Response.status(500).entity(usuario).build();
        gm.registrar(usuario.getUsername(), usuario.getPassword(), usuario.getEmail());
        return Response.status(201).entity(usuario).build();

    }


    @POST // Comprobar autenticación
    @ApiOperation(value = "Autenticacion", notes = "Autenticacion")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Usuario.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/iniciarSesion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response iniciarSesion(Usuario user) {

        if (gm.logIn(user.getUsername(), user.getPassword())) return Response.status(201).build();

        else return Response.status(404).build();
    }

}
