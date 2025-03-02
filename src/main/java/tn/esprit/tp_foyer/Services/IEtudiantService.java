package tn.esprit.tp_foyer.Services;

import tn.esprit.tp_foyer.Entities.Chambre;
import tn.esprit.tp_foyer.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public Etudiant findById(Long id);

    public List<Etudiant> findAll( );
    public Etudiant save(Etudiant etudiant);
    public void delete(Long id );
}
