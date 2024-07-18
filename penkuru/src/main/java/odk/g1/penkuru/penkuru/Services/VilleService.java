package odk.g1.penkuru.penkuru.Services;

import odk.g1.penkuru.penkuru.Models.Ville;
import odk.g1.penkuru.penkuru.Repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VilleService {
    @Autowired
    private VilleRepository villeRepository;
    //recuperer tous les pays
    public List<Ville> getVilles() {
        return villeRepository.findAll();
    }
    //recuperer un pays par son id
    public Optional<Ville> getVille(Long id) {
        return villeRepository.findById(id);
    }
    // pour creer une nouvelle ville
    public Ville addVille(Ville ville) {
        return villeRepository.save(ville);
    }
    //mise a jour d'une ville
    public Optional<Ville> updateVille(Long id, Ville ville) {
        Optional<Ville> villeOptional = villeRepository.findById(id);
        if (villeOptional.isPresent()) {
            villeOptional.get().setNom(ville.getNom());
            Ville existingVille = villeOptional.get();
            existingVille.setNom(ville.getNom());
            villeRepository.save(existingVille);
            return Optional.of(existingVille);
        }
        return Optional.empty();
    }

    //supprimer une ville
    public void deleteVille(Long id) {
        villeRepository.deleteById(id);
    }
}
