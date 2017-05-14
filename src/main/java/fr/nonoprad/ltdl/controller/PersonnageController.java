package fr.nonoprad.ltdl.controller;



import fr.nonoprad.ltdl.modele.Personnage;
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
    public Personnage get(Long personnage_id){
        return personnageService.findOne(personnage_id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createPersonnage(Personnage personnage){
        personnageService.save(personnage);
    }
}