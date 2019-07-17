/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import model.IzvestajOBrojuDorucaka;

/**
 *
 * @author Bojana Komljenovic
 */
@XmlRootElement
public class StavkaIzvestajaDTO {

    @XmlElement
    private IzvestajOBrojuDorucaka izvestaj;

    @XmlElement
    private Date datum;

    @XmlElement
    private String dan;

    @XmlElement
    private int brojDorucaka;

    public StavkaIzvestajaDTO() {
    }

    public IzvestajOBrojuDorucaka getIzvestaj() {
        return izvestaj;
    }

    public void setIzvestaj(IzvestajOBrojuDorucaka izvestaj) {
        this.izvestaj = izvestaj;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getDan() {
        return dan;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }

    public int getBrojDorucaka() {
        return brojDorucaka;
    }

    public void setBrojDorucaka(int brojDorucaka) {
        this.brojDorucaka = brojDorucaka;
    }

}
