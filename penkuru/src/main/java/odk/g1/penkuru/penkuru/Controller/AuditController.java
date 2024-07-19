package odk.g1.penkuru.penkuru.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.Audit;
import odk.g1.penkuru.penkuru.Services.AuditService;

@RestController
@RequestMapping("/Audit")
@AllArgsConstructor
public class AuditController {
    private final AuditService auditService;

    @PostMapping("/action")
    public ResponseEntity<Void> action(@RequestBody String utilisateur, @RequestBody String action, @RequestBody String liens){
        auditService.actionUtilisateur(utilisateur, action, liens);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<Audit>> recuperationAudit(){
        List<Audit> audits = auditService.recuperationAudit();
        return ResponseEntity.ok(audits);
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<List<Audit>> getAuditsByUsername(@PathVariable String username) {
        List<Audit> audits = auditService.recuperationUtilisateur(username);
        return ResponseEntity.ok(audits);
    }
}
