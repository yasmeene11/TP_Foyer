package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Reservation;
import tn.esprit.tp_foyer.Repository.IReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    IReservationRepository reservationRepository;
    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> findAll() {
return (List<Reservation>) reservationRepository.findAll();    }

    @Override
    public Reservation save(Reservation reservation) {
return reservationRepository.save(reservation);    }

    @Override
    public void delete(Long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if (reservationOptional.isPresent()) {
            reservationRepository.deleteById(id);
        }    }
}
