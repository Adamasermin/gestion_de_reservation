package odk.g1.penkuru.penkuru.Repository;

import odk.g1.penkuru.penkuru.Models.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValidationRepository extends JpaRepository<Validation, Integer> {
    Optional<Validation> findByCode(String code);
}
