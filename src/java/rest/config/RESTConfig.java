/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.config;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import service.IzvestajOBrojuDorucakaREST;
import service.JedinicaMereREST;
import service.RestoranREST;
import service.UslugaREST;
import service.ZaposleniREST;

/**
 *
 * @author Bojana Komljenovic
 */
@ApplicationPath("/")
public class RESTConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<>();
        s.add(UslugaREST.class);
        s.add(JedinicaMereREST.class);
        s.add(ZaposleniREST.class);
        s.add(RestoranREST.class);
        s.add(IzvestajOBrojuDorucakaREST.class);
        return s;
    }

}
