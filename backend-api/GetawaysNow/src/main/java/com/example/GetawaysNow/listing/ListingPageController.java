package com.example.GetawaysNow.listing;

import com.example.GetawaysNow.listingImages.ListingImages;
import com.example.GetawaysNow.listingImages.ListingImagesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Listings/page")
public class ListingPageController {

    private final ListingService listingService;
    private final ListingImagesService listingImagesService;

    public ListingPageController(ListingService listingService, ListingImagesService listingImagesService) {
        this.listingService = listingService;
        this.listingImagesService = listingImagesService;
    }

    /** ----------------------------------------------------------------------
     * VIEW LISTING PAGE (DETAIL PAGE)
     * URL: /Listings/page/{id}
     * -------------------------------------------------------------------- */
    @GetMapping("/{id}")
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



    /** ----------------------------------------------------------------------
     * CREATE LISTING FORM (Future: Pull profile from logged-in user)
     * URL: /Listings/page/create
     * -------------------------------------------------------------------- */
    @GetMapping("/create")
    public String createListingForm(Model model) {
        model.addAttribute("listing", new Listing());
        return "create_listing";
    }


    /** ----------------------------------------------------------------------
     * EDIT LISTING FORM
     * URL: /Listings/page/edit/{id}
     * -------------------------------------------------------------------- */
    @GetMapping("/edit/{id}")
    public String editListingForm(@PathVariable Long id, Model model) {

        Listing listing = listingService.getListingById(id);
        List<ListingImages> images = listingImagesService.getListingImagesByListing(id);

        model.addAttribute("listing", listing);
        model.addAttribute("images", images);

        return "edit_listing";
    }


    /** ----------------------------------------------------------------------
     * PROVIDER'S LISTINGS PAGE
     * URL: /Listings/page/profile/{profileID}
     * -------------------------------------------------------------------- */
    @GetMapping("/profile/{profileID}")
    public String myListings(@PathVariable Long profileID, Model model) {

        List<Listing> listings = listingService.getListingsByProfile(profileID);

        model.addAttribute("listings", listings);
        model.addAttribute("profileID", profileID);

        return "my_listings";
    }


    /** ----------------------------------------------------------------------
 * CREATE LISTING — POST
 * URL: /Listings/page/create
 * -------------------------------------------------------------------- */
@PostMapping("/create")
public String createListingSubmit(@ModelAttribute Listing listing) {

    // TODO: Replace with logged-in user profile later
    Profile dummyProfile = new Profile();
    dummyProfile.setProfileId(1L);
    listing.setProfile(dummyProfile);

    listingService.addListing(listing);

    return "redirect:/Listings/page/" + listing.getId();
}


/** ----------------------------------------------------------------------
 * EDIT LISTING — POST
 * URL: /Listings/page/edit/{id}
 * -------------------------------------------------------------------- */
@PostMapping("/edit/{id}")
public String editListingSubmit(@PathVariable Long id, @ModelAttribute Listing listing) {

    // Keep original profile
    Listing original = listingService.getListingById(id);
    listing.setProfile(original.getProfileID());

    listingService.updateListing(id, listing);

    return "redirect:/Listings/page/" + id;
}

}
