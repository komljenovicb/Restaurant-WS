/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.RestoranDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Restoran;
import pl.KontrolerIzvestaja;

/**
 *
 * @author Bojana Komljenovic
 */

@Path("restoran")
public class RestoranREST {
    
    
    KontrolerIzvestaja k;

    public RestoranREST() {
        k = new KontrolerIzvestaja();
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiZaposlene() {
        List<Restoran> restorani = k.vratiRestorane();
        if (restorani != null) {
            List<RestoranDTO> resDTO = new ArrayList<>();
            for (Restoran r : restorani) {
                
                RestoranDTO res = new RestoranDTO();
                res.setIdRestorana(r.getIDRestorana());
                res.setNazivRestorana(r.getNazivRestorana());

                resDTO.add(res);
            }

            GenericEntity<List<RestoranDTO>> ge 
                    = new GenericEntity<List<RestoranDTO>>(resDTO) {
            };
            return Response.ok(ge).build();
        }
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
    }

    
}
