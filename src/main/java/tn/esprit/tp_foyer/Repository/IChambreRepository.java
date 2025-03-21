package tn.esprit.tp_foyer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tp_foyer.Entities.Chambre;
import tn.esprit.tp_foyer.Entities.TypeChambre;

import java.util.List;
import java.util.Optional;

public interface IChambreRepository extends JpaRepository<Chambre,Long> {
    @Query("SELECT c FROM Chambre c WHERE c.typeC = :type AND c.bloc.foyer.universite.nomUniversite = :nomUniversite " +
            "AND c.idChambre NOT IN (SELECT r.chambre.idChambre FROM Reservation r WHERE r.anneeUniversitaire = FUNCTION('YEAR', CURRENT_DATE))")
    List<Chambre> findNonReservedByUniversiteAndType(@Param("nomUniversite") String nomUniversite, @Param("type") TypeChambre type);
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> findChambresByBlocAndTypeJPQL(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);
    List<Chambre> findByTypeCAndBlocIdBloc( TypeChambre typeC, long idBloc);
    List<Chambre> findByNumeroChambreIn(List<Long> numeroChambre);
}
