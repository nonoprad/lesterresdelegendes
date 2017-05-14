package fr.nonoprad.ltdl.modele;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Personnage implements Serializable {

    @Id
    @Getter @Setter
    private Long personnage_id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    @OneToOne(targetEntity = Race.class)
    private Race race;

    @Getter @Setter
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateCreate;

    @Getter @Setter
    @ManyToOne(targetEntity = Competence.class)
    private List<Competence> competences;

    private int version;
}
