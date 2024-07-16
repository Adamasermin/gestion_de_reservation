package odk.g1.penkuru.penkuru.Services;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.Admin;
import odk.g1.penkuru.penkuru.Models.Validation;
import odk.g1.penkuru.penkuru.Repository.ValidationRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

import static java.time.temporal.ChronoUnit.MINUTES;

@Service
@AllArgsConstructor
public class ValidationService {

    private ValidationRepository validationRepository;
    private NotificationMailService notificationMailService;

    public void enregistrer(Admin admin) {
        Validation validation = new Validation();
        validation.setAdmin(admin);
        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(30, MINUTES);
        validation.setExpiration(expiration);
        Random random = new Random();
        int randomInteger = random.nextInt(999999);
        String code = String.format("%06d", randomInteger);

        validation.setCode(code);
        this.validationRepository.save(validation);
        this.notificationMailService.envoyer(validation);
    }

    public Validation lireEnFonctionDuCode(String code) {
        return (Validation) this.validationRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Votre code est invalide"));
    }
}
