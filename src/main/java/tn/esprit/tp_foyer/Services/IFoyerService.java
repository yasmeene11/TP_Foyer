package tn.esprit.tp_foyer.Services;

import tn.esprit.tp_foyer.Entities.Foyer;

import java.util.List;

public interface IFoyerService {
    public Foyer findById(Long id);

    public List<Foyer> findAll( );
    public Foyer save(Foyer foyer);
    public void delete(Long id );
    public Foyer getByNomFoyerAndCapaciteFoyer(String nomFoyer, Long capaciteFoyer);
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}
