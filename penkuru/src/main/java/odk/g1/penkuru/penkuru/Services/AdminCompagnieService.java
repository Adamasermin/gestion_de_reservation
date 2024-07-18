package odk.g1.penkuru.penkuru.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.AdminCompagnie;
import odk.g1.penkuru.penkuru.Repository.AdminCompagnieRepository;

@Service
@AllArgsConstructor
public class AdminCompagnieService {
    private final AdminCompagnieRepository adminCompagnieRepository;

    
    public AdminCompagnie creer(AdminCompagnie adminCompagnie) {
        return adminCompagnieRepository.save(adminCompagnie);
    }

    
    public AdminCompagnie modifier(Long id, AdminCompagnie adminCompagnie) {
        Optional<AdminCompagnie> optionalAdminCompagnie = adminCompagnieRepository.findById(id);
        if (optionalAdminCompagnie.isPresent()) {
            AdminCompagnie adminCompagnieAModifier = optionalAdminCompagnie.get();
            adminCompagnieAModifier.setNom(adminCompagnie.getNom());
            adminCompagnieAModifier.setPrenom(adminCompagnie.getPrenom());
            adminCompagnieAModifier.setEmail(adminCompagnie.getEmail());
            adminCompagnieAModifier.setTel(adminCompagnie.getTel()); 
            return adminCompagnieRepository.save(adminCompagnieAModifier);
        } else {
            return null;
        }
    }

    
    public String supprimer(Long id) {
        adminCompagnieRepository.deleteById(id);
        return "Admin supprimé avec succès";
    }

    
    public List<AdminCompagnie> afficher() {
       return adminCompagnieRepository.findAll();
    }
}
