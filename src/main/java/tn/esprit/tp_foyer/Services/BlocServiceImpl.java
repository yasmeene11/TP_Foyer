package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Chambre;
import tn.esprit.tp_foyer.Entities.Foyer;
import tn.esprit.tp_foyer.Repository.IBlocRepository;
import tn.esprit.tp_foyer.Repository.IChambreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {
    IBlocRepository blocRepository;
    @Override
    public Bloc findById(Long id) {
        return blocRepository.findById(id).orElse(null);    }

    @Override
    public List<Bloc> findAll() {
        return (List<Bloc>) blocRepository.findAll();    }

    @Override
    public Bloc save(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void delete(Long id) {
        Optional<Bloc> blocOptional = blocRepository.findById(id);
        if (blocOptional.isPresent()) {
            blocRepository.deleteById(id);
        }    }
    @Autowired
IChambreRepository chambreRepository;
    @Override
    public List<Chambre> affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new IllegalArgumentException("Bloc not found with id: " + idBloc));
        List<Chambre> updatedChambres = new ArrayList<>();
        for (Long num : numChambre) {
            Chambre chambre = (Chambre) chambreRepository.findByNumeroChambreIn(numChambre);
            chambre.setBloc(bloc);
            chambreRepository.save(chambre);
            updatedChambres.add(chambre);
        }
        return updatedChambres;
    }


    }
