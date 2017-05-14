package fr.nonoprad.ltdl.odt;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Builder;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Authentification {

    private String identifiant;
    private String motDePasse;


}
