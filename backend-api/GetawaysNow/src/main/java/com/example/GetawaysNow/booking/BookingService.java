package com.example.getawaysnow.booking;

import com.example.GetawaysNow.profile.Profile;
import com.example.GetawaysNow.profile.ProfileRepository;
import com.example.GetawaysNow.listing.Listing;
import com.example.GetawaysNow.listing.ListingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        Booking newBooking = new Booking();
        newBooking.setProfile(profile);
        newBooking.setListing(listing);
        newBooking.setStartDate(bookingDetails.getStartDate());
        newBooking.setEndDate(bookingDetails.getEndDate());
        newBooking.setTotalPrice(bookingDetails.getTotalPrice());

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
        existingBooking.setStartDate(bookingDetails.getStartDate());
        existingBooking.setEndDate(bookingDetails.getEndDate());
        if (existingBooking.getStartDate().isAfter(existingBooking.getEndDate())) {
            throw new IllegalStateException("Start date must be before end date");
        }

        return bookingRepository.save(existingBooking);
    }

    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new EntityNotFoundException("Booking with id:" + id + " not found");
        }
        bookingRepository.deleteById(id);
    }
}
