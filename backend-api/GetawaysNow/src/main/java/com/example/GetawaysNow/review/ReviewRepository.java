package com.example.GetawaysNow.review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GetawaysNow.listing.Listing;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findBylistingID(Listing listing);

}
