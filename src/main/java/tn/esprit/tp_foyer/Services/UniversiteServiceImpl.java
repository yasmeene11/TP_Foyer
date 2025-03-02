package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Universite;
import tn.esprit.tp_foyer.Repository.IUniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {
    IUniversiteRepository universiteRepository;
    @Override
    public Universite findById(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Universite> findAll() {
return (List<Universite>) universiteRepository.findAll();    }

    @Override
    public Universite save(Universite universite) {
return universiteRepository.save(universite);    }

    @Override
    public void delete(Long id) {
        Optional<Universite> univOptional = universiteRepository.findById(id);
        if (univOptional.isPresent()) {
            universiteRepository.deleteById(id);
        }    }
}
