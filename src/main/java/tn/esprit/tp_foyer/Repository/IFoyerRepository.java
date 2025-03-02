package tn.esprit.tp_foyer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.Entities.Foyer;
@Repository
public interface IFoyerRepository extends JpaRepository<Foyer,Long> {
public Foyer findByNomFoyerAndCapaciteFoyer(String nomFoyer, Long capaciteFoyer);
}
