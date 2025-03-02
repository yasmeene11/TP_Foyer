package tn.esprit.tp_foyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.Entities.Foyer;
import tn.esprit.tp_foyer.Services.IFoyerService;

import java.util.List;

@RestController
@RequestMapping("/foyer")
@AllArgsConstructor
public class FoyerController {
IFoyerService IFoyerService;
    @PostMapping("/saveFoyer")
    public Foyer saveFoyer(@RequestBody Foyer foyer) {
        return IFoyerService.save(foyer);
    }
    @GetMapping("/getById/{id}")
    public Foyer getFoyer(@PathVariable Long id) {
        return IFoyerService.findById(id);
    }
    @GetMapping("/getAll")
    public List<Foyer> getAllFoyer() {
        return IFoyerService.findAll();
    }
    @GetMapping("/getbynameandcapacity/{nomFoyer}/{capaciteFoyer}")
    public Foyer findByNomFoyerAndCapaciteFoyer(@PathVariable String nomFoyer, @PathVariable Long capaciteFoyer) {
        return IFoyerService.getByNomFoyerAndCapaciteFoyer(nomFoyer, capaciteFoyer);
    }


}
