package tn.esprit.tp_foyer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_foyer.Entities.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation,Long> {
}
