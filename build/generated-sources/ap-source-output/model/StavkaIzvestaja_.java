package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.IzvestajOBrojuDorucaka;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T22:48:51")
@StaticMetamodel(StavkaIzvestaja.class)
public class StavkaIzvestaja_ { 

    public static volatile SingularAttribute<StavkaIzvestaja, String> dan;
    public static volatile SingularAttribute<StavkaIzvestaja, Date> datum;
    public static volatile SingularAttribute<StavkaIzvestaja, Integer> rbrIzvestaja;
    public static volatile SingularAttribute<StavkaIzvestaja, Integer> rbrStavke;
    public static volatile SingularAttribute<StavkaIzvestaja, IzvestajOBrojuDorucaka> izvestajOBrojuDorucaka;
    public static volatile SingularAttribute<StavkaIzvestaja, Integer> brojDorucaka;

}