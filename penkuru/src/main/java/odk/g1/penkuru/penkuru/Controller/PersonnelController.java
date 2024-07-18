package odk.g1.penkuru.penkuru.Controller;

import odk.g1.penkuru.penkuru.Models.Personnel;
import odk.g1.penkuru.penkuru.Services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    PersonnelService personnelService;

    @PostMapping("/ajoutPersonnel")
    public ResponseEntity<Personnel> ajouterPersonnel(@RequestBody Personnel personnel) {
        Personnel savedPersonnel = personnelService.ajouterPersonnel(personnel);
        return ResponseEntity.ok(savedPersonnel);
    }

    @DeleteMapping("/suppPersonnel/{id}")
    public ResponseEntity<String> supprimerPersonnel(@PathVariable Long id) {
        personnelService.supprimerPersonnel(id);
        return ResponseEntity.ok("Personnel supprimer avec succes !!!");
    }

    @GetMapping("/listePersonnel")
    public List<Personnel> listerFormateurs() {
        return personnelService.listerPersonnel();
    }

    @PostMapping("/modifierPersonnel/{{id}}")
    public Personnel modifierPersonnel(@PathVariable Long id, @RequestBody Personnel newInfoPersonnel){
        return personnelService.modifierPersonel(id,newInfoPersonnel);
    }
    
}
