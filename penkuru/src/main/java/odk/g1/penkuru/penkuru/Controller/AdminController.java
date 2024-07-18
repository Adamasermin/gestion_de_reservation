package odk.g1.penkuru.penkuru.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.Admin;
import odk.g1.penkuru.penkuru.Services.AdminService;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/creer")
    public void create(@RequestBody Admin admin){
        adminService.creer(admin);
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

    @PostMapping(path = "activation")
    public void activation(@RequestBody Map<String, String> activation) {
        this.adminService.activation(activation);
    }
}
