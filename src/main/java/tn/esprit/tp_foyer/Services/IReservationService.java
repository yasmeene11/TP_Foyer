package tn.esprit.tp_foyer.Services;

import tn.esprit.tp_foyer.Entities.Chambre;
import tn.esprit.tp_foyer.Entities.Reservation;

import java.util.List;

public interface IReservationService {
    public Reservation findById(Long id);

    public List<Reservation> findAll( );
    public Reservation save(Reservation reservation);
    public void delete(Long id );
}
