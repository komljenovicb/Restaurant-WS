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
public class SluzbaZaInventarDTO {

    @XmlElement
    private int sluzbaID;

    @XmlElement
    private String naziv;

    public SluzbaZaInventarDTO() {
    }

    public int getSluzbaID() {
        return sluzbaID;
    }

    public void setSluzbaID(int sluzbaID) {
        this.sluzbaID = sluzbaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
