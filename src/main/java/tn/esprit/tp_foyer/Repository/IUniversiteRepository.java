package tn.esprit.tp_foyer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_foyer.Entities.Universite;

public interface IUniversiteRepository extends JpaRepository<Universite,Long> {
}
