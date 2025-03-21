package tn.esprit.tp_foyer.Services;

import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Chambre;
import tn.esprit.tp_foyer.Entities.Foyer;

import java.util.List;

public interface IBlocService {
    public Bloc findById(Long id);

    public List<Bloc> findAll( );
    public Bloc save(Bloc bloc);
    public void delete(Long id );
    public List<Chambre> affecterChambresABloc(List<Long> numChambre, long idBloc) ;

}
