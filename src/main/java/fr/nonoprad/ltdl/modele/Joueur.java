package fr.nonoprad.ltdl.modele;


import lombok.*;
import lombok.experimental.Builder;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Joueur {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idJoueur;

    private String login;

    private Integer age;

    private String nom;

    private String prenom;

    private String email;

    private String motDePasse;

    @ManyToOne(targetEntity = Personnage.class)
    private Set<Personnage> personnages;


}
