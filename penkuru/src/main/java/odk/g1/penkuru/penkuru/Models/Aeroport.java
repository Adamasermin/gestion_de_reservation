package odk.g1.penkuru.penkuru.Models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Aeroport")
@Data
@NoArgsConstructor
public class Aeroport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_aeroport;

    @ManyToOne
    private Ville ville;

    @ManyToMany
    private List<Vol> vol;
}
