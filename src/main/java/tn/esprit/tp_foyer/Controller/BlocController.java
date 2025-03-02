package tn.esprit.tp_foyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Services.IBlocService;

import java.util.List;

@RestController
@RequestMapping("/bloc")
@AllArgsConstructor
public class BlocController {
    IBlocService IBlocService;
    @PostMapping("/saveBloc")
    public Bloc saveBloc(@RequestBody Bloc bloc) {
        return IBlocService.save(bloc);
    }
    @GetMapping("/getById/{id}")
    public Bloc getFoyer(@PathVariable Long id) {
        return IBlocService.findById(id);
    }
    @GetMapping("/getAll")
    public List<Bloc> getAllFoyer() {
        return IBlocService.findAll();
    }
}
