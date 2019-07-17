package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.IzvestajOBrojuDorucaka;
import model.SluzbaOdrzavanja;
import model.Zaduzenje;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T22:48:51")
@StaticMetamodel(Zaposleni.class)
public class Zaposleni_ { 

    public static volatile SingularAttribute<Zaposleni, String> ime;
    public static volatile SingularAttribute<Zaposleni, String> prezime;
    public static volatile SingularAttribute<Zaposleni, Integer> zaposleniID;
    public static volatile SingularAttribute<Zaposleni, Zaduzenje> zaduzenjeID;
    public static volatile SingularAttribute<Zaposleni, SluzbaOdrzavanja> sluzbaID;
    public static volatile ListAttribute<Zaposleni, IzvestajOBrojuDorucaka> izvestajOBrojuDorucakaList;

}