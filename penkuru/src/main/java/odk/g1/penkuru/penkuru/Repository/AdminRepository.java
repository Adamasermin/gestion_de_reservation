package odk.g1.penkuru.penkuru.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import odk.g1.penkuru.penkuru.Models.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long>{

    Optional<Admin> findByEmail(String email);
}
