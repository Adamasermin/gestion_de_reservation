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
import odk.g1.penkuru.penkuru.Models.Admin;
import odk.g1.penkuru.penkuru.Services.AdminService;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/creer")
    public Admin create(@RequestBody Admin admin){
        return adminService.creer(admin);
    }

    @GetMapping("/afficher")
    public List<Admin> afficher(){
        return adminService.afficher();
    }

    @PutMapping("/modifier/{id}")
    public Admin modifier(@PathVariable Long id, @RequestBody Admin admin){
        return adminService.modifier(id, admin);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return adminService.supprimer(id);
    }
}
