package fr.nonoprad.ltdl.controller;


import fr.nonoprad.ltdl.modele.Joueur;
import fr.nonoprad.ltdl.odt.Authentification;
import fr.nonoprad.ltdl.services.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("joueur")
public class JoueurController {

    @Autowired
    private JoueurService joueurService;

    @RequestMapping(value = "{authentification}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public Joueur authentificationJoueur(@RequestParam(name = "authentification") Authentification authentification){
        List<Joueur> byIdentifiantAndPassword = joueurService.findByLoginAndMotDePasse(authentification.getIdentifiant(), authentification.getMotDePasse());
        return byIdentifiantAndPassword.get(0);

    }


}
