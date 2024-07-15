package odk.g1.penkuru.penkuru.Services;

import odk.g1.penkuru.penkuru.Models.CompagnieAerienne;
import odk.g1.penkuru.penkuru.Models.Contrat;
import odk.g1.penkuru.penkuru.Models.Fideliter;
import odk.g1.penkuru.penkuru.Repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratService {
    @Autowired
    ContratRepository contratRepository;

    public Contrat ajouterContrat(Contrat contrat){
        return contratRepository.save(contrat);
    }

    public String supprimerContrat(Long idContrat){
        Contrat contrat = contratRepository.findById(idContrat)
                .orElseThrow(() -> new RuntimeException("L'id du " +
                        "contrat donné ne correspond à aucun contrat !!!"));
        CompagnieAerienne compagnie = contrat.getCompagnieAerienne();
        contratRepository.delete(contrat);
        return "Le contrat avec l'id : "+idContrat+" appartenant à la " +
                "compagnie "+compagnie.getNom_compagnie()+" a été supprimer avec succès";
    }

    public List<Contrat> listerContrat(){
        return contratRepository.findAll();
    }

    public Contrat modifierContrat(Long idContrat, Contrat newInfoContrat){
        Contrat contrat = contratRepository.findById(idContrat)
                .orElseThrow(() -> new RuntimeException("L'id du contrat donné pour " +
                        "modification ne correspond à aucun contrat !!!"));
        contrat.setDate_debut(newInfoContrat.getDate_debut());
        contrat.setDate_fin(newInfoContrat.getDate_fin());
        contrat.setDetails(newInfoContrat.getDetails());
        contrat.setCompagnieAerienne(new CompagnieAerienne());

        return contratRepository.save(contrat);
    }

}
