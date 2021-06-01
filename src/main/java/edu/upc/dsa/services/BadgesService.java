package edu.upc.dsa.services;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Insignia;
import edu.upc.dsa.models.Usuario;

import io.swagger.annotations.*;
import io.swagger.models.auth.In;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;


@Api(value = "/badges", description = "no")
@Path("/badges")

public class BadgesService {

    private final GameManagerImpl gm;

    public BadgesService() {
        this.gm = GameManagerImpl.getInstance();
        if (gm.usuariosSize() == 0) {
            gm.registrar("toni11", "hola", "toni11@hotmail.com");
            gm.registrar("juan6", "quetal", "juan6@gmail.com");
            gm.registrar("miguel18", "adios", "miguel18@outlook.es");
        }
    }


    @GET // Obtener lista de insignias
    @ApiOperation(value = "Lista de usuarios", notes = "Lista de usuarios ordenados alfabeticamente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Insignia.class ,responseContainer = "List"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("")
    public Response listaInsignias() {
        List<Insignia> listaInsignias = this.gm.getAllInsignias();
        GenericEntity<List<Insignia>> entity = new GenericEntity<List<Insignia>>(listaInsignias) {};
        return Response.status(201).entity(entity).build();
    }
}
