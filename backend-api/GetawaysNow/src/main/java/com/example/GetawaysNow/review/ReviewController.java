package com.example.GetawaysNow.review;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.GetawaysNow.Profile.Profile;
import com.example.GetawaysNow.Profile.ProfileRepository;
import com.example.GetawaysNow.listing.Listing;
import com.example.GetawaysNow.listing.ListingRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ListingRepository listingRepository;
    private final ProfileRepository profileRepository;

    public ReviewController(
            ReviewService reviewService,
            ListingRepository listingRepository,
            ProfileRepository profileRepository
    ) {
        this.reviewService = reviewService;
        this.listingRepository = listingRepository;
        this.profileRepository = profileRepository;
    }

    @PostMapping("/add")
    public String addReview(@RequestParam Long listingId,
                            @RequestParam String comment,
                             HttpSession session,
                            Model model) {
                    
        Long profileId = (Long) session.getAttribute("profileId");

        if (profileId == null) {
            model.addAttribute("errorMessage", "You must be logged in to create a listing.");
            return "login";
        }

        // Attach logged-in profile
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Logged-in profile not found"));

        Listing listing = listingRepository.findById(listingId)
                .orElseThrow(() -> new RuntimeException("Listing not found"));

        reviewService.createReview(listing, profile, comment);

        return "redirect:/listing/" + listingId;
    }

    @PostMapping("/reply")
    public String replyToReview(@RequestParam Long listingId,
                                @RequestParam Long parentId,
                                @RequestParam String comment,
                                 HttpSession session,
                                Model model) {

       Long profileId = (Long) session.getAttribute("profileId");

        if (profileId == null) {
            model.addAttribute("errorMessage", "You must be logged in to create a listing.");
            return "login";
        }

        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Logged-in profile not found"));

        Listing listing = listingRepository.findById(listingId)
                  .orElseThrow(() -> new RuntimeException("Listing not found"));
        
        if (!listing.getProfileID().equals(profileId)) {
          return "redirect:/listing/" + listingId + "?error=notOwner";
      }


        reviewService.replyToReview(parentId, listing, profile, comment);

        return "redirect:/listing/" + listingId;
    }
}
