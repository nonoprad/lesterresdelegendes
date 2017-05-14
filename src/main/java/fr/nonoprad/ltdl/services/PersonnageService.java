package fr.nonoprad.ltdl.services;

import fr.nonoprad.ltdl.modele.Personnage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnageService extends CrudRepository<Personnage, Long> {

    Page<Personnage> findAll(Pageable pageable);

    Personnage findByName(String name);

}
