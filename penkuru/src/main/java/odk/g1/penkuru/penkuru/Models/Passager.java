package odk.g1.penkuru.penkuru.Models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Passager")
@Data
@NoArgsConstructor
public class Passager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String tel;
    private Date date_naissance;

    @OneToOne
    private Fideliter fideliter;
    
}
