package fr.nonoprad.ltdl;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class LtdlApplication {


    public static void main(String[] args) {
        SpringApplication.run(LtdlApplication.class, args);
    }

}
