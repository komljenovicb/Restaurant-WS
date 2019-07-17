/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Bojana Komljenovic
 */
public class ZaposleniDTO {

    @XmlElement
    private int zaposleniID;

    @XmlElement
    private String ime;

    @XmlElement
    private String prezime;

    @XmlElement
    private SluzbaZaInventarDTO sluzba;

    @XmlElement
    private ZaduzenjeDTO zaduzenje;

    public ZaposleniDTO() {
    }

    public int getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public ZaduzenjeDTO getZaduzenje() {
        return zaduzenje;
    }

    public SluzbaZaInventarDTO getSluzba() {
        return sluzba;
    }

    public void setSluzba(SluzbaZaInventarDTO sluzba) {
        this.sluzba = sluzba;
    }

    public void setZaduzenje(ZaduzenjeDTO zaduzenje) {
        this.zaduzenje = zaduzenje;
    }

}
