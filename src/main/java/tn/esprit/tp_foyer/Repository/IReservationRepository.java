package tn.esprit.tp_foyer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tp_foyer.Entities.Reservation;

import java.sql.Date;
import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation,String> {
    @Query("SELECT r FROM Reservation r WHERE FUNCTION('YEAR', r.anneeUniversitaire) = FUNCTION('YEAR', :anneeUniversitaire) " +
            "AND r.chambre.bloc.foyer.universite.nomUniversite = :nomUniversite")
    List<Reservation> findByAnneeUniversitaireAndUniversite(@Param("anneeUniversitaire") Date anneeUniversitaire, @Param("nomUniversite") String nomUniversite);
}
