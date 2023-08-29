package com.example.demo.gymuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GymuserRepository extends JpaRepository<Gymuser, Long> {

    @Query("SELECT gu FROM Gymuser gu WHERE gu.email = ?1")
    Optional<Gymuser> findGymuserByEmail(String email);
}
