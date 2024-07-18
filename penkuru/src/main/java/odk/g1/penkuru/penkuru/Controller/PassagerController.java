package odk.g1.penkuru.penkuru.Controller;

import odk.g1.penkuru.penkuru.Models.Passager;
import odk.g1.penkuru.penkuru.Services.PassagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passager")
public class PassagerController {
    @Autowired
    PassagerService passagerService;
    @PostMapping("/ajoutPassager")
    public ResponseEntity<Passager> ajouterPassager(@RequestBody Passager passager) {
        Passager savedPassager = passagerService.ajouterPassager(passager);
        return ResponseEntity.ok(savedPassager);
    }

    @DeleteMapping("/suppPassager/{id}")
    public ResponseEntity<String> supprimerPassager(@PathVariable Long id) {
        passagerService.supprimerPassager(id);
        return ResponseEntity.ok("Passager supprimer avec succes !!!");
    }

    @GetMapping("/listePassager")
    public List<Passager> listerPassager() {
        return passagerService.listerPassager();
    }

    @PostMapping("/modifierPassager/{id}")
    public Passager modifierPassager(@PathVariable Long id, @RequestBody Passager newInfoPassager){
        return passagerService.modifierPassager(id,newInfoPassager);
    }
    
}
