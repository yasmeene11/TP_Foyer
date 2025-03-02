package tn.esprit.tp_foyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.Entities.Reservation;
import tn.esprit.tp_foyer.Services.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {
IReservationService IReservationService;
    @PostMapping("/saveReservation")
    public Reservation saveFoyer(@RequestBody Reservation reservation) {
        return IReservationService.save(reservation);
    }
    @GetMapping("/getById/{id}")
    public Reservation getFoyer(@PathVariable Long id) {
        return IReservationService.findById(id);
    }
    @GetMapping("/getAll")
    public List<Reservation> getAllFoyer() {
        return IReservationService.findAll();
    }

}
