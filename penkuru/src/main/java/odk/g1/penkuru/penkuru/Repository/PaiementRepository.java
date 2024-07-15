package odk.g1.penkuru.penkuru.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import odk.g1.penkuru.penkuru.Models.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long>{
    
}
