package fr.nonoprad.ltdl.modele;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "COMPETENCE")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private int competence_id;

    @Getter @Setter
    private String nom;

    @Getter @Setter
    private int valeur;

}
