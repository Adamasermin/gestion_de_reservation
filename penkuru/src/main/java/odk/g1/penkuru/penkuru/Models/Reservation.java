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
@Table(name = "Reservation")
@Data
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date_reservation;
    private int nbre_passager;
    private String statut;

    @ManyToOne
    private Passager passager;

    @ManyToOne
    private Paiement paiement;

    @ManyToOne
    private Vol vol;
}
