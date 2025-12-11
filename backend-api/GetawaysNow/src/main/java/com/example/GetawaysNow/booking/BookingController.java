package com.example.GetawaysNow.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.GetawaysNow.listing.Listing;
import com.example.GetawaysNow.listing.ListingRepository;
import com.example.GetawaysNow.listingImages.ListingImages;
import com.example.GetawaysNow.listingImages.ListingImagesRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController{
    private final BookingService bookingService;
    private final ListingRepository listingRepository;
    private final ListingImagesRepository listingImagesRepository;

    @Autowired
    public BookingController(BookingService bookingService, ListingRepository listingRepository, ListingImagesRepository listingImagesRepository){
        this.bookingService = bookingService;
        this.listingRepository = listingRepository;
        this.listingImagesRepository = listingImagesRepository;
    }

    @GetMapping("/checkout/listing/{listingId}")
    public String showCheckoutForm(@PathVariable Long listingId, HttpSession session, Model model){
        Long profileId = (Long) session.getAttribute("profileId");
        if (profileId == null){
            return "redirect:/login";
        }

        Listing listing = listingRepository.findById(listingId).orElseThrow(() -> new EntityNotFoundException("Listing not found"));
        List<ListingImages> images = listingImagesRepository.findBylistingID(listing);

        model.addAttribute("images", images);
        model.addAttribute("listing", listing);
        
        model.addAttribute("booking", new Booking());
        model.addAttribute("profileId", profileId);
        model.addAttribute("listingId", listingId);

        return "checkout";
    }

    @PostMapping("/booking/create")
    public String createBooking(Booking booking, @RequestParam Long listingId, HttpSession session){
        Long profileId = (Long) session.getAttribute("profileId");
        if (profileId == null){
            return "redirect:/login";
        }

        bookingService.createBooking(profileId, listingId, booking);

        return "redirect:/profile/" + profileId;
    }
}