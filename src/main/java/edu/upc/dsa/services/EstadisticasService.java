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


@Api(value = "/estadisticas", description = "no")
@Path("/estadisticas")

public class EstadisticasService {

    private final GameManagerImpl gm;

    public EstadisticasService() {
        this.gm = GameManagerImpl.getInstance();
        if (gm.usuariosSize() == 0) {
            gm.registrar("toni11", "hola", "toni11@hotmail.com");
            gm.registrar("juan6", "quetal", "juan6@gmail.com");
            gm.registrar("miguel18", "adios", "miguel18@outlook.es");
        }
    }


    @GET //Pasa el ranking de partidas
    @ApiOperation(value = "Ranking", notes = "No")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer="List"),
    })
    @Path("/getRanking")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRanking() {

        //List<Usuario> ranking = this.gm.getRankingUsuarios();

        //GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(ranking) {};
        //return Response.status(201).entity(entity).build();
        return null;
    }


}