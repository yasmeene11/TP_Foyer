package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Chambre;
import tn.esprit.tp_foyer.Repository.IChambreRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    IChambreRepository chambreRepository;

    @Override
    public Chambre findById(Long id) {
        return chambreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chambre> findAll() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre save(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void delete(Long id) {
        Optional<Chambre> chambreOptional = chambreRepository.findById(id);
        if (chambreOptional.isPresent()) {
            chambreRepository.deleteById(id);
        }    }
    }
