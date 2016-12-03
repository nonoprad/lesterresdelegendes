package fr.nonoprad.ltdl.driverSeleniumTest;

import fr.nonoprad.ltdl.modele.Competence;
import fr.nonoprad.ltdl.modele.Personnage;
import fr.nonoprad.ltdl.modele.Race;
import fr.nonoprad.ltdl.service.PersonnageService;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PersonnageServiceTest extends JPAAbstractTest {


    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Test
    public void itShouldReturnAPersonnageFromService() throws ParseException {
        Personnage personnage = new PersonnageService(em).findById(1L);
        assertEquals(new Personnage().builder()
                .personnage_id(1L)
                .dateCreate(simpleDateFormat.parse("2016-12-03 15:30:15.738"))
                .race(new Race().builder().race_id(4).nom("Paladin").build())
                .competences(Arrays.asList(new Competence().builder()
                        .competence_id(1)
                        .nom("Coup d épée")
                        .valeur(1).build()))
                .version(0)
                .build(), personnage);
    }

}
