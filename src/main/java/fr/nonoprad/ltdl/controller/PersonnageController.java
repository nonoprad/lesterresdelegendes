package fr.nonoprad.ltdl.controller;



import fr.nonoprad.ltdl.modele.Personnage;
import fr.nonoprad.ltdl.odt.PersonnageOdt;
import fr.nonoprad.ltdl.services.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("personnages")
public class PersonnageController {

    @Autowired
    private PersonnageService personnageService;

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public PersonnageOdt get(Long personnage_id){
        Personnage personnageModele = personnageService.findOne(personnage_id).orElse(Personnage.builder().build());
        return PersonnageOdt.builder().name(personnageModele.getName()).personnage_id(personnageModele.getPersonnage_id()).build();
    }
}