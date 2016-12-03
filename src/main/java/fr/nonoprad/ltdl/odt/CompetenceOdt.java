package fr.nonoprad.ltdl.odt;


import lombok.*;
import lombok.experimental.Builder;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter @Setter
@Builder
public class CompetenceOdt implements Serializable{

    @Getter @Setter
    private int competence_id;

    @Getter @Setter
    private String nom;

    @Getter @Setter
    private int valeur;


}
