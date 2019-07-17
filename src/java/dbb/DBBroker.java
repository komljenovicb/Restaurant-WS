/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.IzvestajOBrojuDorucaka;
import model.JedinicaMere;
import model.Restoran;
import model.StavkaIzvestaja;
import model.Usluga;
import model.Zaposleni;

/**
 *
 * @author Bojana Komljenovic
 */
public class DBBroker {

    EntityManagerFactory emf;
    EntityManager em;

    public DBBroker() {
        emf = Persistence.createEntityManagerFactory("FpisWSPU");
    }

    public void otvoriKonekciju() {
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
    }

    public void zatvoriKonekciju() {
        if (em.isOpen()) {
            em.close();
        }
    }

    public void pokreniDBTransakciju() {
        if (em.isOpen()) {
            em.getTransaction().begin();
        }
    }

    public void potvrdiDBTransakciju() {
        if (em.isOpen()) {
            em.getTransaction().commit();
        }
    }

    public void ponistiDBTransakciju() {
        if (em.isOpen()) {
            em.getTransaction().rollback();
        }
    }

    public int vratiIDUsluge() {
        int idUsluge = Integer.MIN_VALUE;
        if (em.isOpen()) {
            idUsluge = (int) em.createQuery("select max(u.uslugaID) + 1 "
                    + "from Usluga u").getSingleResult();
        }
        return idUsluge;
    }
    
    public boolean sacuvajUslugu(Usluga u) {
        try {
            if (em.isOpen()) {
                em.persist(u);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<JedinicaMere> vratiSveJM() {

        List<JedinicaMere> jediniceMere = new ArrayList<>();

        if (em.isOpen()) {
            jediniceMere = em.createNamedQuery("JedinicaMere.findAll").getResultList();
        }

        return jediniceMere;

    }

    public boolean obrisiUslugu(int uslugaID) {
        try {
            if (em.isOpen()) {
                Usluga u = em.find(Usluga.class, uslugaID);
                em.remove(u);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Usluga> vratiSveUsluge() {
        List<Usluga> rsUsluge = new ArrayList<>();

        if (em.isOpen()) {
            rsUsluge = em.createNamedQuery("Usluga.findAll").getResultList();
        }

        return rsUsluge;
    }

    public boolean izmeniUslugu(Usluga u) {
        try {
            if (em.isOpen()) {
                em.merge(u);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean sacuvajIzvestaj(IzvestajOBrojuDorucaka i) {
        try {
            if (i.getStatus().equals("insert")) {
                System.out.println("Cuvanje izvestaja...");

                System.out.println("rb: " + i.getRBRIzvestaja()
                        + "zap: " + i.getZaposleniID()
                        + "dat od: " + i.getDatumOd()
                        + "dat do: " + i.getDatumDo()
                        + "rest: " + i.getIDRestorana()
                        + "stat: " + i.getStatus() + ""
                        + i.getUkupanBrojDorucaka());

                List<StavkaIzvestaja> stavkeIzvestaja = i.getStavkaIzvestajaList();

                if (stavkeIzvestaja != null) {

                    for (int j = 0; j < i.getStavkaIzvestajaList().size(); j++) {
                        StavkaIzvestaja si = i.getStavkaIzvestajaList().get(j);
                        si.setRbrIzvestaja(i.getRBRIzvestaja());
                        sacuvajStavkeIzvestaja(si);
                    }
                }
                i.setStatus("Potpisan");
                em.persist(i);
            } else if (i.getStatus().equals("update")) {
                List<StavkaIzvestaja> stavkeIzvestaja = i.getStavkaIzvestajaList();
                if (stavkeIzvestaja != null) {

                    for (int j = 0; j < i.getStavkaIzvestajaList().size(); j++) {
                        System.out.println("\n" + i.getStavkaIzvestajaList().get(j).getStatus());
                    }

                    for (int j = 0; j < i.getStavkaIzvestajaList().size(); j++) {
                        sacuvajStavkeIzvestaja(i.getStavkaIzvestajaList().get(j));
                    }

                } else {
                    System.out.println("Nema stavki za izmenu...");
                }
                i.setStatus("Potpisan");
                em.merge(i);
            } else if (i.getStatus().equals("delete")) {
                i.setStatus("Obrisan");
                em.remove(i);
            }
            return true;
        } catch (Exception ex) {
            System.err.println("Izvestaj nije sacuvan: " + ex);
            return false;
        }
    }

    private boolean sacuvajStavkeIzvestaja(StavkaIzvestaja si) {
        try {
            if (si.getStatus().equals("insert")) {
                em.persist(si);
            } else if (si.getStatus().equals("update")) {
                em.merge(si);
            } else if (si.getStatus().equals("delete")) {
                em.remove(si);
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public List<IzvestajOBrojuDorucaka> pretrazi(Date datumOd, Date datumDo) {
        List<IzvestajOBrojuDorucaka> rsIzvestaji = new ArrayList<>();

        if (em.isOpen()) {

            String query = "SELECT i FROM IzvestajOBrojuDorucaka i "
                    + "WHERE (i.datumOd between ':datumOd' and ':datumDo') "
                    + "and (i.datumDo between ':datumOd' and ':datumDo')";

            query = query.replace(":datumOd",
                    new java.sql.Date(datumOd.getTime()) + "");
            query = query.replace(":datumDo",
                    new java.sql.Date(datumDo.getTime()) + "");

            System.out.println(query);

            rsIzvestaji = em.createQuery(query).getResultList();
        }

        return rsIzvestaji;
    }

    public List<Restoran> vratiRestorane() {
        List<Restoran> rsRestorani = new ArrayList<>();
        if (em.isOpen()) {
            rsRestorani
                    = em.createNamedQuery("Restoran.findAll").getResultList();
        }
        return rsRestorani;
    }

    public List<Zaposleni> vratiZaposlene() {
        List<Zaposleni> rsZaposleni = new ArrayList<>();
        if (em.isOpen()) {
            rsZaposleni
                    = em.createNamedQuery("Zaposleni.findAll").getResultList();
        }
        return rsZaposleni;
    }

    public Usluga vratiUslugu(String naziv) {
        Usluga u = new Usluga();
        try {
            if (em.isOpen()) {
                String query = "SELECT u FROM Usluga u "
                        + "WHERE u.nazivUsluge LIKE ':naziv'";

                query = query.replace(":naziv", naziv);
                        
                System.out.println(query);

                u = (Usluga) em.createQuery(query).getSingleResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }

    public Usluga pronadjiUslugu(int id) {
        try {
            if (em.isOpen()) {
                return em.find(Usluga.class, id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public JedinicaMere vratiJM(int id) {
        try {
            if (em.isOpen()) {
                return em.find(JedinicaMere.class, id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int vratiRBRIzvestaja() {
        return -1;
    }

}
