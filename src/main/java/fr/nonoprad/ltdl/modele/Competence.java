package fr.nonoprad.ltdl.modele;


import lombok.*;
import lombok.experimental.Builder;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Competence {

    @Id
    @Getter @Setter
    private int competence_id;

    @Getter @Setter
    private String nom;

    @Getter @Setter
    private int valeur;

}
