package com.example.GetawaysNow.listing;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.GetawaysNow.Profile.Profile;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {

    @Query(value = "select * from listing s where s.name like '%' || ?1 || '%' ", nativeQuery = true)
    List<Listing> getListingsByName(String name);

    @Query(value = "select * from listing s where s.address like '%' || ?1 || '%' ", nativeQuery = true)
    List<Listing> getListingsByAddress(String address);

    @Query(value = "select * from listing s where s.city like '%' || ?1 || '%' ", nativeQuery = true)
    List<Listing> getListingsByCity(String city);

    List<Listing> findByProfileID(Profile profileID);
    
   @Query("""
    SELECT l FROM Listing l
    WHERE
    (:keyword IS NULL OR 
        LOWER(l.name) LIKE LOWER(CONCAT('%', CAST(:keyword AS string), '%')) OR
        LOWER(l.description) LIKE LOWER(CONCAT('%', CAST(:keyword AS string), '%')))
    AND
    (:city IS NULL OR 
        LOWER(l.city) LIKE LOWER(CONCAT('%', CAST(:city AS string), '%')))
    AND
    (:minPrice IS NULL OR l.pricePerNight >= :minPrice)
    AND
    (:maxPrice IS NULL OR l.pricePerNight <= :maxPrice)
    """)

    List<Listing> search(
            @Param("keyword") String keyword,
            @Param("city") String city,
            @Param("minPrice") Float minPrice,
            @Param("maxPrice") Float maxPrice
    );


    boolean existsByAddressAndCity(String address, String city);



}

