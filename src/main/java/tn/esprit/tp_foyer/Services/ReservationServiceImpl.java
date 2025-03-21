package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.Entities.*;
import tn.esprit.tp_foyer.Repository.IBlocRepository;
import tn.esprit.tp_foyer.Repository.IReservationRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static tn.esprit.tp_foyer.Entities.TypeChambre.*;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    IReservationRepository reservationRepository;

    @Override
    public Reservation findById(String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> findAll() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void delete(String id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if (reservationOptional.isPresent()) {
            reservationRepository.deleteById(id);
        }
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
        return reservationRepository.findByAnneeUniversitaireAndUniversite(anneeUniversitaire, nomUniversite);
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long idEtudiant) {
        IBlocService blocRepository = null;
        Bloc bloc = blocRepository.findById(idBloc);
        IEtudiantService etudiantRepository = null;
        Etudiant etudiant = etudiantRepository.findById(idEtudiant);
        Chambre chambreDisponible = bloc.getChambres().stream()
                .filter(chambre -> chambre.getReservations().size() < getCapaciteMax(chambre.getTypeC()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucune chambre disponible"));
        String numReservation = chambreDisponible.getNumeroChambre() + "-" + bloc.getNomBloc() + "-" + LocalDate.now().getYear();
        Reservation reservation = new Reservation();
        reservation.setIdReservation(numReservation);
        reservation.setEstValide(true);
        reservation.setChambre(chambreDisponible);
        reservation.setEtudiant(etudiant);
        reservation.setAnneeUniversitaire(Date.valueOf(LocalDate.now()));

        return reservationRepository.save(reservation);
    }

    private int getCapaciteMax(TypeChambre typeC) {
            return switch (typeC) {
                case SIMPLE -> 1;
                case DOUBLE -> 2;
                case TRIPLE -> 3;
            };
    }

}
