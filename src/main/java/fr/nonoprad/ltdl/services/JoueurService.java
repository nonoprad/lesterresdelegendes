package fr.nonoprad.ltdl.services;

import fr.nonoprad.ltdl.modele.Joueur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JoueurService extends CrudRepository<Joueur, Long>{

    List<Joueur> findByLoginAndMotDePasse(String login, String motDePasse);
}
