/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl;

import dbb.DBBroker;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.IzvestajOBrojuDorucaka;
import model.Restoran;
import model.StavkaIzvestaja;
import model.Zaposleni;

/**
 *
 * @author Bojana Komljenovic
 */
public class KontrolerIzvestaja {

    DBBroker dbb;
    boolean ret = false;
    IzvestajOBrojuDorucaka i;
    int rbrIzvestaja;
    List<IzvestajOBrojuDorucaka> izvestaji;
    List<StavkaIzvestaja> stavkeIzvestaja;

    public KontrolerIzvestaja() {
        dbb = new DBBroker();
        i = new IzvestajOBrojuDorucaka();
        stavkeIzvestaja = new ArrayList<>();
    }

    public List<StavkaIzvestaja> getStavkeIzvestaja() {
        return stavkeIzvestaja;
    }

    public void setStavkeIzvestaja(List<StavkaIzvestaja> stavkeIzvestaja) {
        this.stavkeIzvestaja = stavkeIzvestaja;
        this.i.setStavkaIzvestajaList(stavkeIzvestaja);
    }

    /*
    public List<IzvestajOBrojuDorucaka> vratiSveIzvestaje() {

        List<IzvestajOBrojuDorucaka> rsIzvestaj = new ArrayList<>();
        izvestaji = new ArrayList<>();

        try {
            dbb.otvoriKonekciju();
            dbb.pokreniDBTransakciju();
            rsIzvestaj = dbb.vratiSveIzvestaje();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
            dbb.zatvoriKonekciju();
        }

        return rsIzvestaj;
    }
     */
    public List<IzvestajOBrojuDorucaka> pretrazi(Date datumOd, Date datumDo) {
        List<IzvestajOBrojuDorucaka> rsIzvestaj = new ArrayList<>();
        izvestaji = new ArrayList<>();

        try {
            dbb.otvoriKonekciju();
            dbb.pokreniDBTransakciju();
            rsIzvestaj = dbb.pretrazi(datumOd, datumDo);
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
            dbb.zatvoriKonekciju();
        }

        return rsIzvestaj;
    }

    /*
    public boolean obrisi(int rbr) {

        ret = false;
        try {

            dbb.otvoriKonekciju();
            dbb.pokreniDBTransakciju();
            ret = dbb.obrisiIzvestaj(rbr);
            if (ret) {
                dbb.potvrdiDBTransakciju();
            } else {
                dbb.ponistiDBTransakciju();
            }
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
            dbb.zatvoriKonekciju();
        }

        return ret;
    }
     */
    
    public void sacuvajIzvestaj() {
        try {

            dbb.otvoriKonekciju();
            dbb.pokreniDBTransakciju();
            i.setRBRIzvestaja(rbrIzvestaja);
            ret = dbb.sacuvajIzvestaj(i);
            if (ret) {
                dbb.potvrdiDBTransakciju();
            } else {
                dbb.ponistiDBTransakciju();
            }
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
            dbb.zatvoriKonekciju();
        }
    }

    public void postaviRestoran(int restoranID) {
        i.setIDRestorana(new Restoran(restoranID));
    }

    public void postaviDatumOd(Date datumOd) {
        i.setDatumOd(datumOd);
    }

    public void postaviDatumDo(Date datumDo) {
        i.setDatumDo(datumDo);
    }

    public void postaviZaposlenog(int zaposleniID) {
        Zaposleni z = new Zaposleni();
        z.setZaposleniID(zaposleniID);
        i.setZaposleniID(z);
    }

    public void postaviStatus(String status) {
        i.setStatus(status);
    }

    public void postaviUkupanBrojDorucaka(int ukupanBrojDorucaka) {
        i.setUkupanBrojDorucaka(ukupanBrojDorucaka);
    }

    public void setRbrIzvestaja(int rbrIzvestaja) {
        this.rbrIzvestaja = rbrIzvestaja;
    }

    /*
    public List<Restoran> vratiRestorane() {
        List<Restoran> rsRestorani = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            rsRestorani = dbb.vratiRestorane();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
            dbb.zatvoriKonekciju();
        }

        return rsRestorani;
    }

    public List<Zaposleni> vratiZaposlene() {

        List<Zaposleni> rsZaposleni = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            rsZaposleni = dbb.vratiZaposlene();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
            dbb.zatvoriKonekciju();
        }

        return rsZaposleni;
    }

    public void izmeniIzvestaj() {
        try {

            dbb.otvoriKonekciju();
            dbb.pokreniDBTransakciju();
            ret = dbb.izmeniIzvestaj(i);
            if (ret) {
                dbb.potvrdiDBTransakciju();
            } else {
                dbb.ponistiDBTransakciju();
            }
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
            dbb.zatvoriKonekciju();
        }
    }
     */
    public int getRbrIzvestaja() {
        return rbrIzvestaja;
    }
}
