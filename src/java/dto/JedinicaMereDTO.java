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
 *
 *
 */
@XmlRootElement
public class JedinicaMereDTO {

    @XmlElement
    private int sifraJM;
    @XmlElement
    private String nazivJM;

    public JedinicaMereDTO() {
    }

    public int getSifraJM() {
        return sifraJM;
    }

    public void setSifraJM(int sifraJM) {
        this.sifraJM = sifraJM;
    }

    public String getNazivJM() {
        return nazivJM;
    }

    public void setNazivJM(String nazivJM) {
        this.nazivJM = nazivJM;
    }

}
