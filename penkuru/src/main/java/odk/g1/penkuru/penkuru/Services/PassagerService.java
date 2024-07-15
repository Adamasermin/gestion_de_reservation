package odk.g1.penkuru.penkuru.Services;

import odk.g1.penkuru.penkuru.Models.Passager;
import odk.g1.penkuru.penkuru.Models.Personnel;
import odk.g1.penkuru.penkuru.Repository.PassagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassagerService {
    @Autowired
    PassagerRepository passagerRepository;

    public Passager ajouterPassager(Passager passager){
        return passagerRepository.save(passager);
    }

    public String supprimerPassager(Long idPassager){
        Passager passager = passagerRepository.findById(idPassager)
                .orElseThrow(() -> new RuntimeException("L'id passager donné ne correspond à aucun passager !!!"));
        String nom = passager.getNom();
        String prenom = passager.getPrenom();
        passagerRepository.delete(passager);
        return "Le personnel avec l'id : "+idPassager+", prenom: "+prenom+", nom: "+nom+"a été supprimer avec succès.";
    }

    public List<Passager> listerPassager(){
        return passagerRepository.findAll();
    }

    public Passager modifierPassager(Long idPassagerBD, Passager newInfopassager){
        Passager BDpassager = passagerRepository.findById(idPassagerBD)
                .orElseThrow(() -> new RuntimeException("L'id du passager donné pour modification ne correspond à aucun passager !!!"));
        BDpassager.setNom(newInfopassager.getNom());
        BDpassager.setPrenom(newInfopassager.getPrenom());
        BDpassager.setEmail(newInfopassager.getEmail());
        BDpassager.setPassword(newInfopassager.getPassword());
        BDpassager.setTel(newInfopassager.getTel());
        BDpassager.setDate_naissance(newInfopassager.getDate_naissance());

        return passagerRepository.save(BDpassager);
    }
    
}
