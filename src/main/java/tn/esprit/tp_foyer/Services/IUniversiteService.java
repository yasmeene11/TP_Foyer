package tn.esprit.tp_foyer.Services;

import tn.esprit.tp_foyer.Entities.Chambre;
import tn.esprit.tp_foyer.Entities.Universite;

import java.util.List;

public interface IUniversiteService {
    public Universite findById(Long id);

    public List<Universite> findAll();

    public Universite save(Universite universite);

    public void delete(Long id);

    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    public Universite desaffecterFoyerAUniversite (long idUniversite) ;
}