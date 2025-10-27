package com.example.GetawaysNow.listing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ListingController {
    @Autowired
  private ListingService ListingService;

  /**
   * Endpoint to get all Listings
   *
   * @return List of all Listings
   */
  @GetMapping("/Listings")
  public Object getAllListings() {
    return ListingService.getAllListings();
  }


  /**
   * Endpoint to get a Listing by ID
   *
   * @param id The ID of the Listing to retrieve
   * @return The Listing with the specified ID
   */
  @GetMapping("/Listings/{id}")
  public Listing getListingById(@PathVariable long id) {
    return ListingService.getListingById(id);
  }

  /**
   * Endpoint to get Listings by address
   *
   * @param address The address of the Listing to search for
   * @return List of Listings with the specified address
   */
  @GetMapping("/Listings/search/address/{address}")
  public Object getListingsByAddress(@RequestParam String address) {
    if (address != null) {
      return ListingService.getListingsByAddress(address);
    } else {
      return ListingService.getAllListings();
    }

  }

   /**
   * Endpoint to get Listings by city
   *
   * @param city The city of the Listing to search for
   * @return List of Listings with the specified city
   */
  @GetMapping("/Listings/search/city/{city}")
  public Object getListingsByCity(@RequestParam String city) {
    if (city != null) {
      return ListingService.getListingsByCity(city);
    } else {
      return ListingService.getAllListings();
    }

  }
  
    /**
   * Endpoint to add a new Listing
   *
   * @param Listing The Listing to add
   * @return List of all Listings
   */
  @PostMapping("/Listings")
  public Object addListing(@RequestBody Listing Listing) {
    return ListingService.addListing(Listing);
  }

  /**
   * Endpoint to update a Listing
   *
   * @param id      The ID of the Listing to update
   * @param Listing The updated Listing information
   * @return The updated Listing
   */
  @PutMapping("/Listings/{id}")
  public Listing updateListing(@PathVariable Long id, @RequestBody Listing Listing) {
    ListingService.updateListing(id, Listing);
    return ListingService.getListingById(id);
  }

  /**
   * Endpoint to delete a Listing
   *
   * @param id The ID of the Listing to delete
   * @return List of all Listings
   */
  @DeleteMapping("/Listings/{id}")
  public Object deleteListing(@PathVariable Long id) {
    ListingService.deleteListing(id);
    return ListingService.getAllListings();
  }

  /**
   * Endpoint to write a Listing to a JSON file
   *
   * @param Listing The Listing to write
   * @return An empty string indicating success
   */
  @PostMapping("/Listings/writeFile")
  public Object writeJson(@RequestBody Listing Listing) {
    return ListingService.writeJson(Listing);
  }

  /**
   * Endpoint to read a JSON file and return its contents
   *
   * @return The contents of the JSON file
   */
  @GetMapping("/Listings/readFile")
  public Object readJson() {
    return ListingService.readJson();

  }
    
}
