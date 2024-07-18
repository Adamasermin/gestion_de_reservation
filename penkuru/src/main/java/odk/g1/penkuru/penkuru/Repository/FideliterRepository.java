package odk.g1.penkuru.penkuru.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import odk.g1.penkuru.penkuru.Models.Fideliter;

public interface FideliterRepository extends JpaRepository<Fideliter, Long>{

    Fideliter delete(Long idFideliter);
}
