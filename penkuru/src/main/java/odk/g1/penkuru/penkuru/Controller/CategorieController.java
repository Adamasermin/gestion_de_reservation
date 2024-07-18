package odk.g1.penkuru.penkuru.Controller;

import odk.g1.penkuru.penkuru.Models.Categorie;
import odk.g1.penkuru.penkuru.Services.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/categorie")
public class CategorieController {
    CategorieService categorieService;
    @PostMapping("/AjouterCategorie")
    public Categorie creer(Categorie categorie){
        return categorieService.creer(categorie);
    }
    @GetMapping("/listeCategorie")
    public List<Categorie> lire(){
        return categorieService.lire();
    }
    @PutMapping("/modifierCategorie")
    public Categorie modif(Long id,Categorie categorie){
        return categorieService.modifier(id,categorie);
    }
    @DeleteMapping("/supprimerCategorie")
    public String suppr(Long id){
        return categorieService.supp(id);
    }
    
}
