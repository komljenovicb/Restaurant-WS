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
public class UslugaDTO {

    @XmlElement
    private int uslugaID;

    @XmlElement
    private String nazivUsluge;

    @XmlElement
    private String opisUsluge;

    @XmlElement
    private JedinicaMereDTO jedinicaMere;

    public UslugaDTO() {
    }

    public int getUslugaID() {
        return uslugaID;
    }

    public void setUslugaID(int uslugaID) {
        this.uslugaID = uslugaID;
    }

    public String getNazivUsluge() {
        return nazivUsluge;
    }

    public void setNazivUsluge(String nazivUsluge) {
        this.nazivUsluge = nazivUsluge;
    }

    public String getOpisUsluge() {
        return opisUsluge;
    }

    public void setOpisUsluge(String opisUsluge) {
        this.opisUsluge = opisUsluge;
    }

    public JedinicaMereDTO getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(JedinicaMereDTO jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

}
