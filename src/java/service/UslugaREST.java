/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.JedinicaMereDTO;
import dto.UslugaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Usluga;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.KontrolerUsluga;
import static java.lang.Math.toIntExact;

/**
 *
 * @author Bojana Komljenovic
 */
@Path("usluga")
public class UslugaREST {

    KontrolerUsluga k;

    public UslugaREST() {
        k = new KontrolerUsluga();
    }

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public int vratiIDUsluge() {
        int id = k.vratiIDUsluge();
        return id;
    }
    
    @GET
    @Path("/{nazivUsluge}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiUslugu(@PathParam("nazivUsluge") String naziv) {

        System.out.println("Stiglo: " + naziv);

        Usluga u = k.vratiUslugu(naziv);

        if (u != null) {
            UslugaDTO usl = new UslugaDTO();
            usl.setUslugaID(u.getUslugaID());
            System.out.println("ID usluge : " + usl.getUslugaID());
            usl.setNazivUsluge(u.getNazivUsluge());
            usl.setOpisUsluge(u.getOpisUsluge());

            JedinicaMereDTO jm = new JedinicaMereDTO();
            jm.setSifraJM(u.getJedinicaMereID().getSifraJM());
            jm.setNazivJM(u.getJedinicaMereID().getNazivJM());
            usl.setJedinicaMere(jm);

            return Response.ok(usl).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Path("/")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response sacuvajUslugu(String usl) {
        try {

            JSONObject json = (JSONObject) new JSONParser().parse(usl);
            String nazivUsluge = (String) json.get("nazivUsluge");
            String opisUsluge = (String) json.get("opisUsluge");
            int jm = toIntExact((long) json.get("jedinicaMere"));

            k.setJM(jm);
            k.setNazivUsluge(nazivUsluge);
            k.setOpisUsluge(opisUsluge);

            k.sacuvajUslugu();
            return Response.ok().build();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("/{uslugaID}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response izmeniUslugu(@PathParam("uslugaID") int id, String usl) {
        try {

            System.out.println("ID: " + id);
            System.out.println("Izmena:: " + usl);

            JSONObject json = (JSONObject) new JSONParser().parse(usl);

            String nazivUsluge = (String) json.get("nazivUsluge");
            String opisUsluge = (String) json.get("opisUsluge");
            int jm = toIntExact((long) json.get("jedinicaMere"));

            k.setUslugaID(id);
            k.setJM(jm);
            k.setNazivUsluge(nazivUsluge);
            k.setOpisUsluge(opisUsluge);

            k.izmeniUslugu();

            return Response.ok().build();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/{id}")
    public Response obrisiUslugu(@PathParam("id") int uslugaID) {

        boolean uspesno = k.obrisiUslugu(uslugaID);

        if (uspesno) {
            return Response.ok().build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
