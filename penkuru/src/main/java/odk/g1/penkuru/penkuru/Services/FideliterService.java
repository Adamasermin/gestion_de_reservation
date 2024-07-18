package odk.g1.penkuru.penkuru.Services;

import odk.g1.penkuru.penkuru.Models.Fideliter;
import odk.g1.penkuru.penkuru.Models.Passager;
import odk.g1.penkuru.penkuru.Repository.FideliterRepository;
import odk.g1.penkuru.penkuru.Repository.PassagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FideliterService {
    @Autowired
    FideliterRepository fideliterRepository;

    public Fideliter ajouterFideliter(Fideliter fideliter){
        return fideliterRepository.save(fideliter);
    }

    public String supprimerFideliter(Long idFideliter){
        Fideliter fideliter = fideliterRepository.findById(idFideliter)
                .orElseThrow(() -> new RuntimeException("L'id donné ne correspond à aucune fideliter !!!"));
        Passager passager = fideliter.getPassager();
        fideliterRepository.delete(fideliter);
        return "La fideliter avec l'id : "+idFideliter+
                " appartenant au passager : "+passager.getPrenom()+" "+passager.getNom()+
                " a été supprimer avec succès!!!";
    }

    public List<Fideliter> listerFideliter(){
        return fideliterRepository.findAll();
    }

    public Fideliter modifierFideliter(Long idFideliter, int newPoint){
        Fideliter fideliter = fideliterRepository.findById(idFideliter)
                .orElseThrow(() -> new RuntimeException("L'id de la fidelité donné pour " +
                        "modification ne correspond à aucune fideliter !!!"));
        fideliter.setPoints(newPoint);
        return fideliterRepository.save(fideliter);
    }
    
}
