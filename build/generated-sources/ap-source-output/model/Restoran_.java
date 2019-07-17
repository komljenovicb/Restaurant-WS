package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.IzvestajOBrojuDorucaka;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T22:48:51")
@StaticMetamodel(Restoran.class)
public class Restoran_ { 

    public static volatile SingularAttribute<Restoran, Integer> iDRestorana;
    public static volatile SingularAttribute<Restoran, String> nazivRestorana;
    public static volatile ListAttribute<Restoran, IzvestajOBrojuDorucaka> izvestajOBrojuDorucakaList;

}