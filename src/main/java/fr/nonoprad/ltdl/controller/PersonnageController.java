package fr.nonoprad.ltdl.controller;



import fr.nonoprad.ltdl.modele.Personnage;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("personnages")
@RequestScoped
public class PersonnageController {

    @PersistenceContext(unitName = "LTDLPU")
    private EntityManager entityManager;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personnage> findAll(){
        return entityManager.createNamedQuery("Personnage.findAll", Personnage.class).getResultList();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Personnage get(@PathParam("id") Long id){
        return entityManager.find(Personnage.class, id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional(Transactional.TxType.REQUIRED)
    public void createEntreeEnRelation(final Personnage personnage) {
        entityManager.persist(personnage);
    }
}
