/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bojana Komljenovic
 */
@XmlRootElement
public class IzvestajOBrojuDorucakaDTO {

    @XmlElement
    private int rbrIzvestaja;

    @XmlElement
    private Date datumOd;

    @XmlElement
    private Date datumDo;

    @XmlElement
    private int ukupanBrojDorucaka;

    @XmlElement
    private String status;

    @XmlElement
    private ZaposleniDTO zaposleni;

    @XmlElement
    private RestoranDTO restoran;

    @XmlElement
    private ArrayList<StavkaIzvestajaDTO> stavkeIzvestaja;

    public IzvestajOBrojuDorucakaDTO() {
        stavkeIzvestaja = new ArrayList<>();
    }

    public int getRbrIzvestaja() {
        return rbrIzvestaja;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRbrIzvestaja(int rbrIzvestaja) {
        this.rbrIzvestaja = rbrIzvestaja;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public int getUkupanBrojDorucaka() {
        return ukupanBrojDorucaka;
    }

    public void setUkupanBrojDorucaka(int ukupanBrojDorucaka) {
        this.ukupanBrojDorucaka = ukupanBrojDorucaka;
    }

    public ZaposleniDTO getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(ZaposleniDTO zaposleni) {
        this.zaposleni = zaposleni;
    }

    public RestoranDTO getRestoran() {
        return restoran;
    }

    public void setRestoran(RestoranDTO restoran) {
        this.restoran = restoran;
    }

    public ArrayList<StavkaIzvestajaDTO> getStavkeIzvestaja() {
        return stavkeIzvestaja;
    }

    public void setStavkeIzvestaja(ArrayList<StavkaIzvestajaDTO> stavkeIzvestaja) {
        this.stavkeIzvestaja = stavkeIzvestaja;
    }

}
