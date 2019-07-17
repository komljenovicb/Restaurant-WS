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
public class SluzbaOdrzavanjaDTO {

    @XmlElement
    private int sluzbaID;

    @XmlElement
    private int brojZaposlenih;

    public SluzbaOdrzavanjaDTO() {
    }

    public int getSluzbaID() {
        return sluzbaID;
    }

    public void setSluzbaID(int sluzbaID) {
        this.sluzbaID = sluzbaID;
    }

    public int getBrojZaposlenih() {
        return brojZaposlenih;
    }

    public void setBrojZaposlenih(int brojZaposlenih) {
        this.brojZaposlenih = brojZaposlenih;
    }

}
