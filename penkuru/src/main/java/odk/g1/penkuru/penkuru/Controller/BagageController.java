package odk.g1.penkuru.penkuru.Controller;

import lombok.Data;
import odk.g1.penkuru.penkuru.Models.Bagage;
import odk.g1.penkuru.penkuru.Services.BagageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/bagage")
public class BagageController {
    private final BagageService bagageService;
    @PostMapping("/enregistrerBagage")
    public Bagage creerBagage(Bagage bagage){
        return bagageService.creer(bagage);
    }
    @GetMapping("/listeBagage")
    public List<Bagage> listBagage(){
        return bagageService.afficher();

    }
    @PutMapping("/modifierBagage")
    public Bagage modifBag(Long id,Bagage bagage){
        return bagageService.modifier(id,bagage);
    }
    @DeleteMapping("/supprimerBagage")
    public String supprBag(Long id){
        return bagageService.supprimer(id);
    }


}
