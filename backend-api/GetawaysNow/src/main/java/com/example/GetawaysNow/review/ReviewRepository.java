package com.example.GetawaysNow.review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.GetawaysNow.listing.Listing;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "select * from review s where s.listing_id = ?1 ", nativeQuery = true)
    List<Review> getReviewsByListing(Listing listing_id);

}
