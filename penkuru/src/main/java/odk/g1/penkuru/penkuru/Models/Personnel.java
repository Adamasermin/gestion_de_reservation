package odk.g1.penkuru.penkuru.Models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Personnel")
@Data
@NoArgsConstructor
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private Date date_embauche;
    private String poste;
    private String tel;
    private String experience;
    private String status;
    private String nationalite;
    private String adresse;

    @ManyToOne
    private CompagnieAerienne compagnieAerienne;
}
