package com.example.GetawaysNow.Profile;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    boolean existsByUsername(String username);

    Optional<Profile> findByUsername(String username);
}
