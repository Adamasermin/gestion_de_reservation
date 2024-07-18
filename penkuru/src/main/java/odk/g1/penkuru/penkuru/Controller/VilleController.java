package odk.g1.penkuru.penkuru.Controller;



import odk.g1.penkuru.penkuru.Models.Ville;
import odk.g1.penkuru.penkuru.Services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/villes")
public class VilleController {

    @Autowired
    private VilleService villeService;

    @GetMapping()
    public ResponseEntity<List<Ville>> getAllVilles() {
        List<Ville> villes = villeService.getVilles();
        return new ResponseEntity<>(villes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ville> getVilleById(@PathVariable Long id) {
        Optional<Ville> ville = villeService.getVille(id);
        return ville.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Ville> createVille(@RequestBody Ville ville) {
        Ville newVille = villeService.addVille(ville);
        return new ResponseEntity<>(newVille, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ville> updateVille(@PathVariable Long id, @RequestBody Ville ville) {
        Optional<Ville> updatedVille = villeService.updateVille(id, ville);
        return updatedVille.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVille(@PathVariable Long id) {
        villeService.deleteVille(id);
        return new ResponseEntity<>("Ville supprimée avec succès", HttpStatus.OK);
    }
}
