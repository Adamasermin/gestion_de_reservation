package odk.g1.penkuru.penkuru.Controller;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Models.Admin;
import odk.g1.penkuru.penkuru.Services.AdminService;
import odk.g1.penkuru.penkuru.dto.AuthenticationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/login")
public class LoginController {

    private AuthenticationManager authenticationManager;
    private AdminService adminService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "connexion")
    public ResponseEntity<?> connexion(@RequestBody AuthenticationDTO authenticationDTO) {
        try {
            final Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationDTO.username(), authenticationDTO.password())
            );
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            Admin userDetails = (Admin) authenticate.getPrincipal();
            // Créez une map pour contenir les détails de l'utilisateur
            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("id", userDetails.getId());
            userInfo.put("username", userDetails.getUsername());
            userInfo.put("roles", userDetails.getRole());

            return ResponseEntity.ok(userInfo);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalide username ou password");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "User déconnecter avec succéss");
        return ResponseEntity.ok(response);
    }

}
