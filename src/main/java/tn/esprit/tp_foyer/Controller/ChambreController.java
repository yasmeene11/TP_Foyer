package tn.esprit.tp_foyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.Entities.Chambre;
import tn.esprit.tp_foyer.Services.IChambreService;


import java.util.List;

@RestController
@RequestMapping("/chambre")
@AllArgsConstructor
public class ChambreController {
    IChambreService IChambreService;
    @PostMapping("/savechambre")
    public Chambre saveFoyer(@RequestBody Chambre chambre) {
        return IChambreService.save(chambre);
    }
    @GetMapping("/getById/{id}")
    public Chambre getFoyer(@PathVariable Long id) {
        return IChambreService.findById(id);
    }
    @GetMapping("/getAll")
    public List<Chambre> getAllFoyer() {
        return IChambreService.findAll();
    }

}
