package fr.nonoprad.ltdl;

import fr.nonoprad.ltdl.controller.PersonnageController;
import fr.nonoprad.ltdl.controller.RaceController;
import fr.nonoprad.ltdl.modele.Competence;
import fr.nonoprad.ltdl.modele.Personnage;
import fr.nonoprad.ltdl.modele.Race;
import fr.nonoprad.ltdl.odt.CompetenceOdt;
import fr.nonoprad.ltdl.odt.PersonnageOdt;
import fr.nonoprad.ltdl.odt.RaceOdt;
import fr.nonoprad.ltdl.service.AbstractServices;
import fr.nonoprad.ltdl.service.PersonnageService;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.jpa.JPAFraction;
import org.wildfly.swarm.undertow.WARArchive;

public class Main {



    public static void main(String[] args) throws Exception {
        System.out.println("Running " + Main.class.getCanonicalName() + ".main");

        Swarm swarm = new Swarm();

        JavaArchive driverArchiveToDeploy;

        String environnement = System.getProperty("env.name","DB");

        if (environnement.equals("DB")) {


            swarm.fraction(buildDataSourceH2());
            swarm.fraction(new JPAFraction().defaultDatasource("ExampleDS"));
            driverArchiveToDeploy = swarm.artifact("com.h2database:h2", "h2");

            swarm.start();
            swarm.deploy(driverArchiveToDeploy);
        }
        else {
            swarm.fraction(buildDataSourcePostgreSQL());
            swarm.fraction(new JPAFraction().defaultDatasource(("PostgreSQLDS")));
            driverArchiveToDeploy = Swarm.artifact("org.postgresql:postgresql", "postgresql");

            swarm.start();
            swarm.deploy(driverArchiveToDeploy);
        }

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
        deployment.addAllDependencies(true);
        deployment.addClasses(
                PersonnageController.class, RaceController.class,
                RaceOdt.class, PersonnageOdt.class, CompetenceOdt.class,
                Race.class, Personnage.class, Competence.class,
                LtdlApplication.class,
                PersonnageService.class, AbstractServices.class
        );
        deployment.addAsWebInfResource(new ClassLoaderAsset("META-INF/persistence.xml", Main.class.getClassLoader()), "classes/META-INF/persistence.xml");
        deployment.addAsWebInfResource(new ClassLoaderAsset("META-INF/values.sql", Main.class.getClassLoader()), "classes/META-INF/values.sql");
        deployment.addAsWebInfResource(new ClassLoaderAsset("log4j.xml", Main.class.getClassLoader()), "classes/log4j.xml");
        deployment.addResource(PersonnageController.class);
        deployment.addResource(RaceController.class);


        deployment.staticContent("statics/");

        // Start the swarm and deploy the default war
        swarm.deploy(deployment);

    }


    private static DatasourcesFraction buildDataSourcePostgreSQL() {
        return new DatasourcesFraction()
                .jdbcDriver("org.postgresql", (d) -> {
                    d.driverClassName("org.postgresql.Driver");
                    d.xaDatasourceClass("org.postgresql.xa.PGXADataSource");
                    d.driverModuleName("org.postgresql");
                })
                .dataSource("PostgreSQLDS", (ds) -> {
                    ds.driverName("org.postgresql");
                    ds.connectionUrl("jdbc:postgresql://localhost:5555/postgres");
                    ds.userName("postgres");
                    ds.password("postgres");
                });
    }
    private static DatasourcesFraction buildDataSourceH2() {
        return new DatasourcesFraction()
                .dataSource("MyDS", (ds) -> {
                    ds.driverName("h2");
                    ds.connectionUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
                    ds.userName("sa");
                    ds.password("sa");
                });
    }

}
