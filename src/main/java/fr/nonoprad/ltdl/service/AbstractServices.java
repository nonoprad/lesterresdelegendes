package fr.nonoprad.ltdl.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractServices<Entity,Id> {

    @PersistenceContext(unitName = "LTDL")
    protected EntityManager entityManager;

    public AbstractServices(EntityManager em){
        entityManager = em;
    }

    public abstract Entity save(final Entity entity);

    public abstract Entity findById(final Id id);

}
