package odk.g1.penkuru.penkuru.Services;

import odk.g1.penkuru.penkuru.Models.Personnel;
import odk.g1.penkuru.penkuru.Repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonnelService {
    @Autowired
    PersonnelRepository personnelRepository;

    public Personnel ajouterPersonnel(Personnel personnel){
        return personnelRepository.save(personnel);
    }

    public String supprimerPersonnel(Long idPersonnel){
        Personnel personnel = personnelRepository.findById(idPersonnel)
                .orElseThrow(() -> new RuntimeException("L'id donné ne correspond à aucun personnel !!!"));
        String nom = personnel.getNom();
        String prenom = personnel.getPrenom();
        personnelRepository.delete(personnel);
        return "Le personnel avec l'id : "+idPersonnel+", prenom: "+prenom+", nom: "+nom+"a été supprimer avec succès.";
    }

    public List<Personnel> listerPersonnel(){
        return personnelRepository.findAll();
    }

    public Personnel modifierPersonel(Long idPersonnelBD, Personnel newInfopersonnel){
        Personnel BDpersonnel = personnelRepository.findById(idPersonnelBD)
                .orElseThrow(() -> new RuntimeException("L'id donné pour modification ne correspond à aucun personnel !!!"));
        BDpersonnel.setNom(newInfopersonnel.getNom());
        BDpersonnel.setPrenom(newInfopersonnel.getPrenom());
        BDpersonnel.setDate_naissance((newInfopersonnel.getDate_naissance()));
        BDpersonnel.setDate_embauche(newInfopersonnel.getDate_embauche());
        BDpersonnel.setPoste(newInfopersonnel.getPoste());
        BDpersonnel.setTel(newInfopersonnel.getTel());
        BDpersonnel.setExperience(newInfopersonnel.getExperience());
        BDpersonnel.setStatus(newInfopersonnel.getStatus());
        BDpersonnel.setNationalite(newInfopersonnel.getNationalite());
        BDpersonnel.setAdresse(newInfopersonnel.getAdresse());

        return personnelRepository.save(BDpersonnel);
    }
}
