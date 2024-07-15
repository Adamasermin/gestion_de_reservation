package odk.g1.penkuru.penkuru.Controller;

import odk.g1.penkuru.penkuru.Models.Fideliter;
import odk.g1.penkuru.penkuru.Models.Personnel;
import odk.g1.penkuru.penkuru.Services.FideliterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class FideliterController {
    @Autowired
    FideliterService fideliterService;

    @PostMapping("/ajoutFideliter")
    public ResponseEntity<Fideliter> ajouterFideliter(@RequestBody Fideliter fideliter) {
        Fideliter savedFideliter = fideliterService.ajouterFideliter(fideliter);
        return ResponseEntity.ok(savedFideliter);
    }

    @DeleteMapping("/suppFideliter/{id}")
    public ResponseEntity<String> supprimerFideliter(@PathVariable Long id) {
        fideliterService.supprimerFideliter(id);
        return ResponseEntity.ok("Fideliter supprimer avec succes !!!");
    }

    @GetMapping("/listeFideliter")
    public List<Fideliter> listerFideliter() {
        return fideliterService.listerFideliter();
    }

    @PostMapping("/modifierFideliter/{{id}}")
    public Fideliter modifierFideliter(@PathVariable Long id, @RequestBody int newPoint){
        return fideliterService.modifierFideliter(id,newPoint);
    }
}
