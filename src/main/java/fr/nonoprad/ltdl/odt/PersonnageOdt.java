package fr.nonoprad.ltdl.odt;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Builder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class PersonnageOdt implements Serializable{
    private Long personnage_id;
    private RaceOdt race;
    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateCreate;
    private List<CompetenceOdt> competences;
}
