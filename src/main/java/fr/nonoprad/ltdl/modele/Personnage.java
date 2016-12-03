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
@Table(name="PERSONNAGE")
@NamedQueries({
    @NamedQuery(name="Personnage.findAll", query = "SELECT per FROM Personnage per fetch all properties")
})
@Builder
@ToString
@EqualsAndHashCode
public class Personnage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long personnage_id;
    @Getter @Setter
    @ManyToOne
    private Race race;

    @Getter @Setter
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateCreate;

    @Getter @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Competence> competences;

    @Version
    private int version;
}
