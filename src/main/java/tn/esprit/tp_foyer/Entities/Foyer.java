package tn.esprit.tp_foyer.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;

    @ManyToOne
    @JoinColumn(name = "idUniversite")
    private Universite universite;

    @OneToMany(mappedBy = "foyer")
    private List<Bloc> blocs;
}
