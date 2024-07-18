package odk.g1.penkuru.penkuru.Controller;

//import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.Vol;
import odk.g1.penkuru.penkuru.Services.VolService;
//import java.util.List;

@RestController
@RequestMapping("/vol")
@AllArgsConstructor
public class VolController {
    private final VolService volService;

    //@Operation(summary = "Ajouter Vol", description = "Ajouter un Vol")
    @PostMapping("/Ajouter")
    public Vol create(@RequestBody Vol vol){
        return volService.creer(vol);
    }

    //@Operation(summary = "Afficher Vol", description = "Afficher la liste des Vol")
    // @GetMapping("/afficher")
    // public List<Vol> read(){
    //     return volService.lire();
    // }

    //@Operation(summary = "Modifier Vol", description = "Modifier un Vol")
    @PutMapping("/modifier/{id}")
    public Vol remove(@PathVariable Long id, @RequestBody Vol vol){
        return volService.modifier(id, vol);
    }

    //@Operation(summary = "Supprimer Vol", description = "Supprimer un Vol")
    @DeleteMapping("/supprimer/{id}")
    public String delete(@PathVariable Long id){
        return volService.supprimer(id);
    }
}
