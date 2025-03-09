package tn.esprit.tp_foyer.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Services.IBlocService;

import java.util.List;
@Tag(name = "Gestion bloc")
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
    public Bloc getBloc(@PathVariable Long id) {
        return IBlocService.findById(id);
    }
    @GetMapping("/getAll")
    public List<Bloc> getAllBloc() {
        return IBlocService.findAll();
    }
}
