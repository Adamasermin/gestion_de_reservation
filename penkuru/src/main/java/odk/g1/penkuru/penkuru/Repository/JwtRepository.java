package odk.g1.penkuru.penkuru.Repository;

import odk.g1.penkuru.penkuru.Models.Jwt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.stream.Stream;

public interface JwtRepository extends JpaRepository<Jwt, Long> {

    Optional<Jwt> findByValeurAndDesactiveAndExpire(String valeur, boolean desactive, boolean expire);

    @Query("FROM Jwt j WHERE j.expire = :expire AND j.desactive = :desactive AND j.admin.email = :email")
    Optional<Jwt> findAdminValidToken(String email, boolean desactive, boolean expire);

    @Query("FROM Jwt j WHERE j.admin.email = :email")
    Stream<Jwt> findUtilisateur(String email);

}
