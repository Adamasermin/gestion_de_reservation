package odk.g1.penkuru.penkuru.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.Audit;
import odk.g1.penkuru.penkuru.Repository.AuditRepository;

@Service
@AllArgsConstructor
public class AuditService {
    private final AuditRepository auditRepository;

    // Méthode pour enregistrer une action utilisateur
    public void actionUtilisateur(String utilisateur, String action, String liens) {
        Audit audit = new Audit();
        audit.setUtilisateur(utilisateur);
        audit.setAction(action);
        audit.setDateDeConnexion(LocalDateTime.now());
        audit.setLiens(liens);
        auditRepository.save(audit);
    }

    // Méthode pour récupérer tous les enregistrements d'audit
    public List<Audit> recuperationAudit() {
        return auditRepository.findAll();
    }

    // Méthode pour récupérer les enregistrements d'audit par utilisateur
    public List<Audit> recuperationUtilisateur(String utilisateur) {
        return auditRepository.findByUser(utilisateur);
    }
}
