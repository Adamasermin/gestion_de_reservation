package odk.g1.penkuru.penkuru.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.CompagnieAerienne;
import odk.g1.penkuru.penkuru.Repository.CompagnieRepository;

@Service
@AllArgsConstructor
public class CompagnieService {
    private final CompagnieRepository compagnieRepository;

    public CompagnieAerienne creer(CompagnieAerienne compagnieAerienne) {
        return compagnieRepository.save(compagnieAerienne);
    }

    public CompagnieAerienne modifier(Long id, CompagnieAerienne compagnieAerienne){
        Optional<CompagnieAerienne> optionalCompagnieAerienne = compagnieRepository.findById(id);
        if(optionalCompagnieAerienne.isPresent()){
            CompagnieAerienne compagnieAerienneAModifier = optionalCompagnieAerienne.get();
            compagnieAerienneAModifier.setNom_compagnie(compagnieAerienne.getNom_compagnie());
            compagnieAerienneAModifier.setAdresse(compagnieAerienne.getAdresse());
            compagnieAerienneAModifier.setDescription(compagnieAerienne.getDescription());
            compagnieAerienneAModifier.setLogo(compagnieAerienne.getLogo());
            compagnieAerienneAModifier.setPassword(compagnieAerienne.getPassword());
            return compagnieRepository.save(compagnieAerienneAModifier);
        } else{
            return null;
        }
    }

    public String supprimer(Long id) {
        compagnieRepository.deleteById(id);
        return "Compagnie supprimé avec succès";
    }

    public List<CompagnieAerienne> afficher() {
       return compagnieRepository.findAll();
    }
}
