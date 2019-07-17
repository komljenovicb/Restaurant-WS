package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.SluzbaZaInventar;
import model.Zaposleni;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T22:48:51")
@StaticMetamodel(SluzbaOdrzavanja.class)
public class SluzbaOdrzavanja_ { 

    public static volatile ListAttribute<SluzbaOdrzavanja, Zaposleni> zaposleniList;
    public static volatile SingularAttribute<SluzbaOdrzavanja, Integer> sluzbaID;
    public static volatile SingularAttribute<SluzbaOdrzavanja, Integer> brojZaposlenih;
    public static volatile SingularAttribute<SluzbaOdrzavanja, SluzbaZaInventar> sluzbaZaInventar;

}