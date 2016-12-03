package fr.nonoprad.ltdl.driverSeleniumTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JPAAbstractTest {

    private static EntityManagerFactory emf;
    protected static EntityManager em;

    @BeforeClass
    public static void beforeClass() {
        emf = Persistence.createEntityManagerFactory("LTDLPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }



    @AfterClass
    public static void afterClass(){
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        em.close();
    }



}
