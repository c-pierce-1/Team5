package com.example.GetawaysNow.review;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GetawaysNow.Profile.Profile;
import com.example.GetawaysNow.listing.Listing;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(Listing listing, Profile profile, String comment) {
        Review r = new Review();
        r.setListing(listing);
        r.setProfile(profile);
        r.setComment(comment);
        return reviewRepository.save(r);
    }

    public Review replyToReview(Long parentId, Listing listing, Profile profile, String comment) {
        Review parent = reviewRepository.findById(parentId).orElseThrow();
        Review r = new Review();
        r.setListing(listing);
        r.setProfile(profile);
        r.setComment(comment);
        r.setParentReview(parent);
        return reviewRepository.save(r);
    }

    public List<Review> getTopLevelReviews(Listing listing) {
        return reviewRepository.findByListingIDAndParentReviewIsNull(listing);
    }

    public List<Review> getReplies(Long reviewId) {
        Review parent = reviewRepository.findById(reviewId).orElseThrow();
        return reviewRepository.findByParentReview(parent);
    }
}
