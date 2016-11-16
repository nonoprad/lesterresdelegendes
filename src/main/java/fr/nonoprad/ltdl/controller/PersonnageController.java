package fr.nonoprad.ltdl.controller;



import fr.nonoprad.ltdl.modele.Personnage;
import fr.nonoprad.ltdl.service.PersonnageService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("personnages")
@RequestScoped
public class PersonnageController {

    @EJB
    private PersonnageService personnageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(Transactional.TxType.REQUIRED)
    public List<Personnage> findAll(){
        return personnageService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Personnage get(@PathParam("id") Long id){
        return personnageService.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional(Transactional.TxType.REQUIRED)
    public void createEntreeEnRelation(final Personnage personnage) {
        personnageService.creerPersonnage(personnage);
    }
}
