package fr.nonoprad.ltdl.controller;



import fr.nonoprad.ltdl.modele.Personnage;
import fr.nonoprad.ltdl.odt.CompetenceOdt;
import fr.nonoprad.ltdl.odt.PersonnageOdt;
import fr.nonoprad.ltdl.odt.RaceOdt;
import fr.nonoprad.ltdl.service.PersonnageService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

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
    public PersonnageOdt get(@PathParam("id") Long id){
        Personnage personnage = personnageService.findById(id);


        return new PersonnageOdt().builder()
                .personnage_id(personnage.getPersonnage_id())
                .competences(personnage.getCompetences().stream().map(competence -> new CompetenceOdt().builder()
                        .competence_id(competence.getCompetence_id())
                        .nom(competence.getNom())
                        .build()
                ).collect(Collectors.toList()))
                .race(new RaceOdt().builder().race_id(personnage.getRace().getRace_id())
                        .nom(personnage.getRace().getNom())
                        .build())
                .dateCreate(personnage.getDateCreate())
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional(Transactional.TxType.REQUIRED)
    public void createEntreeEnRelation(final Personnage personnage) {
        personnageService.save(personnage);
    }
}
