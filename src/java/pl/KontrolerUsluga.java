/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl;

import dbb.DBBroker;
import java.util.ArrayList;
import java.util.List;
import model.JedinicaMere;
import model.Usluga;


public class KontrolerUsluga {

    DBBroker dbb;
    Usluga u;
    boolean ret = false;

    public KontrolerUsluga() {
        dbb = new DBBroker();
        u = new Usluga();

    }

    public void setUslugaID(int uslugaID) {
        u.setUslugaID(uslugaID);
    }

    public void setNazivUsluge(String nazivUsluge) {
        u.setNazivUsluge(nazivUsluge);
    }

    public void setOpisUsluge(String opisUsluge) {
        u.setOpisUsluge(opisUsluge);
    }

    public void setJM(int jm) {
        JedinicaMere jedinicaMere = new JedinicaMere();
        jedinicaMere.setSifraJM(jm);
        u.setJedinicaMereID(jedinicaMere);
    }
    
    public int vratiIDUsluge() {
        
        int idUsluge = Integer.MIN_VALUE;

        try {
            dbb.otvoriKonekciju();
            idUsluge = dbb.vratiIDUsluge();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
            dbb.zatvoriKonekciju();
        }

        return idUsluge;
    }


    public List<JedinicaMere> vratiSveJM() {
        
        List<JedinicaMere> rsListaJM = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            rsListaJM = dbb.vratiSveJM();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rsListaJM;
    }

    public void sacuvajUslugu() {

        try {
            dbb.otvoriKonekciju();
            dbb.pokreniDBTransakciju();
            ret = dbb.sacuvajUslugu(u);
            if (ret == true) {
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

    public void izmeniUslugu() {
        
        try {
            dbb.otvoriKonekciju();
            dbb.pokreniDBTransakciju();
            ret = dbb.izmeniUslugu(u);
            if (ret == true) {
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

    public boolean obrisiUslugu(int uslugaID) {

        boolean uspesno = false;

        try {
            dbb.otvoriKonekciju();
            dbb.pokreniDBTransakciju();
            uspesno = dbb.obrisiUslugu(uslugaID);
            if (uspesno) {
                dbb.potvrdiDBTransakciju();
            } else {
                dbb.ponistiDBTransakciju();
            }
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
            dbb.zatvoriKonekciju();
        }

        return uspesno;
    }

    public Usluga vratiUslugu(String naziv) {
        
        u = null;
        
        try {
            dbb.otvoriKonekciju();
            u = dbb.vratiUslugu(naziv);
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }

    public List<Usluga> vratiSveUsluge() {

        List<Usluga> usluge = new ArrayList<>();

        try {
            dbb.otvoriKonekciju();
            usluge = dbb.vratiSveUsluge();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
            dbb.zatvoriKonekciju();
        }

        return usluge;

    }

    public JedinicaMere vratiJM(int id) {
        JedinicaMere jm = new JedinicaMere();
        try {
            dbb.otvoriKonekciju();
            jm = dbb.vratiJM(id);
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jm;
    }

}
