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
import odk.g1.penkuru.penkuru.Models.AdminCompagnie;
import odk.g1.penkuru.penkuru.Services.AdminCompagnieService;

@RestController
@RequestMapping("/adminCompagnie")
@AllArgsConstructor
public class AdminCompagnieController {
    private final AdminCompagnieService adminCompagnieService;

    @PostMapping("/creer")
    public AdminCompagnie create(@RequestBody AdminCompagnie adminCompagnie){
        return adminCompagnieService.creer(adminCompagnie);
    }

    @GetMapping("/afficher")
    public List<AdminCompagnie> afficher(){
        return adminCompagnieService.afficher();
    }

    @PutMapping("/modifier/{id}")
    public AdminCompagnie modifier(@PathVariable Long id, @RequestBody AdminCompagnie adminCompagnie){
        return adminCompagnieService.modifier(id, adminCompagnie);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return adminCompagnieService.supprimer(id);
    }
}
