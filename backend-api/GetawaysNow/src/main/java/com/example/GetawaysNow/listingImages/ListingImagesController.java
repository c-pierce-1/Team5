package com.example.GetawaysNow.listingImages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ListingImagesController {
    @Autowired
  private ListingImagesService ListingImagesService;

  /**
   * Endpoint to get all ListingImages
   *
   * @return List of all ListingImages
   */
  @GetMapping("/ListingImages")
  public Object getAllListingImages() {
    return ListingImagesService.getAllListingImages();
  }


  /**
   * Endpoint to get a ListingImages by ID
   *
   * @param id The ID of the ListingImages to retrieve
   * @return The ListingImages with the specified ID
   */
  @GetMapping("/ListingImages/{id}")
  public ListingImages getListingImagesByListingId(@PathVariable Long id) {
    return ListingImagesService.getListingImagesById(id);
  }

   /**
   * Endpoint to get Listings by listing id
   *
   * @param listingID The profile of the Listing to search for
   * @return List of Listings with the specified profile
   */
  @GetMapping("/ListingImages/listing/{listingId}")
  public Object getListingImagesByListing(@PathVariable Long listingId) {
    return ListingImagesService.getListingImagesByListing(listingId);
}



  
    /**
   * Endpoint to add a new ListingImages
   *
   * @param ListingImages The ListingImages to add
   * @return List of all ListingImages
   */
  @PostMapping("/ListingImages")
  public Object addListingImages(@RequestBody ListingImages ListingImages) {
    return ListingImagesService.addListingImages(ListingImages);
  }

  /**
   * Endpoint to update a ListingImages
   *
   * @param id      The ID of the ListingImages to update
   * @param ListingImages The updated ListingImages information
   * @return The updated ListingImages
   */
  @PutMapping("/ListingImages/{id}")
  public ListingImages updateListingImages(@PathVariable Long id, @RequestBody ListingImages ListingImages) {
    ListingImagesService.updateListingImages(id, ListingImages);
    return ListingImagesService.getListingImagesById(id);
  }

  /**
   * Endpoint to delete a ListingImages
   *
   * @param id The ID of the ListingImages to delete
   * @return List of all ListingImages
   */
  @DeleteMapping("/ListingImages/{id}")
  public Object deleteListingImages(@PathVariable Long id) {
    ListingImagesService.deleteListingImages(id);
    return ListingImagesService.getAllListingImages();
  }

  /**
   * Endpoint to write a ListingImages to a JSON file
   *
   * @param ListingImages The ListingImages to write
   * @return An empty string indicating success
   */
  @PostMapping("/ListingImages/writeFile")
  public Object writeJson(@RequestBody ListingImages ListingImages) {
    return ListingImagesService.writeJson(ListingImages);
  }

  /**
   * Endpoint to read a JSON file and return its contents
   *
   * @return The contents of the JSON file
   */
  @GetMapping("/ListingImages/readFile")
  public Object readJson() {
    return ListingImagesService.readJson();

  }
    
}
