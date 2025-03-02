package tn.esprit.tp_foyer.Services;

import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Chambre;

import java.util.List;

public interface IChambreService {
    public Chambre findById(Long id);

    public List<Chambre> findAll( );
    public Chambre save(Chambre chambre);
    public void delete(Long id );
}
