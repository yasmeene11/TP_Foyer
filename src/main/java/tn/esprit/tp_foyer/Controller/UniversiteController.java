package tn.esprit.tp_foyer.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.Entities.Universite;
import tn.esprit.tp_foyer.Services.IUniversiteService;


import java.util.List;
@Tag(name = "Gestion universite")
@RestController
@RequestMapping("/universite")
@AllArgsConstructor
public class UniversiteController {
    @Autowired
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
    @PutMapping("/affecterFoyer/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable String nomUniversite) {
        return IUniversiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }
    @PutMapping("/desaffecterFoyer/{idUniversite}")
    public ResponseEntity<Universite> desaffecterFoyerAUniversite(@PathVariable long idUniversite) {
        Universite universite = IUniversiteService.desaffecterFoyerAUniversite(idUniversite);
        return new ResponseEntity<>(universite, HttpStatus.OK);
    }
}
