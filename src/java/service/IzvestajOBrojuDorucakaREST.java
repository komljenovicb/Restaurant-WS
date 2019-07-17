/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.IzvestajOBrojuDorucakaDTO;
import dto.RestoranDTO;
import dto.StavkaIzvestajaDTO;
import dto.ZaposleniDTO;
import static java.lang.Math.toIntExact;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.IzvestajOBrojuDorucaka;
import model.StavkaIzvestaja;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.KontrolerIzvestaja;

/**
 *
 * @author Bojana Komljenovic
 */
@Path("izvestaj")
public class IzvestajOBrojuDorucakaREST {

    KontrolerIzvestaja k;

    public IzvestajOBrojuDorucakaREST() {
        k = new KontrolerIzvestaja();
    }

    @POST
    @Path("/")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response sacuvajIzvestaj(String izv) {
        try {

            System.out.println("Cuvanje:: " + izv);

            JSONObject json = (JSONObject) new JSONParser().parse(izv);

            int rbrIzvestaja = Integer.parseInt((String) json.get("rbrIzvestaja"));

            System.out.println("Stigao rb : " + rbrIzvestaja);
            
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            Date datumOd = df.parse(((String) json.get("datumOd")).replaceAll("Z$", "+0000"));
            Date datumDo = df.parse(((String) json.get("datumDo")).replaceAll("Z$", "+0000"));

            int restoran = Integer.parseInt((String) json.get("restoran"));
            int zaposleni = Integer.parseInt((String) json.get("zaposleni"));
            int ukupanBrojDorucaka = Integer.parseInt((String) json.get("ukupanBrojDorucaka"));

            k.setRbrIzvestaja(rbrIzvestaja);
            k.postaviDatumOd(datumOd);
            k.postaviDatumDo(datumDo);
            k.postaviStatus((String) json.get("status"));
            k.postaviRestoran(restoran);
            k.postaviZaposlenog(zaposleni);
            k.postaviUkupanBrojDorucaka(ukupanBrojDorucaka);

            JSONArray stavke = (JSONArray) json.get("lista");
            ArrayList<StavkaIzvestaja> lista = new ArrayList<>();
            for (int i = 0; i < stavke.size(); i++) {
                JSONObject obj = (JSONObject) stavke.get(i);
                System.out.println("" + obj.get("rbrIzvestaja"));
                int rbrStavke = Integer.parseInt((String) obj.get("rbrStavke"));
                String dan = (String) obj.get("dan");
                Date datum = df.parse(((String) obj.get("datum")).replaceAll("Z$", "+0000"));
                String status = (String) obj.get("Status");
                int brojDorucaka = toIntExact((long) obj.get("brojDorucaka"));
                StavkaIzvestaja si = new StavkaIzvestaja();
                si.setRbrStavke(rbrStavke);
                si.setDan(dan);
                si.setDatum(datum);
                si.setStatus(status);
                si.setBrojDorucaka(brojDorucaka);
                lista.add(si);
            }
            /*
            JSONArray stavke = (JSONArray) json.get("lista");
            for (int i = 0; i < stavke.size(); i++) {
                JSONObject jsonobject = stavke.getJSONObject(i);
                String rbr = jsonobject.getString();
                String url = jsonobject.getString("url");

                ArrayList<StavkaIzvestaja> lista = new ArrayList<>();
                for (Object object : stavke) {
                    int rbr = Integer.parseInt((String) object("rbrStavke"));
                    String dan = (String) stavke.get("dan");
                    Date datum = df.parse(((String) stavke.get("datum")).replaceAll("Z$", "+0000"));
                    int brojDorucaka = Integer.parseInt((String) json.get("brojDorucaka"));
                }
                /*
                int rbr = Integer.parseInt((String) stavke.get("rbrStavke"));
                String dan = (String) stavke.get("dan");
                Date datum = df.parse(((String) stavke.get("datum")).replaceAll("Z$", "+0000"));
                int brojDorucaka = Integer.parseInt((String) json.get("brojDorucaka"));
             */
            k.setStavkeIzvestaja(lista);

            k.sacuvajIzvestaj();

            return Response.ok().build();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response pretrazi(String datumi) {
        try {

            System.out.println(" " + datumi);
            JSONObject json = (JSONObject) new JSONParser().parse(datumi);
            Date datumOd = (Date) json.get("datumOd");
            Date datumDo = (Date) json.get("datumOd");

            List<IzvestajOBrojuDorucaka> izvestaji = k.pretrazi(datumOd, datumDo);

            if (izvestaji != null) {
                List<IzvestajOBrojuDorucakaDTO> izvDTO = new ArrayList<>();
                for (IzvestajOBrojuDorucaka izv : izvestaji) {

                    IzvestajOBrojuDorucakaDTO izvestaj = new IzvestajOBrojuDorucakaDTO();
                    izvestaj.setRbrIzvestaja(izv.getRBRIzvestaja());
                    izvestaj.setDatumOd(izv.getDatumOd());
                    izvestaj.setDatumDo(izv.getDatumOd());

                    RestoranDTO res = new RestoranDTO();
                    res.setIdRestorana(izv.getIDRestorana().getIDRestorana());
                    res.setNazivRestorana(izv.getIDRestorana().getNazivRestorana());
                    izvestaj.setRestoran(res);

                    ZaposleniDTO zap = new ZaposleniDTO();
                    zap.setZaposleniID(izv.getZaposleniID().getZaposleniID());
                    zap.setIme(izv.getZaposleniID().getIme());
                    zap.setPrezime(izv.getZaposleniID().getPrezime());
                    izvestaj.setZaposleni(zap);

                    izvestaj.setStatus(izv.getStatus());
                    izvestaj.setUkupanBrojDorucaka(izv.getUkupanBrojDorucaka());

                    ArrayList<StavkaIzvestajaDTO> stavke = new ArrayList<>();
                    StavkaIzvestajaDTO si = new StavkaIzvestajaDTO();
                    for (StavkaIzvestaja stavkaIzvestaja : izv.getStavkaIzvestajaList()) {
                        si.setDatum(stavkaIzvestaja.getDatum());
                        si.setDan(stavkaIzvestaja.getDan());
                        stavke.add(si);
                    }

                    izvestaj.setStavkeIzvestaja(stavke);

                    izvDTO.add(izvestaj);
                }

                GenericEntity<List<IzvestajOBrojuDorucakaDTO>> ge
                        = new GenericEntity<List<IzvestajOBrojuDorucakaDTO>>(izvDTO) {
                };
                return Response.ok(ge).build();
            }
        } catch (Exception ex) {
            System.out.println("Greska::" + ex);
        }
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
    }

    /*
    @GET
    @Path("/")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response izmeniIzvestaj(String izv) {
        try {
            System.out.println("Izmena:: " + izv);

            JSONObject json = (JSONObject) new JSONParser().parse(izv);

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            Date datumOd = df.parse(((String) json.get("datumOd")).replaceAll("Z$", "+0000"));
            Date datumDo = df.parse(((String) json.get("datumDo")).replaceAll("Z$", "+0000"));

            int restoran = toIntExact((long) json.get("restoran"));
            int zaposleni = toIntExact((long) json.get("zaposleni"));
            int ukupanBrojDorucaka = toIntExact((long) json.get("ukupanBrojDorucaka"));

            k.postaviDatumOd(datumOd);
            k.postaviDatumDo(datumDo);
            k.postaviStatus((String) json.get("status"));
            k.postaviRestoran(restoran);
            k.postaviZaposlenog(zaposleni);
            k.postaviUkupanBrojDorucaka(ukupanBrojDorucaka);

            k.izmeniIzvestaj();
            return Response.ok().build();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/{id}")
    public Response obrisiIzvestaj(@PathParam("id") int rbrIzvestaja) {
        boolean uspesno = k.obrisi(rbrIzvestaja);
        if (uspesno) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
     */
}
