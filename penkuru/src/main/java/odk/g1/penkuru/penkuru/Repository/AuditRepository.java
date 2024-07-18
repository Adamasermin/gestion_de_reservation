package odk.g1.penkuru.penkuru.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import odk.g1.penkuru.penkuru.Models.Audit;

public interface AuditRepository extends JpaRepository<Audit, Long>{
    List<Audit> findByUser(String username);
}
