/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.SluzbaZaInventarDTO;
import dto.ZaduzenjeDTO;
import dto.ZaposleniDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Zaposleni;
import pl.KontrolerIzvestaja;

/**
 *
 * @author Bojana Komljenovic
 */
@Path("zaposleni")
public class ZaposleniREST {
    
    KontrolerIzvestaja k;

    public ZaposleniREST() {
        k = new KontrolerIzvestaja();
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiZaposlene() {
        List<Zaposleni> zaposleni = k.vratiZaposlene();
        if (zaposleni != null) {
            List<ZaposleniDTO> zapDTO = new ArrayList<>();
            for (Zaposleni z : zaposleni) {
                
                ZaposleniDTO zap = new ZaposleniDTO();
                zap.setZaposleniID(z.getZaposleniID());
                zap.setIme(z.getIme());
                zap.setPrezime(z.getPrezime());
                SluzbaZaInventarDTO sluzba = new SluzbaZaInventarDTO();
                sluzba.setSluzbaID(z.getSluzbaID().getSluzbaID());
                sluzba.setNaziv(z.getSluzbaID().getNaziv());
                zap.setSluzba(sluzba);
                ZaduzenjeDTO zad = new ZaduzenjeDTO();
                zad.setZaduzenjeID(zad.getZaduzenjeID());
                zad.setFunkcija(zad.getFunkcija());
                zap.setZaduzenje(zad);
                zapDTO.add(zap);
            }

            GenericEntity<List<ZaposleniDTO>> ge = new GenericEntity<List<ZaposleniDTO>>(zapDTO) {
            };
            return Response.ok(ge).build();
        }
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
    }
     
}
