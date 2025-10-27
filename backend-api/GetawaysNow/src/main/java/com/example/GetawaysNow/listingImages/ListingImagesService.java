package com.example.GetawaysNow.listingImages;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ListingImagesService {

  @Autowired
  private ListingImagesRepository ListingImagesRepository;

  /**
   * Method to get all ListingImagess
   *
   * @return List of all ListingImagess
   */
  public Object getAllListingImagess() {
    return ListingImagesRepository.findAll();
  }

  /**
   * Method to get a ListingImages by ID
   *
   * @param ListingImagesId The ID of the ListingImages to retrieve
   * @return The ListingImages with the specified ID
   */
  public ListingImages getListingImagesById(@PathVariable long ListingImagesId) {
    return ListingImagesRepository.findById(ListingImagesId).orElse(null);
  }




  /**
   * Method to add a new ListingImages
   *
   * @param ListingImages The ListingImages to add
   */
  public ListingImages addListingImages(ListingImages ListingImages) {
    return ListingImagesRepository.save(ListingImages);
  }

  /**
   * Method to update a ListingImages
   *
   * @param ListingImagesId The ID of the ListingImages to update
   * @param ListingImages   The updated ListingImages information
   */
  public ListingImages updateListingImages(Long ListingImagesId, ListingImages ListingImages) {
    return ListingImagesRepository.save(ListingImages);
  }

  /**
   * Method to delete a ListingImages
   *
   * @param ListingImagesId The ID of the ListingImages to delete
   */
  public void deleteListingImages(Long ListingImagesId) {
    ListingImagesRepository.deleteById(ListingImagesId);
  }

  /**
   * Method to write a ListingImages object to a JSON file
   *
   * @param ListingImages The ListingImages object to write
   */
  public String writeJson(ListingImages ListingImages) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.writeValue(new File("ListingImagess.json"), ListingImages);
      return "ListingImages written to JSON file successfully";
    } catch (IOException e) {
      e.printStackTrace();
      return "Error writing ListingImages to JSON file";
    }

  }

  /**
   * Method to read a ListingImages object from a JSON file
   *
   * @return The ListingImages object read from the JSON file
   */
  public Object readJson() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File("ListingImagess.json"), ListingImages.class);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }

  }

}