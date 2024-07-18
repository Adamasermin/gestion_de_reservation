package odk.g1.penkuru.penkuru.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.Avion;
import odk.g1.penkuru.penkuru.Repository.AvionRepository;

@Service 
@AllArgsConstructor
public class AvionService {
    private final AvionRepository avionRepository;

    public Avion creer(Avion avion) {
        return avionRepository.save(avion);
    }

    
    public Avion modifier(Long id, Avion avion) {
        Optional<Avion> optionalAvion= avionRepository.findById(id);
        if (optionalAvion.isPresent()) {
            Avion avionAModifier = optionalAvion.get();
            avionAModifier.setCapacite(avion.getCapacite());
            avionAModifier.setImmatriculation(avion.getImmatriculation());
            avionAModifier.setModele(avion.getModele());
            return avionRepository.save(avionAModifier);
        } else {
            return null;
        }
    }

    
    public String supprimer(Long id) {
        avionRepository.deleteById(id);
        return "Avion supprimé avec succès";
    }

    
    public List<Avion> afficher() {
       return avionRepository.findAll();
    }
}
