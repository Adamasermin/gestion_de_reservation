package odk.g1.penkuru.penkuru.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import odk.g1.penkuru.penkuru.Models.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{
    
}
