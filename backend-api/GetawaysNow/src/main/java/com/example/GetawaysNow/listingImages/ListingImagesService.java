package com.example.GetawaysNow.listingImages;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GetawaysNow.listing.Listing;
import com.example.GetawaysNow.listing.ListingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ListingImagesService {

  @Autowired
  private ListingImagesRepository listingImagesRepository;

  @Autowired
  private ListingRepository listingRepository;

  public Object getAllListingImages() {
    return listingImagesRepository.findAll();
  }

  public ListingImages getListingImagesById(long listingImagesId) {
    return listingImagesRepository.findById(listingImagesId).orElse(null);
  }

public Object getListingImagesByListing(Long listingId) {
    Listing listing = listingRepository.findById(listingId)
        .orElseThrow(() -> new RuntimeException("Listing not found with id: " + listingId));

    return listingImagesRepository.findBylistingID(listing);
}



  public ListingImages addListingImages(ListingImages listingImages) {
    // get the nested listing object from the JSON
    Listing listingFromRequest = listingImages.getListingID();

    if (listingFromRequest == null || listingFromRequest.getId() == null) {
      throw new IllegalArgumentException("ListingImages must include a valid listingID");
    }

    Long listingId = listingFromRequest.getId();

    // fetch managed Listing entity
    Listing listing = listingRepository.findById(listingId)
            .orElseThrow(() -> new RuntimeException("Listing not found with id: " + listingId));

    // attach managed entity
    listingImages.setListing(listing);

    // save
    return listingImagesRepository.save(listingImages);
  }

  public ListingImages updateListingImages(Long listingImagesId, ListingImages listingImages) {
    return listingImagesRepository.save(listingImages);
  }

  public void deleteListingImages(Long listingImagesId) {
    listingImagesRepository.deleteById(listingImagesId);
  }

  public String writeJson(ListingImages listingImages) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.writeValue(new File("ListingImages.json"), listingImages);
      return "ListingImages written to JSON file successfully";
    } catch (IOException e) {
      e.printStackTrace();
      return "Error writing ListingImages to JSON file";
    }
  }

  public Object readJson() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File("ListingImages.json"), ListingImages.class);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
