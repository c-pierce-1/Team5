package com.example.GetawaysNow.listingImages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.GetawaysNow.listing.Listing;
import com.example.GetawaysNow.listing.ListingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ListingImagesService {

    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    @Autowired
    private ListingImagesRepository listingImagesRepository;

    @Autowired
    private ListingRepository listingRepository;


    public List<ListingImages> getAllListingImages() {
        return listingImagesRepository.findAll();
    }

    public ListingImages getListingImagesById(long listingImagesId) {
        return listingImagesRepository.findById(listingImagesId).orElse(null);
    }

    public List<ListingImages> getListingImagesByListing(Long listingId) {
        Listing listing = listingRepository.findById(listingId)
                .orElseThrow(() -> new RuntimeException("Listing not found with id: " + listingId));

        return listingImagesRepository.findBylistingID(listing);
    }

    public ListingImages addListingImages(ListingImages listingImages) {

        Listing listingFromRequest = listingImages.getListingID();

        if (listingFromRequest == null || listingFromRequest.getId() == null) {
            throw new IllegalArgumentException("ListingImages must include a valid listingID");
        }

        Long listingId = listingFromRequest.getId();

        Listing listing = listingRepository.findById(listingId)
                .orElseThrow(() -> new RuntimeException("Listing not found with id: " + listingId));

        listingImages.setListing(listing);

        return listingImagesRepository.save(listingImages);
    }

    public ListingImages updateListingImages(Long listingImagesId, ListingImages listingImages) {
        return listingImagesRepository.save(listingImages);
    }

    public void deleteListingImages(Long listingImagesId) {
        listingImagesRepository.deleteById(listingImagesId);
    }


    /** --------------- NEW FILE SAVE LOGIC ---------------- **/
    public ListingImages saveImageFile(Listing listing, MultipartFile file) {

        try {
            // Ensure folder exists
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            // Create a unique filename
            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            Path filepath = Paths.get(UPLOAD_DIR, filename);

            // Write file
            Files.write(filepath, file.getBytes());

            // Save DB record
            ListingImages image = new ListingImages();
            image.setListing(listing);
            image.setImagePath("/" + UPLOAD_DIR + filename);   // IMPORTANT so <img> can load it

            return listingImagesRepository.save(image);

        } catch (IOException e) {
            throw new RuntimeException("Failed to save image file", e);
        }
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
