package odk.g1.penkuru.penkuru.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Ville")
@Data
@NoArgsConstructor
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @ManyToOne
    private Pays pays;

    @OneToMany(mappedBy = "ville")
    private List<Aeroport> Aeroport;
}
