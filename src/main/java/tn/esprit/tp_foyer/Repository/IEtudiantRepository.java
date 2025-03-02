package tn.esprit.tp_foyer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_foyer.Entities.Etudiant;

public interface IEtudiantRepository extends JpaRepository<Etudiant,Long> {
}
