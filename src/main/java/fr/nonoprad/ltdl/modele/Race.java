package fr.nonoprad.ltdl.modele;

import lombok.*;
import lombok.experimental.Builder;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Integer race_id;

    @Getter @Setter
    private String nom;


}
