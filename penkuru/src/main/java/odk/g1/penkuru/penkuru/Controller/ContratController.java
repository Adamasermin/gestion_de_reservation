package odk.g1.penkuru.penkuru.Controller;


import odk.g1.penkuru.penkuru.Models.Contrat;
import odk.g1.penkuru.penkuru.Services.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ContratController {
    @Autowired
    ContratService contratService;

    @PostMapping("/ajoutContrat")
    public ResponseEntity<Contrat> ajouterContrat(@RequestBody Contrat contrat) {
        Contrat savedcontrat = contratService.ajouterContrat(contrat);
        return ResponseEntity.ok(savedcontrat);
    }

    @DeleteMapping("/suppContrat/{id}")
    public ResponseEntity<String> supprimerContrat(@PathVariable Long id) {
        contratService.supprimerContrat(id);
        return ResponseEntity.ok("Contrat supprimer avec succes !!!");
    }

    @GetMapping("/listeContrat")
    public List<Contrat> listerContrat() {
        return contratService.listerContrat();
    }

    @PostMapping("/modifierContrat/{id}")
    public Contrat modifierContrat(@PathVariable Long id, @RequestBody Contrat newInfoContrat){
        return contratService.modifierContrat(id,newInfoContrat);
    }
    
}
