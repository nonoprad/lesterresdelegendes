package fr.nonoprad.ltdl.controller;

import fr.nonoprad.ltdl.modele.Race;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("races")
public class RaceController {

    @PersistenceContext
    private EntityManager entityManager;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Race> findall(){
        return entityManager.createNamedQuery("Race.findAll", Race.class).getResultList();
    }

    @GET
    @Path("{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Race get(@PathParam("id") Integer id){
        return entityManager.find(Race.class, id);
    }

}
