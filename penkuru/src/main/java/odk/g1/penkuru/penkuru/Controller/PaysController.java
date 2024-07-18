package odk.g1.penkuru.penkuru.Controller;

import odk.g1.penkuru.penkuru.Models.Pays;
import odk.g1.penkuru.penkuru.Services.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pays")
public class PaysController {
    @Autowired
    private PaysService paysService;
    // Endpoint pour recuperer tous les pays
    @GetMapping
    public ResponseEntity<List<Pays>> getAllPays() {
        List<Pays> paysList = paysService.getAllPays();
        return ResponseEntity.ok(paysList);
    }

    // Endpoint pour recuperer un seul pays
    @GetMapping("/{id}")
    public ResponseEntity<Pays> getPayById(@PathVariable Long id) {
        Pays pays = paysService.getPayByID(id);
        if (pays != null) {
            return ResponseEntity.ok(pays);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour creer un nouveau pays
    @PostMapping
    public ResponseEntity<Pays> createPays(@RequestBody Pays pays) {
        Pays createdPays = paysService.savePays(pays);
        return ResponseEntity.ok(createdPays);
    }

    // Endpoint pour modifier un pays
    @PutMapping("/{id}")
    public ResponseEntity<Pays> updatePays(@PathVariable Long id, @RequestBody Pays pays) {
        Pays updatedPays = paysService.updatePays(id, pays);
        if (updatedPays != null) {
            return ResponseEntity.ok(updatedPays);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour supprimer un pays
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePays(@PathVariable Long id) {
        paysService.deletePays(id);
        return ResponseEntity.noContent().build();
    }
    
}
