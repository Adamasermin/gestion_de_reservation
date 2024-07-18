package odk.g1.penkuru.penkuru.Services;

import lombok.Data;
import odk.g1.penkuru.penkuru.Models.Reservation;
import odk.g1.penkuru.penkuru.Repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ReservationService {
    ReservationRepository reservationRepository;
   public Reservation creer(Reservation reservation){
    return reservationRepository.save(reservation);
    }
    public List<Reservation> lire(){
       return reservationRepository.findAll();
    }

    public Reservation modifier(Long id,Reservation reservation){
       return reservationRepository.findById(id)
               .map((r)->{
                   r.setStatut(r.getStatut());
                   r.setDate_reservation(r.getDate_reservation());
                   r.setVol(r.getVol());
                   r.setNbre_passager(r.getNbre_passager());
                   r.setPassager(r.getPassager());
                   return reservationRepository.save(r);
               }).orElseThrow(()->new RuntimeException("reservation non trouvée"));
    }
    public String supprimer(Long id){
       reservationRepository.deleteById(id);
       return "Suppression effectuer";
    }
    
}
