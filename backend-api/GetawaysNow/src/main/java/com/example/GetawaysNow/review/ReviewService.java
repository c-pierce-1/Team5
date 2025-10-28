package com.example.GetawaysNow.review;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.GetawaysNow.Profile.Profile;
import com.example.GetawaysNow.Profile.ProfileRepository;
import com.example.GetawaysNow.listing.Listing;
import com.example.GetawaysNow.listing.ListingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ReviewService {

  @Autowired
  private ReviewRepository ReviewRepository;

  @Autowired
  private ListingRepository listingRepository;

  @Autowired
  private ProfileRepository profileRepository;


  /**
   * Method to get all Reviews
   *
   * @return List of all Reviews
   */
  public Object getAllReviews() {
    return ReviewRepository.findAll();
  }

  /**
   * Method to get a Review by ID
   *
   * @param ReviewId The ID of the Review to retrieve
   * @return The Review with the specified ID
   */
  public Review getReviewById(@PathVariable long ReviewId) {
    return ReviewRepository.findById(ReviewId).orElse(null);
  }


   /**
   * Method to get a Review by ID
   *
   * @param listing_id The ID of the Review to retrieve
   * @return The Review with the specified ID
   */
  public Object getReviewByListing(@PathVariable Listing listing_id) {
    return ReviewRepository.findBylistingID(listing_id);
  }

  /**
   * Method to add a new Review
   *
   * @param Review The Review to add
   */
  public Review addReview(Review review) {
    // Validate & attach Listing
    Listing listingFromRequest = review.getListing();
    if (listingFromRequest == null || listingFromRequest.getId() == null) {
        throw new IllegalArgumentException("Review must include a valid listing ID");
    }

    Listing listing = listingRepository.findById(listingFromRequest.getId())
            .orElseThrow(() -> new RuntimeException("Listing not found with ID: " + listingFromRequest.getId()));
    review.setListing(listing);

    // Validate & attach Profile
    Profile profileFromRequest = review.getProfile();
    if (profileFromRequest == null || profileFromRequest.getProfileId() == null) {
        throw new IllegalArgumentException("Review must include a valid profile ID");
    }

    Profile profile = profileRepository.findById(profileFromRequest.getProfileId())
            .orElseThrow(() -> new RuntimeException("Profile not found with ID: " + profileFromRequest.getProfileId()));
    review.setProfile(profile);

    // Optional: handle parent review if provided
    if (review.getParentReview() != null && review.getParentReview().getId() != null) {
        Review parent = ReviewRepository.findById(review.getParentReview().getId())
                .orElseThrow(() -> new RuntimeException("Parent review not found with ID: " + review.getParentReview().getId()));
        review.setParentReview(parent);
    } else {
        review.setParentReview(null);
    }

    return ReviewRepository.save(review);
}


  /**
   * Method to update a Review
   *
   * @param ReviewId The ID of the Review to update
   * @param Review   The updated Review information
   */
 public Review updateReview(Long reviewId, Review updatedReview) {
    Review existingReview = ReviewRepository.findById(reviewId)
            .orElseThrow(() -> new RuntimeException("Review not found with ID: " + reviewId));

    // Update comment
    if (updatedReview.getComment() != null) {
        existingReview.setComment(updatedReview.getComment());
    }

    // Optional: update parent review
    if (updatedReview.getParentReview() != null && updatedReview.getParentReview().getId() != null) {
        Review parent = ReviewRepository.findById(updatedReview.getParentReview().getId())
                .orElseThrow(() -> new RuntimeException("Parent review not found with ID: " + updatedReview.getParentReview().getId()));
        existingReview.setParentReview(parent);
    } else {
        existingReview.setParentReview(null);
    }

    // Optional: update listing or profile (usually not changed)
    if (updatedReview.getListing() != null && updatedReview.getListing().getId() != null) {
        Listing listing = listingRepository.findById(updatedReview.getListing().getId())
                .orElseThrow(() -> new RuntimeException("Listing not found with ID: " + updatedReview.getListing().getId()));
        existingReview.setListing(listing);
    }

    if (updatedReview.getProfile() != null && updatedReview.getProfile().getProfileId() != null) {
        Profile profile = profileRepository.findById(updatedReview.getProfile().getProfileId())
                .orElseThrow(() -> new RuntimeException("Profile not found with ID: " + updatedReview.getProfile().getProfileId()));
        existingReview.setProfile(profile);
    }

    return ReviewRepository.save(existingReview);
}


  /**
   * Method to delete a Review
   *
   * @param ReviewId The ID of the Review to delete
   */
  public void deleteReview(Long ReviewId) {
    ReviewRepository.deleteById(ReviewId);
  }

  /**
   * Method to write a Review object to a JSON file
   *
   * @param Review The Review object to write
   */
  public String writeJson(Review Review) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.writeValue(new File("Reviews.json"), Review);
      return "Review written to JSON file successfully";
    } catch (IOException e) {
      e.printStackTrace();
      return "Error writing Review to JSON file";
    }

  }

  /**
   * Method to read a Review object from a JSON file
   *
   * @return The Review object read from the JSON file
   */
  public Object readJson() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File("Reviews.json"), Review.class);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }

  }

}