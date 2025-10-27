package com.example.Getaways.Now.listing;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {

    @Query(value = "select * from listing s where s.name like %?1% ", nativeQuery = true)
    List<Listing> getListingsByName(String name);

    @Query(value = "select * from listing s where s.address like %?1% ", nativeQuery = true)
    List<Listing> getListingsByAddress(String address);

    @Query(value = "select * from listing s where s.city like %?1% ", nativeQuery = true)
    List<Listing> getListingsByCity(String city);
    
}

