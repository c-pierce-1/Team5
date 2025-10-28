package com.example.GetawaysNow.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReviewController {
    @Autowired
  private ReviewService ReviewService;

  /**
   * Endpoint to get all Reviews
   *
   * @return List of all Reviews
   */
  @GetMapping("/Reviews")
  public Object getAllReviews() {
    return ReviewService.getAllReviews();
  }


  /**
   * Endpoint to get a Review by ID
   *
   * @param id The ID of the Review to retrieve
   * @return The Review with the specified ID
   */
  @GetMapping("/Reviews/{id}")
  public Review getReviewById(@PathVariable long id) {
    return ReviewService.getReviewById(id);
  }

  /**
   * Endpoint to get Reviews by listing
   *
   * @param listing_id The listing_id of the Review to search for
   * @return List of Reviews with the specified address
   */
  @GetMapping("/Reviews/listing_id/{listing_id}")
  public Object getReviewsByListing(@PathVariable Long listing_id) {
    return ReviewService.getReviewByListing(listing_id);

  }


  
    /**
   * Endpoint to add a new Review
   *
   * @param Review The Review to add
   * @return List of all Reviews
   */
  @PostMapping("/Reviews")
  public Object addReview(@RequestBody Review Review) {
    return ReviewService.addReview(Review);
  }

  /**
   * Endpoint to update a Review
   *
   * @param id      The ID of the Review to update
   * @param Review The updated Review information
   * @return The updated Review
   */
  @PutMapping("/Reviews/{id}")
  public Review updateReview(@PathVariable Long id, @RequestBody Review Review) {
    ReviewService.updateReview(id, Review);
    return ReviewService.getReviewById(id);
  }

  /**
   * Endpoint to delete a Review
   *
   * @param id The ID of the Review to delete
   * @return List of all Reviews
   */
  @DeleteMapping("/Reviews/{id}")
  public Object deleteReview(@PathVariable Long id) {
    ReviewService.deleteReview(id);
    return ReviewService.getAllReviews();
  }

  /**
   * Endpoint to write a Review to a JSON file
   *
   * @param Review The Review to write
   * @return An empty string indicating success
   */
  @PostMapping("/Reviews/writeFile")
  public Object writeJson(@RequestBody Review Review) {
    return ReviewService.writeJson(Review);
  }

  /**
   * Endpoint to read a JSON file and return its contents
   *
   * @return The contents of the JSON file
   */
  @GetMapping("/Reviews/readFile")
  public Object readJson() {
    return ReviewService.readJson();

  }
    
}

