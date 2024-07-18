package odk.g1.penkuru.penkuru.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.Aeroport;
import odk.g1.penkuru.penkuru.Services.AeroportService;

@RestController
@RequestMapping("/aeroport")
@AllArgsConstructor
public class AeroportController {
    private final AeroportService aeroportService;

    @PostMapping("/creer")
    public Aeroport create(@RequestBody Aeroport aeroport){
        return aeroportService.creer(aeroport);
    }

    @GetMapping("/afficher")
    public List<Aeroport> afficher(){
        return aeroportService.afficher();
    }

    @PutMapping("/modifier/{id}")
    public Aeroport modifier(@PathVariable Long id, @RequestBody Aeroport aeroport){
        return aeroportService.modifier(id, aeroport);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return aeroportService.supprimer(id);
    }
}
