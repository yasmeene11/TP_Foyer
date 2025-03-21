package tn.esprit.tp_foyer.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.Entities.Reservation;
import tn.esprit.tp_foyer.Services.IReservationService;

import java.util.List;
@Tag(name = "Gestion reservation")
@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {
IReservationService IReservationService;
    @PostMapping("/saveReservation")
    public Reservation saveReservation(@RequestBody Reservation reservation) {
        return IReservationService.save(reservation);
    }
    @GetMapping("/getById/{id}")
    public Reservation getReservation(@PathVariable String id) {
        return IReservationService.findById(id);
    }
    @GetMapping("/getAll")
    public List<Reservation> getAllReservation() {
        return IReservationService.findAll();
    }
    @PostMapping("/ajouter/{idBloc}/{idEtudiant}")
    public ResponseEntity<Reservation> ajouterReservation(@PathVariable long idBloc, @PathVariable long idEtudiant) {
        return ResponseEntity.ok(IReservationService.ajouterReservation(idBloc, idEtudiant));
    }

}
