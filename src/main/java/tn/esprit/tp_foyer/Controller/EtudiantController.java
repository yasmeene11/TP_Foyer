package tn.esprit.tp_foyer.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.Entities.Etudiant;
import tn.esprit.tp_foyer.Services.EtudiantServiceImpl;
import tn.esprit.tp_foyer.Services.IEtudiantService;

import java.util.List;
@Tag(name = "Gestion etudiant")
@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor
public class EtudiantController {
    IEtudiantService IEtudiantService;
    @Operation(description = "récupérer tout les etudiants de la base de données")
    @PostMapping("/saveEtudiant")
    public Etudiant saveEtudiant(@RequestBody Etudiant etudiant) {
        return IEtudiantService.save(etudiant);
    }
    @GetMapping("/getById/{id}")
    public Etudiant getEtudiant(@PathVariable Long id) {
        return IEtudiantService.findById(id);
    }
    @GetMapping("/getAll")
    public List<Etudiant> getAllEtudiant() {
        return IEtudiantService.findAll();
    }

}
