package odk.g1.penkuru.penkuru.Models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    /*@OneToMany(mappedBy = "aeroport")
    private List<Vol> vols;*/
}
