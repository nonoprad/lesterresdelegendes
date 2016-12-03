package fr.nonoprad.ltdl.service;

import fr.nonoprad.ltdl.modele.Personnage;
import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class PersonnageService extends AbstractServices<Personnage, Long>{

    public PersonnageService(){
        super();
    }
    public PersonnageService(EntityManager em) {
        super(em);
    }

    public List<Personnage> findAll(){
        return entityManager.createNamedQuery("Personnage.findAll", Personnage.class).getResultList();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Personnage save(final Personnage personnage) {
        Personnage toReturn;
        if (personnage.getPersonnage_id() != null){
            entityManager.merge(personnage);
        }
        else {
            entityManager.persist(personnage);
        }
        toReturn = new Personnage().builder().personnage_id(personnage.getPersonnage_id())
                .dateCreate(personnage.getDateCreate())
                .race(personnage.getRace())
                .competences(personnage.getCompetences()).build();
        return toReturn;

    }

    @Override
    public Personnage findById(final Long aLong) {
        return entityManager.find(Personnage.class, aLong);
    }

}
