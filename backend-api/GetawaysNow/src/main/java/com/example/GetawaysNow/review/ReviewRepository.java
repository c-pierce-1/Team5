package com.example.GetawaysNow.review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GetawaysNow.Profile.Profile;
import com.example.GetawaysNow.listing.Listing;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByListingID(Listing listing);

    List<Review> findByProfileID(Profile profile);

    List<Review> findByListingIDAndParentReviewIsNull(Listing listing);

    List<Review> findByParentReview(Review parentReview);
}
