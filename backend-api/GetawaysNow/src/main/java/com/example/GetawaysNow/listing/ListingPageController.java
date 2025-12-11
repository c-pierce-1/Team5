package com.example.GetawaysNow.listing;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.example.GetawaysNow.Profile.ProfileRepository;
import com.example.GetawaysNow.booking.Booking;
import com.example.GetawaysNow.booking.BookingService;
import com.example.GetawaysNow.listingImages.ListingImages;
import com.example.GetawaysNow.listingImages.ListingImagesService;
import com.example.GetawaysNow.review.Review;
import com.example.GetawaysNow.review.ReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/") 
public class ListingPageController {

    private final ListingService listingService;
    private final ListingImagesService listingImagesService;
    private final ProfileRepository profileRepository;
    private final ReviewService reviewService;
    private final BookingService bookingService;

    public ListingPageController(
            ListingService listingService,
            ListingImagesService listingImagesService,
            ProfileRepository profileRepository,
            ReviewService reviewService,
            BookingService bookingService) {
        this.listingService = listingService;
        this.listingImagesService = listingImagesService;
        this.profileRepository = profileRepository;
        this.reviewService = reviewService;
        this.bookingService = bookingService;
    }

    private void addSessionUser(Model model, HttpSession session) {
        Object username = session.getAttribute("username");
        if (username != null) {
            model.addAttribute("username", username.toString());
        }
    }

    /*--------------------------------------------------------------
     VIEW LISTING PAGE
    --------------------------------------------------------------*/
    @GetMapping("/listing/{id}")
    public String viewListing(@PathVariable Long id, Model model, HttpSession session) {

        addSessionUser(model, session);

        Listing listing = listingService.getListingById(id);
        if (listing == null) {
            return "error/404";
        }

        List<ListingImages> images = listingImagesService.getListingImagesByListing(id);
        List<Review> reviews = reviewService.getTopLevelReviews(listing);

        model.addAttribute("listing", listing);
        model.addAttribute("images", images);
        model.addAttribute("reviews", reviews);

        return "view_listing";
    }

    /*--------------------------------------------------------------
     CREATE LISTING FORM
    --------------------------------------------------------------*/
    @GetMapping("/listing/create")
    public String createListingForm(Model model, HttpSession session) {

        addSessionUser(model, session);

        // enforce login
        Long profileId = (Long) session.getAttribute("profileId");
        if (profileId == null) {
            return "redirect:/login";
        }

        model.addAttribute("listing", new Listing());
        return "create_listing";
    }

    /*--------------------------------------------------------------
     CREATE LISTING SUBMIT
    --------------------------------------------------------------*/
    @PostMapping("/listing/create")
    public String createListingSubmit(
            @ModelAttribute Listing listing,
            @RequestParam(value = "images", required = false) MultipartFile[] images,
            Model model,
            HttpSession session) {

        addSessionUser(model, session);

        Long profileId = (Long) session.getAttribute("profileId");

        if (profileId == null) {
            model.addAttribute("errorMessage", "You must be logged in to create a listing.");
            return "login";
        }

        // Attach logged-in profile
        Profile userProfile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Logged-in profile not found"));

        listing.setProfile(userProfile);

        // Address duplication check
        if (listingService.existsByAddressAndCity(listing.getAddress(), listing.getCity())) {
            model.addAttribute("listing", listing);
            model.addAttribute("errorMessage",
                    "A listing already exists at this address in this city.");
            return "create_listing";
        }

        // Save listing
        listingService.addListing(listing);

        // Save images
        if (images != null) {
            for (MultipartFile file : images) {
                if (!file.isEmpty()) {
                    listingImagesService.saveImageFile(listing, file);
                }
            }
        }

        return "redirect:/listing/" + listing.getId();
    }

    /*--------------------------------------------------------------
     EDIT LISTING FORM
    --------------------------------------------------------------*/
    @GetMapping("/listing/{id}/edit")
    public String editListingForm(@PathVariable Long id, Model model, HttpSession session) {

        addSessionUser(model, session);

        Long profileId = (Long) session.getAttribute("profileId");
        if (profileId == null) {
            return "redirect:/login";
        }

        Listing listing = listingService.getListingById(id);
        List<ListingImages> images = listingImagesService.getListingImagesByListing(id);

        model.addAttribute("listing", listing);
        model.addAttribute("images", images);

        return "edit_listing";
    }

    /*--------------------------------------------------------------
     EDIT LISTING SUBMIT
    --------------------------------------------------------------*/
    @PostMapping("/listing/{id}/edit")
    public String editListingSubmit(
            @PathVariable Long id,
            @ModelAttribute Listing listing,
            @RequestParam(value = "images", required = false) MultipartFile[] newImages,
            @RequestParam(value = "deleteImages", required = false) List<Long> deleteImages,
            HttpSession session,
            Model model) {

        addSessionUser(model, session);

        Long profileId = (Long) session.getAttribute("profileId");
        if (profileId == null) return "redirect:/login";

        Listing existing = listingService.getListingById(id);

        // Keep original profile
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
     MY LISTINGS (Logged-in user only)
    --------------------------------------------------------------*/
   @GetMapping("/my_listings")
    public String myListings(Model model, HttpSession session) {

        // Add username for navbar
        addSessionUser(model, session);

        // Make sure user is logged in
        Long profileId = (Long) session.getAttribute("profileId");
        if (profileId == null) {
            return "redirect:/login";
        }

        // Get listings owned by the logged-in user
        List<Listing> listings = listingService.getListingsByProfile(profileId);
        model.addAttribute("listings", listings);

        Map<String, List<ListingImages>> listingImagesMap =
                listings.stream()
                        .collect(Collectors.toMap(
                                l -> l.getId().toString(),
                                l -> listingImagesService.getListingImagesByListing(l.getId())
                        ));

        List<Long> listingIds = listings.stream()
                                .map(Listing::getId)
                                .collect(Collectors.toList());

        List<Booking> bookings = bookingService.getBookingsForListingIds(listingIds);


        model.addAttribute("listingImagesMap", listingImagesMap);

        model.addAttribute("bookings", bookings);



        return "my_listings";
    }


}
