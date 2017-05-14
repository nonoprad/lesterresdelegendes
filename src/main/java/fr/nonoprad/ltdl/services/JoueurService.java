package fr.nonoprad.ltdl.services;

import fr.nonoprad.ltdl.modele.Joueur;
import org.springframework.data.repository.CrudRepository;

public interface JoueurService extends CrudRepository<Joueur, Long>{
}
