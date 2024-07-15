package odk.g1.penkuru.penkuru.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.Bagage;
import odk.g1.penkuru.penkuru.Repository.BagageRepository;

@Service
@AllArgsConstructor
public class BagageService {
    private final BagageRepository bagageRepository;

    public Bagage creer(Bagage bagage) {
        return bagageRepository.save(bagage);
    }

    
    public Bagage modifier(Long id, Bagage bagage) {
        Optional<Bagage> optionalBagage= bagageRepository.findById(id);
        if (optionalBagage.isPresent()) {
            Bagage bagageAModifier = optionalBagage.get();
            bagageAModifier.setDimension(bagage.getDimension());
            bagageAModifier.setPoids(bagage.getPoids());
            bagageAModifier.setStatus(bagage.getStatus());
            return bagageRepository.save(bagageAModifier);
        } else {
            return null;
        }
    }

    
    public String supprimer(Long id) {
        bagageRepository.deleteById(id);
        return "Bagage supprimé avec succès";
    }

    
    public List<Bagage> afficher() {
       return bagageRepository.findAll();
    }
}
