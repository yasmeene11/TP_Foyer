package tn.esprit.tp_foyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.Entities.Universite;
import tn.esprit.tp_foyer.Services.IUniversiteService;


import java.util.List;

@RestController
@RequestMapping("/universite")
@AllArgsConstructor
public class UniversiteController {
IUniversiteService IUniversiteService;
    @PostMapping("/saveUniversite")
    public Universite saveFoyer(@RequestBody Universite foyer) {
        return IUniversiteService.save(foyer);
    }
    @GetMapping("/getById/{id}")
    public Universite getFoyer(@PathVariable Long id) {
        return IUniversiteService.findById(id);
    }
    @GetMapping("/getAll")
    public List<Universite> getAllFoyer() {
        return IUniversiteService.findAll();
    }

}
