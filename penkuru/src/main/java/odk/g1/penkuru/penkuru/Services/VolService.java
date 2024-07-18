package odk.g1.penkuru.penkuru.Services;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.Vol;
import odk.g1.penkuru.penkuru.Repository.VolRepository;

@Service
@AllArgsConstructor
public class VolService {
    private final VolRepository volRepository;

    public Vol creer(Vol vol) {
        return volRepository.save(vol);
    }

    
    public List<Vol> lire() {
        return volRepository.findAll();
    }

    public Vol modifier(Long id, Vol vol) {
        return volRepository.findById(id).map(p -> {
            p.setVille_depart(vol.getVille_depart());
            p.setVille_arrive(vol.getVille_arrive());
            p.setDate_depart(vol.getDate_depart());
            p.setDate_retour(vol.getDate_retour());
            p.setNbre_de_place_dispo(vol.getNbre_de_place_dispo());
            p.setTarif(vol.getTarif());
            return volRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Avion non Trouve."));
    }

    public String supprimer(Long id) {
        volRepository.deleteById(id);
        return "Vol Supprimer avec Succes.";
    }
}
