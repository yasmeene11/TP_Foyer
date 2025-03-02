package tn.esprit.tp_foyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.Entities.Etudiant;
import tn.esprit.tp_foyer.Services.EtudiantServiceImpl;
import tn.esprit.tp_foyer.Services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor
public class EtudiantController {
    IEtudiantService IEtudiantService;
    @PostMapping("/saveEtudiant")
    public Etudiant saveFoyer(@RequestBody Etudiant etudiant) {
        return IEtudiantService.save(etudiant);
    }
    @GetMapping("/getById/{id}")
    public Etudiant getFoyer(@PathVariable Long id) {
        return IEtudiantService.findById(id);
    }
    @GetMapping("/getAll")
    public List<Etudiant> getAllFoyer() {
        return IEtudiantService.findAll();
    }

}
