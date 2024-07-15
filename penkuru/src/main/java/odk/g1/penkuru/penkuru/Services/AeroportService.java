package odk.g1.penkuru.penkuru.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.Aeroport;
import odk.g1.penkuru.penkuru.Repository.AeroportRepository;

@Service
@AllArgsConstructor
public class AeroportService {
    private final AeroportRepository aeroportRepository;

    public Aeroport creer(Aeroport aeroport) {
        return aeroportRepository.save(aeroport);
    }

    
    public Aeroport modifier(Long id, Aeroport aeroport) {
        Optional<Aeroport> optionalAeroport= aeroportRepository.findById(id);
        if (optionalAeroport.isPresent()) {
            Aeroport aeroportAModifier = optionalAeroport.get();
            aeroportAModifier.setNom_aeroport(aeroport.getNom_aeroport());
            return aeroportRepository.save(aeroportAModifier);
        } else {
            return null;
        }
    }

    
    public String supprimer(Long id) {
        aeroportRepository.deleteById(id);
        return "Aeroport supprimé avec succès";
    }

    
    public List<Aeroport> afficher() {
       return aeroportRepository.findAll();
    }
}
