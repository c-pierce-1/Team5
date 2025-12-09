package com.example.GetawaysNow.listing;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GetawaysNow.Profile.Profile;
import com.example.GetawaysNow.Profile.ProfileRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private ProfileRepository profileRepository;

    /**
     * Returns no listings on initial page load.
     */
    public List<Listing> findAllListings() {
        return List.of();  // <-- return empty list instead of hitting DB
    }

    public Listing getListingById(long id) {
        return listingRepository.findById(id).orElse(null);
    }

    public List<Listing> getListingsByAddress(String address) {
        return listingRepository.getListingsByAddress(address);
    }

    public List<Listing> getListingsByName(String name) {
        return listingRepository.getListingsByName(name);
    }

    public List<Listing> getListingsByCity(String city) {
        return listingRepository.getListingsByCity(city);
    }

    public List<Listing> getListingsByProfile(Long profileId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found with id: " + profileId));

        return listingRepository.findByProfileID(profile);
    }

    /**
     * Add listing with validated profile.
     */
    public Listing addListing(Listing listing) {

        if (listing.getProfileID() == null || listing.getProfileID().getProfileId() == null) {
            throw new IllegalArgumentException("Listing must include a valid Profile ID");
        }

        Long profileId = listing.getProfileID().getProfileId();

        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found with id: " + profileId));

        listing.setProfile(profile);

        return listingRepository.save(listing);
    }

    public Listing updateListing(Long id, Listing listing) {
        return listingRepository.save(listing);
    }

    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }

    public String writeJson(Listing listing) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("Listings.json"), listing);
            return "Listing written to JSON file successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error writing Listing to JSON file";
        }
    }

    public Object readJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("Listings.json"), Listing.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Updated search method — handles nulls safely to avoid PostgreSQL LOWER(BYTEA) error.
     */
    public List<Listing> search(String keyword, String city, Float minPrice, Float maxPrice) {

        // Normalize inputs
        keyword = (keyword == null || keyword.isBlank()) ? null : keyword.trim();
        city = (city == null || city.isBlank()) ? null : city.trim();

        return listingRepository.search(
                keyword,
                city,
                minPrice,
                maxPrice
        );
    }

    public boolean existsByAddressAndCity(String address, String city) {
    return listingRepository.existsByAddressAndCity(address, city);
}

}
