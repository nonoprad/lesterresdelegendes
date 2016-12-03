package fr.nonoprad.ltdl.odt;

import lombok.*;
import lombok.experimental.Builder;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@Getter @Setter
public class RaceOdt {

    private int race_id;

    private String nom;
}
