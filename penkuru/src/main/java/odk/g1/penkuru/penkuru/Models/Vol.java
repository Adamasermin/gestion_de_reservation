package odk.g1.penkuru.penkuru.Models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Vol")
@Data
@NoArgsConstructor
public class Vol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ville_depart;
    private String ville_arrive;
    private Date date_depart;
    private Date date_retour;
    private int nbre_de_place_dispo;
    private double tarif; 
}
