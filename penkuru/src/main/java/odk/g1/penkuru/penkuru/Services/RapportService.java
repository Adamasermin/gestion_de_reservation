package odk.g1.penkuru.penkuru.Services;

import odk.g1.penkuru.penkuru.Models.Rapport;
import odk.g1.penkuru.penkuru.Repository.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RapportService {

    @Autowired
    private RapportRepository rapportRepository;
    //recuperer tous les rapports
    public List<Rapport> getAllRapports() {
        return rapportRepository.findAll();
    }
    //recuperer un seul rapport
    public Optional<Rapport> getRapportById(Long id) {
        return rapportRepository.findById(id);
    }
    //creer un nouveau rapport
    public Rapport addRapport(Rapport rapport) {
        return rapportRepository.save(rapport);
    }
    //mise a jour d'un rapport
    public Optional<Rapport> updateRapport(Long id, Rapport rapport) {
        Optional<Rapport> rapportOptional = rapportRepository.findById(id);
        if (rapportOptional.isPresent()) {
            rapport.setType(rapport.getType());
            rapport.setDate(rapport.getDate());
            rapport.setContenu(rapport.getContenu());
            rapportRepository.save(rapport);
        }
        return rapportOptional;
    }
    //supprimer un rapport
    public void deleteRapport(Long id) {
        rapportRepository.deleteById(id);
    }


    
}
