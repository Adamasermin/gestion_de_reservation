package odk.g1.penkuru.penkuru.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CompagnieAerienne")
@Data
@NoArgsConstructor
public class CompagnieAerienne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_compagnie;
    private String description;
    private String password;
    private String adresse;
    private String logo;
}
