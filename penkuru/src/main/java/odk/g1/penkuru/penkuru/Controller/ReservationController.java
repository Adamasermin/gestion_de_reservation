package odk.g1.penkuru.penkuru.Controller;

import odk.g1.penkuru.penkuru.Models.Reservation;
import odk.g1.penkuru.penkuru.Services.ReservationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("reservation")
public class ReservationController {
    ReservationService reservationService;
    public Reservation creerReservation(Reservation reservation){
        return reservationService.creer(reservation);
    }
    public List<Reservation> listRes(){
        return reservationService.lire();
    }
    public Reservation modif(Long id,Reservation reservation){
        return reservationService.modifier(id,reservation);
    }
    public String supp(Long id){
        return reservationService.supprimer(id);
    }
    
}
