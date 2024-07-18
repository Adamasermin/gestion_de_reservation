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
import odk.g1.penkuru.penkuru.Models.CompagnieAerienne;
import odk.g1.penkuru.penkuru.Services.CompagnieService;

@RestController
@RequestMapping("/compagnie")
@AllArgsConstructor
public class CompagnieController {
    private final CompagnieService compagnieService;

    @PostMapping("/creer")
    public CompagnieAerienne create(@RequestBody CompagnieAerienne compagnieAerienne){
        return compagnieService.creer(compagnieAerienne);
    }

    @GetMapping("/afficher")
    public List<CompagnieAerienne> afficher(){
        return compagnieService.afficher();
    }

    @PutMapping("/modifier/{id}")
    public CompagnieAerienne modifier(@PathVariable Long id, @RequestBody CompagnieAerienne compagnieAerienne){
        return compagnieService.modifier(id, compagnieAerienne);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return compagnieService.supprimer(id);
    }
}
