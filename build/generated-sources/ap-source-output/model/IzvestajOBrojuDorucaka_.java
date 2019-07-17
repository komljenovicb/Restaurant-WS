package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Restoran;
import model.StavkaIzvestaja;
import model.Zaposleni;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T22:48:51")
@StaticMetamodel(IzvestajOBrojuDorucaka.class)
public class IzvestajOBrojuDorucaka_ { 

    public static volatile SingularAttribute<IzvestajOBrojuDorucaka, Zaposleni> zaposleniID;
    public static volatile SingularAttribute<IzvestajOBrojuDorucaka, Integer> ukupanBrojDorucaka;
    public static volatile SingularAttribute<IzvestajOBrojuDorucaka, Restoran> iDRestorana;
    public static volatile SingularAttribute<IzvestajOBrojuDorucaka, Date> datumDo;
    public static volatile SingularAttribute<IzvestajOBrojuDorucaka, Date> datumOd;
    public static volatile SingularAttribute<IzvestajOBrojuDorucaka, Integer> rBRIzvestaja;
    public static volatile ListAttribute<IzvestajOBrojuDorucaka, StavkaIzvestaja> stavkaIzvestajaList;
    public static volatile SingularAttribute<IzvestajOBrojuDorucaka, String> status;

}