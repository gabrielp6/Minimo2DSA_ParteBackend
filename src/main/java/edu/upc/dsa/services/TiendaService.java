package edu.upc.dsa.services;
import edu.upc.dsa.GameManagerImpl;

import edu.upc.dsa.InventarioManagerImpl;
import edu.upc.dsa.models.Objeto;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Api(value = "/tienda", description = "Servicios de la tienda")
@Path("/tienda")
public class TiendaService {

    private GameManagerImpl gm;
    private InventarioManagerImpl im;


    public TiendaService() {
        this.gm = GameManagerImpl.getInstance();
    }



    @GET //Ver catalogo del juego
    @ApiOperation(value = "catalogo", notes = "Devuelve todos los objetos del juego")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer="List"),
    })
    @Path("/catalogo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllObjetos() {

        List<Objeto> objetos = this.im.mostrarTodosObjetos();

        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetos) {};
        return Response.status(201).entity(entity).build();

    }



    @GET //Obtener inventario de un usuario
    @ApiOperation(value = "Obtener inventario con su nombre", notes = "No")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",  response= Objeto.class ,responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/getInventario/{nombre}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getInventario(@PathParam("nombre") String nombre){

        List<Objeto> objetos=this.im.mostrarObjetosUsuario(gm.getUser(nombre));
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetos) {};

        if(objetos==null) return Response.status(404).build();
        else return Response.status(201).entity(entity).build();
    }




    @POST //Comprar objeto
    @ApiOperation(value = "comprar objeto", notes = "No")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class),
            @ApiResponse(code = 402, message = "Error dinero"),
    })
    @Path("/comprarObjeto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response comprarObjeto(Objeto o) {

        if(this.im.Comprar(o) == true){
            return Response.status(201).entity(o).build();
        }
        else return Response.status(402).build();

    }

}
