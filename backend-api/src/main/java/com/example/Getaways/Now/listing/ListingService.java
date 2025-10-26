package com.example.Getaways.Now.listing;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ListingService {

  @Autowired
  private ListingRepository ListingRepository;

  /**
   * Method to get all Listings
   *
   * @return List of all Listings
   */
  public Object getAllListings() {
    return ListingRepository.findAll();
  }

  /**
   * Method to get a Listing by ID
   *
   * @param ListingId The ID of the Listing to retrieve
   * @return The Listing with the specified ID
   */
  public Listing getListingById(@PathVariable long ListingId) {
    return ListingRepository.findById(ListingId).orElse(null);
  }

   /**
   * Method to get Listings by address
   *
   * @param address The address of the Listing to search for
   * @return List of Listings with the specified address
   */
  public Object getListingsByAddress(String address) {
    return ListingRepository.getListingsByAddress(address);
  }


    /**
   * Method to get Listings by name
   *
   * @param name The name of the Listing to search for
   * @return List of Listings with the specified name
   */
  public Object getListingsByName(String name) {
    return ListingRepository.getListingsByName(name);
  }


  
    /**
   * Method to get Listings by city
   *
   * @param city The city of the Listing to search for
   * @return List of Listings with the specified city
   */
  public Object getListingsByCity(String city) {
    return ListingRepository.getListingsByCity(city);
  }



  /**
   * Method to add a new Listing
   *
   * @param Listing The Listing to add
   */
  public Listing addListing(Listing Listing) {
    return ListingRepository.save(Listing);
  }

  /**
   * Method to update a Listing
   *
   * @param ListingId The ID of the Listing to update
   * @param Listing   The updated Listing information
   */
  public Listing updateListing(Long ListingId, Listing Listing) {
    return ListingRepository.save(Listing);
  }

  /**
   * Method to delete a Listing
   *
   * @param ListingId The ID of the Listing to delete
   */
  public void deleteListing(Long ListingId) {
    ListingRepository.deleteById(ListingId);
  }

  /**
   * Method to write a Listing object to a JSON file
   *
   * @param Listing The Listing object to write
   */
  public String writeJson(Listing Listing) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.writeValue(new File("Listings.json"), Listing);
      return "Listing written to JSON file successfully";
    } catch (IOException e) {
      e.printStackTrace();
      return "Error writing Listing to JSON file";
    }

  }

  /**
   * Method to read a Listing object from a JSON file
   *
   * @return The Listing object read from the JSON file
   */
  public Object readJson() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File("Listings.json"), Listing.class);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }

  }

}