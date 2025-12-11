package com.example.GetawaysNow.booking;


import java.util.List;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import com.example.GetawaysNow.Profile.Profile;
import com.example.GetawaysNow.Profile.ProfileRepository;
import com.example.GetawaysNow.listing.Listing;
import com.example.GetawaysNow.listing.ListingRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ProfileRepository profileRepository;
    private final ListingRepository listingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, ProfileRepository profileRepository, ListingRepository listingRepository) {
        this.bookingRepository = bookingRepository;
        this.profileRepository = profileRepository;
        this.listingRepository = listingRepository;
    }

    public Booking createBooking(Long profileId, Long listingId, Booking bookingDetails) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new EntityNotFoundException("Profile not found"));

        Listing listing = listingRepository.findById(listingId)
                .orElseThrow(() -> new EntityNotFoundException("Listing not found"));

        if (bookingDetails.getStartDate().isAfter(bookingDetails.getEndDate())) {
            throw new IllegalStateException("Start date must be before end date");
        }

        LocalDate start = bookingDetails.getStartDate();
        LocalDate end = bookingDetails.getEndDate();
        Long nights = ChronoUnit.DAYS.between(start, end);
        float pricePerNight = listing.getPricePerNight();
        float totalPrice = pricePerNight*nights;

        Booking newBooking = new Booking();
        newBooking.setProfile(profile);
        newBooking.setListing(listing);
        newBooking.setStartDate(start);
        newBooking.setEndDate(end);
        newBooking.setTotalPrice(BigDecimal.valueOf(totalPrice));

        return bookingRepository.save(newBooking);
    }



    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking with id:" + id + " not found"));
    }

    public List<Booking> getBookingsByProfileId(Long profileId) {
        return bookingRepository.findByProfileProfileId(profileId);
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking existingBooking = getBookingById(id);

        LocalDate start = bookingDetails.getStartDate();
        LocalDate end = bookingDetails.getEndDate();
        if (start.isAfter(end)) {
            throw new IllegalStateException("Start date must be before end date");
        }

        long nights = ChronoUnit.DAYS.between(start,end);
        float pricePerNight = existingBooking.getListing().getPricePerNight();
        float totalPrice = pricePerNight*nights;
        
        existingBooking.setStartDate(start);
        existingBooking.setEndDate(end);
        existingBooking.setTotalPrice(BigDecimal.valueOf(totalPrice));

        return bookingRepository.save(existingBooking);
    }

    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new EntityNotFoundException("Booking with id:" + id + " not found");
        }
        bookingRepository.deleteById(id);
    }


}
