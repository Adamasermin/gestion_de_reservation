package odk.g1.penkuru.penkuru.Controller;

import lombok.AllArgsConstructor;
import odk.g1.penkuru.penkuru.Services.AdminService;
import odk.g1.penkuru.penkuru.dto.AuthenticationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private AuthenticationManager authenticationManager;
    private AdminService adminService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "connexion")
    public Map<String, String> connexion(@RequestBody AuthenticationDTO authenticationDTO) {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationDTO.username(), authenticationDTO.password())
        );

       /* if(authenticate.isAuthenticated()) {
            return this.jwtService.generate(authentificationDTO.username());
        }*/
        return null;
    }
}
