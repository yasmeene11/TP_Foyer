package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Etudiant;
import tn.esprit.tp_foyer.Repository.IEtudiantRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
    IEtudiantRepository etudiantRepository;
    @Override
    public Etudiant findById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Etudiant> findAll() {
return (List<Etudiant>) etudiantRepository.findAll();    }

    @Override
    public Etudiant save(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void delete(Long id) {
        Optional<Etudiant> etudiantOptional = etudiantRepository.findById(id);
        if (etudiantOptional.isPresent()) {
            etudiantRepository.deleteById(id);
        }    }    }

