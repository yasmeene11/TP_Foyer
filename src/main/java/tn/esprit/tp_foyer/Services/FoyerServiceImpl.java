package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.Entities.Foyer;
import tn.esprit.tp_foyer.Repository.IFoyerRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    IFoyerRepository foyerRepository;

    @Override
    public Foyer findById(Long id) {
        return foyerRepository.findById(id).orElse(null);
    }
    

    @Override
    public List<Foyer> findAll() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer save(Foyer foyer) {
        return foyerRepository.save(foyer);
    }


    @Override
    public void delete(Long id) {
        Optional<Foyer> foyerOptional = foyerRepository.findById(id);
        if (foyerOptional.isPresent()) {
            foyerRepository.deleteById(id);
        }
    }
        @Override
    public Foyer getByNomFoyerAndCapaciteFoyer(String nomFoyer, Long capaciteFoyer) {
        return foyerRepository.findByNomFoyerAndCapaciteFoyer(nomFoyer, capaciteFoyer);
    }
}
