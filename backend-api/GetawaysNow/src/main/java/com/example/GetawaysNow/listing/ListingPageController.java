package com.example.GetawaysNow.listing;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.GetawaysNow.Profile.Profile;
import com.example.GetawaysNow.listingImages.ListingImages;
import com.example.GetawaysNow.listingImages.ListingImagesService;


@Controller
@RequestMapping("/") 
public class ListingPageController {

    private final ListingService listingService;
    private final ListingImagesService listingImagesService;

    public ListingPageController(ListingService listingService, ListingImagesService listingImagesService) {
        this.listingService = listingService;
        this.listingImagesService = listingImagesService;
    }

    /*--------------------------------------------------------------
     VIEW LISTING PAGE
     URL: /listing/{id}
    --------------------------------------------------------------*/
    @GetMapping("/listing/{id}")
    public String viewListing(@PathVariable Long id, Model model) {
        
        // if listing is not passed in we get a 404 error
        Listing listing = listingService.getListingById(id);
        if (listing == null) {
            return "error/404";
        }

        // retrives the list of images associated with the listing
        List<ListingImages> images = listingImagesService.getListingImagesByListing(id);

        // grabs and displays listing details and images
        model.addAttribute("listing", listing);
        model.addAttribute("images", images);

        return "view_listing";
    }

    /*--------------------------------------------------------------
     CREATE LISTING FORM
     URL: /listing/create
     creates the default listing record before saving the attributes
    --------------------------------------------------------------*/
    @GetMapping("/listing/create")
    public String createListingForm(Model model) {
        model.addAttribute("listing", new Listing());
        return "create_listing";
    }

    /*--------------------------------------------------------------
     CREATE LISTING SUBMIT (POST)
     URL: /listing/create

    --------------------------------------------------------------*/
    @PostMapping("/listing/create")
    public String createListingSubmit(
            @ModelAttribute Listing listing,
            @RequestParam(value = "images", required = false) MultipartFile[] images,
            Model model
    ) {

    try {
        // TEMP USER — replace later with session/auth 
        Profile dummyProfile = new Profile();
        dummyProfile.setProfileId(4L);
        listing.setProfile(dummyProfile);

        //checks if we already have a record with that address and city this is an error and should get handled
         if (listingService.existsByAddressAndCity(listing.getAddress(), listing.getCity())) {

            model.addAttribute("listing", listing);
            model.addAttribute("errorMessage", 
                "A listing already exists at this address in this city.");

            return "create_listing";
        }

        // create listing 
        listingService.addListing(listing);

        // if images we have images we want to save them assoicated with the listing
        // for each image we create a record
        if (images != null) {
            for (MultipartFile file : images) {
                if (!file.isEmpty()) {
                    listingImagesService.saveImageFile(listing, file);
                }
            }
        }

        return "redirect:/listing/" + listing.getId();

    } catch (Exception e) {
        e.printStackTrace();
        return "redirect:/error";
    }
}




    /*--------------------------------------------------------------
     EDIT LISTING FORM
     URL: /listing/{id}/edit
    --------------------------------------------------------------*/
    @GetMapping("/listing/{id}/edit")
    public String editListingForm(@PathVariable Long id, Model model) {

        Listing listing = listingService.getListingById(id);
        List<ListingImages> images = listingImagesService.getListingImagesByListing(id);

        model.addAttribute("listing", listing);
        model.addAttribute("images", images);

        return "edit_listing";
    }

    /*--------------------------------------------------------------
    EDIT LISTING SUBMIT (POST)
    URL: /listing/{id}/edit
    --------------------------------------------------------------*/
    @PostMapping("/listing/{id}/edit")
    public String editListingSubmit(
            @PathVariable Long id,
            @ModelAttribute Listing listing,
            @RequestParam(value = "images", required = false) MultipartFile[] newImages,
            @RequestParam(value = "deleteImages", required = false) List<Long> deleteImages
    ) {

        Listing existing = listingService.getListingById(id);
        listing.setProfile(existing.getProfileID());
        listingService.updateListing(id, listing);

        if (deleteImages != null) {
            deleteImages.forEach(listingImagesService::deleteListingImages);
        }

        if (newImages != null) {
            for (MultipartFile file : newImages) {
                if (!file.isEmpty()) {
                    listingImagesService.saveImageFile(listing, file);
                }
            }
        }

        return "redirect:/listing/" + id;
    }



    /*--------------------------------------------------------------
     PROVIDER'S LISTINGS
     URL: /profile/{profileID}/listings
    --------------------------------------------------------------*/
    @GetMapping("/profile/{profileID}/listings")
    public String myListings(@PathVariable Long profileID, Model model) {

        List<Listing> listings = listingService.getListingsByProfile(profileID);

        model.addAttribute("listings", listings);
        model.addAttribute("profileID", profileID);

        return "my_listings";
    }
}
