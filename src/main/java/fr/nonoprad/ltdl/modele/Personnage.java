package fr.nonoprad.ltdl.modele;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PERSONNAGE")
@NamedQueries({
    @NamedQuery(name="Personnage.findAll", query = "SELECT per FROM Personnage per")
})
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
    @ManyToMany(mappedBy = "personnages",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Competence> competence;

    @Version
    private int version;
}
