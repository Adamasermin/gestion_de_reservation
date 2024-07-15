package odk.g1.penkuru.penkuru.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.Admin;
import odk.g1.penkuru.penkuru.Repository.AdminRepository;

@Service
@AllArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public Admin creer(Admin admin) {
        return adminRepository.save(admin);
    }

    
    public Admin modifier(Long id, Admin admin) {
        Optional<Admin> optionalAdmin= adminRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            Admin adminAModifier = optionalAdmin.get();
            adminAModifier.setNom(admin.getNom());
            adminAModifier.setPrenom(admin.getPrenom());
            adminAModifier.setEmail(admin.getEmail());
            adminAModifier.setTel(admin.getTel()); 
            return adminRepository.save(adminAModifier);
        } else {
            return null;
        }
    }

    
    public String supprimer(Long id) {
        adminRepository.deleteById(id);
        return "Admin supprimé avec succès";
    }

    
    public List<Admin> afficher() {
       return adminRepository.findAll();
    }
}
