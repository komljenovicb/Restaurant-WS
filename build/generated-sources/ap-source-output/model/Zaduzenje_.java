package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Zaposleni;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T22:48:51")
@StaticMetamodel(Zaduzenje.class)
public class Zaduzenje_ { 

    public static volatile SingularAttribute<Zaduzenje, String> funkcija;
    public static volatile ListAttribute<Zaduzenje, Zaposleni> zaposleniList;
    public static volatile SingularAttribute<Zaduzenje, Integer> zaduzenjeID;

}