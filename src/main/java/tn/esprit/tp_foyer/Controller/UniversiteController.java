package tn.esprit.tp_foyer.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.Entities.Universite;
import tn.esprit.tp_foyer.Services.IUniversiteService;


import java.util.List;
@Tag(name = "Gestion universite")
@RestController
@RequestMapping("/universite")
@AllArgsConstructor
public class UniversiteController {
IUniversiteService IUniversiteService;
    @PostMapping("/saveUniversite")
    public Universite saveUniversite(@RequestBody Universite foyer) {
        return IUniversiteService.save(foyer);
    }
    @GetMapping("/getById/{id}")
    public Universite getUniversite(@PathVariable Long id) {
        return IUniversiteService.findById(id);
    }
    @GetMapping("/getAll")
    public List<Universite> getAllUniversite() {
        return IUniversiteService.findAll();
    }

}
