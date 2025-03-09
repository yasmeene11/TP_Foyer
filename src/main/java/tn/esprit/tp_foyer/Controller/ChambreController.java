package tn.esprit.tp_foyer.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.Entities.Chambre;
import tn.esprit.tp_foyer.Services.IChambreService;


import java.util.List;
@Tag(name = "Gestion Chambre")
@RestController
@RequestMapping("/chambre")
@AllArgsConstructor
public class ChambreController {
    IChambreService IChambreService;
    @PostMapping("/savechambre")
    public Chambre saveChambre(@RequestBody Chambre chambre) {
        return IChambreService.save(chambre);
    }
    @GetMapping("/getById/{id}")
    public Chambre getChambre(@PathVariable Long id) {
        return IChambreService.findById(id);
    }
    @GetMapping("/getAll")
    public List<Chambre> getAllChambre() {
        return IChambreService.findAll();
    }

}
