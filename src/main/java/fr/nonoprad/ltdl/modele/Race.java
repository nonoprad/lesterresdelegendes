package fr.nonoprad.ltdl.modele;

import lombok.*;
import lombok.experimental.Builder;

import javax.persistence.*;

@Entity
@Table(name="RACE")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NamedQueries({
    @NamedQuery(name="Race.findAll", query = "SELECT r FROM Race r")
})
public class Race {

    @Getter @Setter
    @Id
    private int race_id;

    @Getter @Setter
    private String nom;


}
