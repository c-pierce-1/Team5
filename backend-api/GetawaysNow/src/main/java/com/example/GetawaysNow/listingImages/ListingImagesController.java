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
  private ListingImagesController ListingImagesController;

  /**
   * Endpoint to get all ListingImagess
   *
   * @return List of all ListingImagess
   */
  @GetMapping("/ListingImagess")
  public Object getAllListingImagess() {
    return ListingImagesService.getAllListingImagess();
  }


  /**
   * Endpoint to get a ListingImages by ID
   *
   * @param id The ID of the ListingImages to retrieve
   * @return The ListingImages with the specified ID
   */
  @GetMapping("/ListingImagess/{id}")
  public ListingImages getListingImagesByListingId(@PathVariable long id) {
    return ListingImagesService.getListingImagesById(id);
  }


  
    /**
   * Endpoint to add a new ListingImages
   *
   * @param ListingImages The ListingImages to add
   * @return List of all ListingImagess
   */
  @PostMapping("/ListingImagess")
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
  @PutMapping("/ListingImagess/{id}")
  public ListingImages updateListingImages(@PathVariable Long id, @RequestBody ListingImages ListingImages) {
    ListingImagesService.updateListingImages(id, ListingImages);
    return ListingImagesService.getListingImagesById(id);
  }

  /**
   * Endpoint to delete a ListingImages
   *
   * @param id The ID of the ListingImages to delete
   * @return List of all ListingImagess
   */
  @DeleteMapping("/ListingImagess/{id}")
  public Object deleteListingImages(@PathVariable Long id) {
    ListingImagesService.deleteListingImages(id);
    return ListingImagesService.getAllListingImagess();
  }

  /**
   * Endpoint to write a ListingImages to a JSON file
   *
   * @param ListingImages The ListingImages to write
   * @return An empty string indicating success
   */
  @PostMapping("/ListingImagess/writeFile")
  public Object writeJson(@RequestBody ListingImages ListingImages) {
    return ListingImagesService.writeJson(ListingImages);
  }

  /**
   * Endpoint to read a JSON file and return its contents
   *
   * @return The contents of the JSON file
   */
  @GetMapping("/ListingImagess/readFile")
  public Object readJson() {
    return ListingImagesService.readJson();

  }
    
}
