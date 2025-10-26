package com.example.Getaways.Now.listing;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LisitingRepository extends JpaRepository<Listing, Long> {
    List<Listing> findByShippingAddressContaining(String address);
    List<Listing> findByPhoneNumberContaining(String phoneNumber);
    boolean existsByEmail(String email);
    Optional<Listing> findByEmail(String email);
}
