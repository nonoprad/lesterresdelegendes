package fr.nonoprad.ltdl.services;

import fr.nonoprad.ltdl.modele.Race;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceService extends CrudRepository<Race, Integer> {
}
