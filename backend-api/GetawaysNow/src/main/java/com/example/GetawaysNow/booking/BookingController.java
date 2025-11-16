package com.example.GetawaysNow.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController{
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @GetMapping("/checkout/profile/{profileId}/listing/{listingId}")
    public String showCheckoutForm(@PathVariable Long profileId, @PathVariable Long listingId, Model model){
        model.addAttribute("booking", new Booking());
        model.addAttribute("profileId", profileId);
        model.addAttribute("listingId", listingId);
        return "checkout";
    }

    @PostMapping("/booking/create")
    public String createBooking(Booking booking, @RequestParam Long profileId, @RequestParam Long listingId){
        bookingService.createBooking(profileId, listingId, booking);
        return "redirect:/profile/" + profileId;
    }

}