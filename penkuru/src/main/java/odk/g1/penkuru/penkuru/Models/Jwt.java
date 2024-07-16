package odk.g1.penkuru.penkuru.Models;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jwt")
public class Jwt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String valeur;
    private boolean desactive;
    private boolean expire;

//    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
//    private RefreshToken refreshToken;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "admin_id")
    private Admin admin;

}
