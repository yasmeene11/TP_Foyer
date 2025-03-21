package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Foyer;
import tn.esprit.tp_foyer.Entities.Universite;
import tn.esprit.tp_foyer.Repository.IFoyerRepository;
import tn.esprit.tp_foyer.Repository.IUniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {
    IUniversiteRepository universiteRepository;
    IFoyerRepository foyerRepository;
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
    @Autowired
    public UniversiteServiceImpl(IFoyerRepository foyerRepository, IUniversiteRepository universiteRepository) {
        this.foyerRepository = foyerRepository;
        this.universiteRepository = universiteRepository;
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        //elli aandha mapped by heya el slave
        if (foyer != null) {
            foyer.setUniversite(universite);
            foyerRepository.save(foyer);
        }
        return universite;
    }
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        if (universite != null) {
            Foyer foyer = foyerRepository.findByUniversite(universite);
                foyer.setUniversite(null);
                foyerRepository.save(foyer);

        }

        return universite; // Return the Universite object
    }

}
