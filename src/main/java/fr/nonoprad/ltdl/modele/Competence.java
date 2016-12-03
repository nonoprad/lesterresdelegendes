package fr.nonoprad.ltdl.modele;


import lombok.*;
import lombok.experimental.Builder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="COMPETENCE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@NamedQueries({
        @NamedQuery(name="Competence.findAll", query = "SELECT r FROM Race r")
})
public class Competence {

    @Id
    @Getter @Setter
    private int competence_id;

    @Getter @Setter
    private String nom;

    @Getter @Setter
    private int valeur;

}
