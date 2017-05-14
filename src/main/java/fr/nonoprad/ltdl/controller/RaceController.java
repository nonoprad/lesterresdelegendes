package fr.nonoprad.ltdl.controller;

import fr.nonoprad.ltdl.modele.Race;
import fr.nonoprad.ltdl.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.OperationNotSupportedException;

@RestController
@RequestMapping("races")
public class RaceController {

    @Autowired
    private RaceService raceService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Race> findall() throws OperationNotSupportedException {
        raceService.save(new Race(null,"Wizard"));


        return raceService.findAll();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Race get(@PathVariable("id") Integer id){
        return null;
    }

}
