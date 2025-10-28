package com.example.GetawaysNow.review;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.GetawaysNow.listing.Listing;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ReviewService {

  @Autowired
  private ReviewRepository ReviewRepository;

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
    return ReviewRepository.getReviewsByListing(listing_id);
  }

  /**
   * Method to add a new Review
   *
   * @param Review The Review to add
   */
  public Review addReview(Review Review) {
    return ReviewRepository.save(Review);
  }

  /**
   * Method to update a Review
   *
   * @param ReviewId The ID of the Review to update
   * @param Review   The updated Review information
   */
  public Review updateReview(Long ReviewId, Review Review) {
    return ReviewRepository.save(Review);
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