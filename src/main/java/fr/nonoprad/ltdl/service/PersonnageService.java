package fr.nonoprad.ltdl.service;

import fr.nonoprad.ltdl.modele.Personnage;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import java.util.List;

@Stateful
public class PersonnageService {

    @PersistenceContext(unitName = "LTDLPU", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public List<Personnage> findAll(){
        return entityManager.createNamedQuery("Personnage.findAll", Personnage.class).getResultList();
    }

    public Personnage get(Long id){
        return entityManager.find(Personnage.class, id);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void creerPersonnage(final Personnage personnage) {
        entityManager.persist(personnage);
    }
}
