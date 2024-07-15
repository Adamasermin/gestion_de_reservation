package odk.g1.penkuru.penkuru.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.AssignerVol;
import odk.g1.penkuru.penkuru.Repository.AssignerVolRepository;

@Service
@AllArgsConstructor
public class AssignerVolService {
    private final AssignerVolRepository assignerVolRepository;

    public AssignerVol creer(AssignerVol assignerVol) {
        return assignerVolRepository.save(assignerVol);
    }

    

    
    public String supprimer(Long id) {
        assignerVolRepository.deleteById(id);
        return "Assignation vol a été supprimé avec succès";
    }

    
    public List<AssignerVol> afficher() {
       return assignerVolRepository.findAll();
    }
}
