package odk.g1.penkuru.penkuru.Controller;

import odk.g1.penkuru.penkuru.Models.Rapport;
import odk.g1.penkuru.penkuru.Services.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rapports")

public class RapportController {

    @Autowired
    private RapportService rapportService;
    //endpoint pour avoir tous les rapports
    public List<Rapport> getAllRapports() {
        return rapportService.getAllRapports();
    }
    //avoir un rapport par son id
    public Optional<Rapport> getRapportById(Long id) {
        return rapportService.getRapportById(id);
    }
    //pour creer un nouveau rapports
    public Rapport addRapport(Rapport rapport) {
        return rapportService.addRapport(rapport);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Rapport> updateRapport(@PathVariable Long id, @RequestBody Rapport rapport) {
        Optional<Rapport> updatedRapport = rapportService.updateRapport(id, rapport);
        return updatedRapport.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRapport(@PathVariable Long id) {
        rapportService.deleteRapport(id);
        return new ResponseEntity<>("Rapport supprimé avec succès", HttpStatus.OK);
    }


    
}
