package com.example.GetawaysNow.listing;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.GetawaysNow.Profile.Profile;
import com.example.GetawaysNow.listingImages.ListingImages;
import com.example.GetawaysNow.listingImages.ListingImagesService;

@Controller
@RequestMapping("/")   // Clean root URLs
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

        Listing listing = listingService.getListingById(id);
        if (listing == null) {
            return "error/404";
        }

        List<ListingImages> images = listingImagesService.getListingImagesByListing(id);

        model.addAttribute("listing", listing);
        model.addAttribute("images", images);

        return "view_listing";
    }

    /*--------------------------------------------------------------
     CREATE LISTING FORM
     URL: /listing/create
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
    public String createListingSubmit(@ModelAttribute Listing listing) {

        // TODO: Replace with actual logged-in user
        Profile dummyProfile = new Profile();
        dummyProfile.setProfileId(4L);
        listing.setProfile(dummyProfile);

        listingService.addListing(listing);

        return "redirect:/listing/" + listing.getId();
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
    public String editListingSubmit(@PathVariable Long id, @ModelAttribute Listing listing) {

        Listing original = listingService.getListingById(id);
        listing.setProfile(original.getProfileID());

        listingService.updateListing(id, listing);

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
