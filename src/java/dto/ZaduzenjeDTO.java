/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bojana Komljenovic
 */

@XmlRootElement
public class ZaduzenjeDTO {

    @XmlElement
    private int zaduzenjeID;

    @XmlElement
    private String funkcija;

    public ZaduzenjeDTO() {
    }

    public int getZaduzenjeID() {
        return zaduzenjeID;
    }

    public void setZaduzenjeID(int zaduzenjeID) {
        this.zaduzenjeID = zaduzenjeID;
    }

    public String getFunkcija() {
        return funkcija;
    }

    public void setFunkcija(String funkcija) {
        this.funkcija = funkcija;
    }

}
