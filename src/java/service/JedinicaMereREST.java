/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.JedinicaMereDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.JedinicaMere;
import pl.KontrolerUsluga;


/**
 *
 * @author Bojana Komljenovic
 */
@Path("jedinicamere")
public class JedinicaMereREST {


    KontrolerUsluga k;

    public JedinicaMereREST() {
        k = new KontrolerUsluga();
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiSveJM() {
        List<JedinicaMere> jediniceMere = k.vratiSveJM();
        if (jediniceMere != null) {
            List<JedinicaMereDTO> jmDTO = new ArrayList<>();

            for (JedinicaMere jedinicaMere : jediniceMere) {
                JedinicaMereDTO jm = new JedinicaMereDTO();
                jm.setSifraJM(jedinicaMere.getSifraJM());
                jm.setNazivJM(jedinicaMere.getNazivJM());
                jmDTO.add(jm);
            }

            GenericEntity<List<JedinicaMereDTO>> ge = new GenericEntity<List<JedinicaMereDTO>>(jmDTO) {
            };
            return Response.ok(ge).build();
        }
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiJM(@PathParam("id") int id) {
        JedinicaMere jm = k.vratiJM(id);
        if (jm != null) {
            JedinicaMereDTO jmDTO = new JedinicaMereDTO();
            jmDTO.setSifraJM(jm.getSifraJM());
            jmDTO.setNazivJM(jm.getNazivJM());

            return Response.ok(jmDTO).build();

        }
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
    }




}
