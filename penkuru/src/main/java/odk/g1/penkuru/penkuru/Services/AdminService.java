package odk.g1.penkuru.penkuru.Services;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import odk.g1.penkuru.penkuru.Models.Role;
import odk.g1.penkuru.penkuru.Models.Validation;
import odk.g1.penkuru.penkuru.Repository.RoleRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.Admin;
import odk.g1.penkuru.penkuru.Repository.AdminRepository;

@Service
@AllArgsConstructor
public class AdminService implements UserDetailsService {
    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;
    private final ValidationService validationService;

    public void creer(Admin admin) {

        if(!admin.getEmail().contains("@")) {
            throw  new RuntimeException("Votre mail invalide");
        }
        if(!admin.getEmail().contains(".")) {
            throw  new RuntimeException("Votre mail invalide");
        }

        Optional<Admin> utilisateurOptional = this.adminRepository.findByEmail(admin.getEmail());
        if(utilisateurOptional.isPresent()) {
            throw  new RuntimeException("Votre mail est déjà utilisé");
        }
        String mdpCrypte = this.bCryptPasswordEncoder.encode(admin.getPassword());
        admin.setPassword(mdpCrypte);
        // Récupérer le rôle par son nom (nom)
        String roleName = admin.getRole().getNom();
        Role role = roleRepository.findByNom(roleName);

        if (role == null) {
            throw new IllegalArgumentException("Le rôle spécifié n'existe pas");
        }
        admin.setRole(role);
        admin = this.adminRepository.save(admin);
        this.validationService.enregistrer(admin);
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

    public void activation(Map<String, String> activation) {
        Validation validation = this.validationService.lireEnFonctionDuCode(activation.get("code"));
        if(Instant.now().isAfter(validation.getExpiration())){
            throw  new RuntimeException("Votre code a expiré");
        }
        Admin adminActiver = this.adminRepository.findById(validation.getAdmin().getId()).orElseThrow(() -> new RuntimeException("Utilisateur inconnu"));
        adminActiver.setActif(true);
        this.adminRepository.save(adminActiver);
    }


    public List<Admin> afficher() {
       return adminRepository.findAll();
    }

    @Override
    public Admin loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.adminRepository
                .findByEmail(username)
                .orElseThrow(() -> new  UsernameNotFoundException("Aucun utilisateur ne corespond à cet identifiant"));
    }
}
