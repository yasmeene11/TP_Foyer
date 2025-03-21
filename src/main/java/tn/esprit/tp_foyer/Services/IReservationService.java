package tn.esprit.tp_foyer.Services;

import tn.esprit.tp_foyer.Entities.Chambre;
import tn.esprit.tp_foyer.Entities.Reservation;

import java.sql.Date;
import java.util.List;

public interface IReservationService {
    public Reservation findById(String id);

    public List<Reservation> findAll( );
    public Reservation save(Reservation reservation);
    public void delete(String id );
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite);
    public Reservation ajouterReservation(long idBloc, long cinEtudiant);
}
